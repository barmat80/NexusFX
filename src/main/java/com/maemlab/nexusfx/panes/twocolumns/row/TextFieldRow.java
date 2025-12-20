package com.maemlab.nexusfx.panes.twocolumns.row;

import com.maemlab.nexusfx.formatters.DoubleFormatter;
import com.maemlab.nexusfx.formatters.IntegerFormatter;
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
        textField.textProperty().bindBidirectional(bindingProperty);
    }

    @SuppressWarnings("unchecked")
    protected void setIntegerProperty(IntegerProperty property) {
        var formatter = (TextFormatter<Integer>) textField.getTextFormatter();
        if (formatter == null) {
            formatter = new IntegerFormatter().getTextFormatter();
            textField.setTextFormatter(formatter);
        }
        formatter.valueProperty().bindBidirectional(property.asObject());
    }

    @SuppressWarnings("unchecked")
    protected void setDoubleProperty(DoubleProperty property) {
        // Get existing formatter or create a temporary one for binding
        var formatter = (TextFormatter<Double>) textField.getTextFormatter();
        if (formatter == null) {
            formatter = new DoubleFormatter().getTextFormatter();
            textField.setTextFormatter(formatter);
        }
        formatter.valueProperty().bindBidirectional(property.asObject());
    }

    protected void setStringFormatter(TextFormatter<String> formatter) {
        textField.setTextFormatter(formatter);
    }

    protected void setIntegerFormatter(TextFormatter<Integer> formatter) {
        textField.setTextFormatter(formatter);
        textField.setAlignment(Pos.CENTER_RIGHT);
    }

    protected void setDoubleFormatter(TextFormatter<Double> formatter) {
        textField.setTextFormatter(formatter);
        textField.setAlignment(Pos.CENTER_RIGHT);
    }

    protected void setEditableBinding(BooleanBinding editableBinding) {
        textField.editableProperty().bind(editableBinding);
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }

    public Node createHBox() {
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
