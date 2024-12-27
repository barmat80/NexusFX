package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import javafx.beans.property.BooleanProperty;

public class CheckBoxRowBuilder {
    private String text;

    private BooleanProperty booleanProperty;
    private boolean isDisabled;

    private CheckBoxRowBuilder() {
        this.isDisabled = false;
    }

    public static CheckBoxRowBuilder checkBoxRow() {
        return new CheckBoxRowBuilder();
    }

    public CheckBoxRowBuilder text(String text) {
        this.text = text;
        return this;
    }

    public CheckBoxRowBuilder booleanProperty(BooleanProperty property) {
        this.booleanProperty = property;
        return this;
    }

    public CheckBoxRowBuilder setDisabled() {
        this.isDisabled = true;
        return this;
    }

    public CheckboxRow build() {
        var row = new CheckboxRow().build(this.text, this.isDisabled);
        row.setBooleanProperty(booleanProperty);
        return row;
    }
}
