package com.maemlab.commis.widgets.formatters;

import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends StringConverter<LocalDate> {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public String toString(LocalDate object) {
        if (object != null) {
            return dateFormatter.format(object);
        }
        return "";
    }

    @Override
    public LocalDate fromString(String string) {
        if (string != null && !string.isEmpty()) {
            return LocalDate.parse(string, dateFormatter);
        }
        return null;
    }
}
