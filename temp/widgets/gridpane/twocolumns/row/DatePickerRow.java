package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;

public class DatePickerRow {
    private final Label label;
    private DatePicker datePicker;

    protected DatePickerRow(Label lbl) {
        this.label = lbl;
    }

    protected DatePickerRow build(int width, boolean isDisabled) {
        datePicker = new DatePicker();
        datePicker.setPrefWidth(width);
        datePicker.setMinWidth(width);
        datePicker.setMaxWidth(width);
        datePicker.setDisable(isDisabled);
        return this;
    }

    protected void setProperty(ObjectProperty<LocalDate> property) {
        if (property != null && property.get() != null) {
            datePicker.setValue(property.get());
        }
    }

    protected void setListener(ChangeListener<LocalDate> listener) {
        datePicker.valueProperty().addListener(listener);
    }

    public Label getLabel() {
        return label;
    }
    public DatePicker getDatePicker() {
        return datePicker;
    }
}
