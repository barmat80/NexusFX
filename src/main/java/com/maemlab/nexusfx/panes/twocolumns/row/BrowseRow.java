package com.maemlab.nexusfx.panes.twocolumns.row;

import com.maemlab.nexusfx.panes.browse.IconButton;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.Consumer;

public class BrowseRow {
    private Label label;
    private TextField textField;
    private IconButton btn;

    protected BrowseRow() {}

    protected BrowseRow addLabel(Label lbl) {
        this.label = lbl;
        return this;
    }

    protected BrowseRow build(String tooltip, Node icon, Runnable runnable, Consumer<Runnable> runnableConsumer, int width, boolean isEditable) {
        textField = new TextField();
        textField.setPrefWidth(width);
        textField.setMinWidth(width);
        textField.setMaxWidth(width);
        textField.setEditable(isEditable);

        btn = new IconButton(tooltip, runnable, runnableConsumer, icon);

        return this;
    }

    protected void bindStringProperty(StringProperty bindingProperty) {
        textField.textProperty().bindBidirectional(bindingProperty);
    }

    public void setStringFormatter(TextFormatter<String> formatter) {
        textField.setTextFormatter(formatter);
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

    public IconButton getButton() {return btn;}
}
