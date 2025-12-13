package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class LabelRowBuilder {
    private int valueWidth;
    private String description;
    private String value;
    private StringBinding binding;
    private StringProperty stringProperty;
    private List<String> descriptionStyles;
    private List<String> valueStyles;

    private LabelRowBuilder() {
        this.valueWidth = 100; // default width
        this.descriptionStyles = new ArrayList<>();
        this.valueStyles = new ArrayList<>();
    }

    public static LabelRowBuilder labelRow() {return new LabelRowBuilder();}

    public LabelRowBuilder description(String description) {
        this.description = description;
        return this;
    }

    public LabelRowBuilder descriptionStyles(List<String> styles) {
        this.descriptionStyles = styles;
        return this;
    }

    public LabelRowBuilder value(String value) {
        this.value = value;
        return this;
    }

    public LabelRowBuilder valueWidth(int width) {
        if(this.valueWidth <= 0) throw new IllegalArgumentException("Width must be positive");
        this.valueWidth = width;
        return this;
    }

    public LabelRowBuilder valueStyles(List<String> styles) {
        this.valueStyles = styles;
        return this;
    }

    public LabelRowBuilder valueBinding(StringBinding binding) {
        this.binding = binding;
        return this;
    }

    public LabelRowBuilder valueProperty(StringProperty stringProperty) {
        this.stringProperty = stringProperty;
        return this;
    }

    public LabelRow build() {
        var row = new LabelRow().build(description, value, valueWidth);
        if(!this.descriptionStyles.isEmpty()) row.setDescriptionStyles(this.descriptionStyles);
        if(!this.valueStyles.isEmpty()) row.setValueStyles(this.valueStyles);
        if(this.binding != null) row.setBinding(binding);
        if(this.stringProperty != null) row.setStringProperty(stringProperty);
        return row;
    }
}
