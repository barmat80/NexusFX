package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TextAreaRowBuilder {
    private int width;
    private int height;

    private StringProperty stringProperty;
    private BooleanBinding editableBinding;

    private String label;
    private boolean isEditable;

    private TextAreaRowBuilder() {
        this.isEditable = true;
        this.width = 100; // default width
        this.height = 100; // default height
    }

    public static TextAreaRowBuilder textAreaRow() {
        return new TextAreaRowBuilder();
    }

    public TextAreaRowBuilder width(int width) {
        if(width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
        return this;
    }

    public TextAreaRowBuilder height(int height) {
        if(height <= 0) throw new IllegalArgumentException("Height must be positive");
        this.height = height;
        return this;
    }

    public TextAreaRowBuilder stringProperty(StringProperty property) {
        this.stringProperty = property;
        return this;
    }

    public TextAreaRowBuilder label(String label) {
        this.label = label;
        return this;
    }

    public TextAreaRowBuilder setDisabled() {
        this.isEditable = false;
        return this;
    }

    public TextAreaRowBuilder setEditableBinding(BooleanBinding binding) {
        this.editableBinding = binding;
        return this;
    }

    public TextAreaRow build() {
        var row = new TextAreaRow().addLabel(buildLabel()).build(this.width, this.height, this.isEditable);
        if(stringProperty != null) row.setStringProperty(stringProperty);
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
}
