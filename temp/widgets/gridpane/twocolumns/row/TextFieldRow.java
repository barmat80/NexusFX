package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import com.maemlab.nexusfx.data.beans.Bean;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanConverter;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSelectionHandler;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSuggesterCallback;
import com.maemlab.nexusfx.data.beans.autocompletion.StringSuggesterCallback;
import com.maemlab.nexusfx.widgets.autocompletion.AutoCompletionBinding;
import com.maemlab.nexusfx.widgets.autocompletion.TextFields;
import com.maemlab.nexusfx.widgets.filters.UpperCaseFilter;
import com.maemlab.nexusfx.widgets.formatters.DoubleFormatter;
import com.maemlab.nexusfx.widgets.formatters.IntegerFormatter;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;

public class TextFieldRow {
    private Label label;
    private TextField textField;
    private Label extraLabel;

    protected TextFieldRow() {}

    protected TextFieldRow addLabel(Label lbl) {
        this.label = lbl;
        return this;
    }

    protected TextFieldRow addExtraLabel(Label lbl) {
        this.extraLabel = lbl;
        return this;
    }

    protected TextFieldRow build(int width, boolean isEditable) {
        textField = new TextField();
        textField.setPrefWidth(width);
        textField.setMinWidth(width);
        textField.setMaxWidth(width);
        textField.setEditable(isEditable);
        return this;
    }

    protected void setStringProperty(StringProperty bindingProperty) {
        textField.setTextFormatter(new TextFormatter<>(new UpperCaseFilter()));
        textField.textProperty().bindBidirectional(bindingProperty);
    }

    protected void setIntegerProperty(IntegerProperty property) {
        var formatter = new IntegerFormatter().getTextFormatter();
        textField.setTextFormatter(formatter);
        formatter.valueProperty().bindBidirectional(property.asObject());
        textField.setAlignment(Pos.CENTER_RIGHT);
    }

    protected void setDoubleProperty(DoubleProperty property) {
        var formatter = new DoubleFormatter().getTextFormatter();
        textField.setTextFormatter(formatter);
        formatter.valueProperty().bindBidirectional(property.asObject());
        textField.setAlignment(Pos.CENTER_RIGHT);
    }

    protected void setDisableBinding(BooleanBinding disableBinding) {
        textField.disableProperty().bind(disableBinding);
    }

    protected void setBeanSuggester(BeanSuggesterCallback suggester, BeanSelectionHandler handler, BeanConverter converter) {
        AutoCompletionBinding<Bean> acb = TextFields.bindAutoCompletion(textField, suggester, converter);
        acb.setOnAutoCompleted(handler);
    }

    protected void setStringSuggester(StringSuggesterCallback suggester) {
        TextFields.bindAutoCompletion(textField, suggester);
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }

    public Node getHBox() {
        var hbox = new HBox();
        hbox.getChildren().add(textField);
        if(extraLabel != null) {
            hbox.getChildren().add(extraLabel);
            HBox.setMargin(extraLabel, new Insets(8.0, 0.0, 0.0, 10.0));
        }
        return hbox;
    }

    public boolean hasExtraLabel() {
        return extraLabel != null;
    }
}
