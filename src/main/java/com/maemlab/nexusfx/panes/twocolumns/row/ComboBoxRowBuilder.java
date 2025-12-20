package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.Property;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class ComboBoxRowBuilder<T> {
    private int width;
    private Runnable action;
    private final List<T> choices;
    private T defaultValue;
    private Property<T> bindProperty;
    private Property<T> bindBidirectionalProperty;
    private boolean isDisabled;
    private String label;
    private StringBinding extraLabelBinding;

    private ComboBoxRowBuilder() {
        this.isDisabled = false;
        this.choices = new ArrayList<>();
        this.width = 100; // default width
    }

    public static <T> ComboBoxRowBuilder<T> comboBoxRow() {
        return new ComboBoxRowBuilder<>();
    }

    public ComboBoxRowBuilder<T> width(int width) {
        if(this.width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
        return this;
    }

    public ComboBoxRowBuilder<T> action(Runnable action) {
        this.action = action;
        return this;
    }

    public ComboBoxRowBuilder<T> choices(List<T> choices) {
        this.choices.addAll(choices);
        return this;
    }

    public ComboBoxRowBuilder<T> defaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public ComboBoxRowBuilder<T> bindSelectionTo(Property<T> bindingProperty) {
        this.bindProperty = bindingProperty;
        return this;
    }

    public ComboBoxRowBuilder<T> bindBidirectionalSelectionTo(Property<T> bindingProperty) {
        this.bindBidirectionalProperty = bindingProperty;
        return this;
    }

    public ComboBoxRowBuilder<T> label(String label) {
        this.label = label;
        return this;
    }

    public ComboBoxRowBuilder<T> extraLabelBinding(StringBinding extraLabelBinding) {
        this.extraLabelBinding = extraLabelBinding;
        return this;
    }

    public ComboBoxRowBuilder<T> setDisabled() {
        this.isDisabled = true;
        return this;
    }

    public ComboBoxRow<T> build() {
        var row = new ComboBoxRow<T>().withLabel(buildLabel()).withExtraLabel(buildExtraLabel()).build(width, choices, isDisabled);
        if(action != null) row.setAction(action);
        if(defaultValue != null) row.setDefaultValue(defaultValue);
        if(bindProperty != null) row.bindSelectionTo(bindProperty);
        if(bindBidirectionalProperty != null) row.bindBidirectionalSelectionTo(bindBidirectionalProperty);
        return row;
    }

    private Label buildLabel() {
        Label lbl = null;
        if (label != null) {
            lbl = new Label(label);
            GridPane.setHalignment(lbl, HPos.RIGHT);
        }
        return lbl;
    }

    private Label buildExtraLabel() {
        Label lbl = null;
        if (extraLabelBinding != null) {
            lbl = new Label();
            lbl.textProperty().bind(extraLabelBinding);
            GridPane.setHalignment(lbl, HPos.LEFT);
        }
        return lbl;
    }
}
