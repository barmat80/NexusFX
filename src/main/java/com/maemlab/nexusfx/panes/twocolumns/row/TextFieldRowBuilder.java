package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TextFieldRowBuilder implements TextFieldRowBuilders.TextField, TextFieldRowBuilders.Formatter, TextFieldRowBuilders.Optionals {
    private int width;

    private StringProperty stringProperty;
    private IntegerProperty integerProperty;
    private DoubleProperty doubleProperty;
    private BooleanBinding editableBinding;

    private String label;
    private StringProperty extraLabelProperty;
    private String extraLabelString;
    private boolean isEditable;

    private TextFieldRowBuilder() {
        this.isEditable = true;
        this.width = 100; // default width
    }

    public static TextFieldRowBuilders.TextField textFieldRow() {
        return new TextFieldRowBuilder();
    }

    @Override
    public TextFieldRowBuilders.Formatter width(int width) {
        if(width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals withoutProperty() {
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals stringProperty(StringProperty property) {
        this.stringProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals integerProperty(IntegerProperty property) {
        this.integerProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals doubleProperty(DoubleProperty property) {
        this.doubleProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals label(String label) {
        this.label = label;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals setDisabled() {
        this.isEditable = false;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals setEditableBinding(BooleanBinding binding) {
        this.editableBinding = binding;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals extraLabel(StringProperty extraLabel) {
        this.extraLabelProperty = extraLabel;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals extraLabel(String extraLabel) {
        this.extraLabelString = extraLabel;
        return this;
    }

    @Override
    public TextFieldRow build() {
        var row = new TextFieldRow().addLabel(buildLabel()).addExtraLabel(buildExtraLabel()).build(this.width, this.isEditable);
        if(stringProperty != null) row.setStringProperty(stringProperty);
        if(integerProperty != null) row.setIntegerProperty(integerProperty);
        if(doubleProperty != null) row.setDoubleProperty(doubleProperty);
        if(editableBinding != null) row.setEditableBinding(editableBinding);
        return row;
    }

    private Label buildLabel() {
        Label lbl = null;
        if (this.label != null) {
            lbl = new Label(this.label);
            GridPane.setHalignment(lbl, HPos.RIGHT);
        }
        return lbl;
    }

    private Label buildExtraLabel() {
        Label lbl = null;
        if (this.extraLabelProperty != null || this.extraLabelString != null) {
            lbl = new Label();
            if (this.extraLabelProperty != null) lbl.textProperty().bindBidirectional(this.extraLabelProperty);
            if (this.extraLabelString != null) lbl.setText(extraLabelString);
            GridPane.setHalignment(lbl, HPos.LEFT);
        }
        return lbl;
    }
}
