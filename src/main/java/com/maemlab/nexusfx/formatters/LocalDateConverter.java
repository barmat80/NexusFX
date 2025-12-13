package com.maemlab.nexusfx.formatters;

import javafx.util.StringConverter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter extends StringConverter<LocalDate> {

    private final DateTimeFormatter dateFormatter;

    public LocalDateConverter() {
        this("dd-MM-yyyy");
    }

    public LocalDateConverter(String pattern) {
        this.dateFormatter = DateTimeFormatter.ofPattern(pattern);
    }

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
