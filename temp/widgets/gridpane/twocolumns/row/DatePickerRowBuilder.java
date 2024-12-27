package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;

public class DatePickerRowBuilder {
    private String label;
    private int width;
    private boolean isDisabled;
    private ObjectProperty<LocalDate> localDateProperty;
    private ChangeListener<LocalDate> listener;

    private DatePickerRowBuilder() {
        this.isDisabled = false;
    }

    public static DatePickerRowBuilder datePickerRow() {
        return new DatePickerRowBuilder();
    }

    public DatePickerRowBuilder label(String label) {
        this.label = label;
        return this;
    }

    public DatePickerRowBuilder width(int width) {
        this.width = width;
        return this;
    }

    public DatePickerRowBuilder setDisabled() {
        this.isDisabled = true;
        return this;
    }
    
    public DatePickerRowBuilder dateProperty(ObjectProperty<LocalDate> property) {
        this.localDateProperty = property;
        return this;
    }

    public DatePickerRowBuilder listener(ChangeListener<LocalDate> listener) {
        this.listener = listener;
        return this;
    }

    public DatePickerRow build() {
        var row = new DatePickerRow(buildLabel()).build(this.width, this.isDisabled);
        row.setProperty(localDateProperty);
        if(listener != null) row.setListener(listener);
        return row;
    }

    private Label buildLabel() {
        Label lbl = null;
        if(this.label != null) {
            lbl = new Label(this.label);
            GridPane.setHalignment(lbl, HPos.RIGHT);
        }
        return lbl;
    }
}
