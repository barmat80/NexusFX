package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TextAreaRow {
    private Label label;
    private TextArea textArea;

    protected TextAreaRow() {}

    protected TextAreaRow addLabel(Label lbl) {
        this.label = lbl;
        return this;
    }

    protected TextAreaRow build(int width, int height, boolean isEditable) {
        textArea = new TextArea();
        textArea.setPrefWidth(width);
        textArea.setMinWidth(width);
        textArea.setMaxWidth(width);
        textArea.setPrefHeight(height);
        textArea.setMinHeight(height);
        textArea.setMaxHeight(height);
        textArea.setEditable(isEditable);
        return this;
    }

    protected void setStringProperty(StringProperty bindingProperty) {
        textArea.textProperty().bindBidirectional(bindingProperty);
    }

    protected void setEditableBinding(BooleanBinding editableBinding) {
        textArea.editableProperty().bind(editableBinding);
    }

    public Label getLabel() {
        return label;
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
