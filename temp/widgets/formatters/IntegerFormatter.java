package com.maemlab.nexusfx.widgets.formatters;

import com.maemlab.nexusfx.widgets.Formatters;
import com.maemlab.nexusfx.widgets.filters.NumberFilter;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class IntegerFormatter {

    private final TextFormatter<Integer> formatter;

    public IntegerFormatter() {
        NumberFilter filter = new NumberFilter();
        StringConverter<Integer> converter = new StringConverter<>() {
            @Override
            public String toString(Integer i) {
                return Formatters.INTEGER_FORMAT.format(i);
            }

            @Override
            public Integer fromString(String s) {
                if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                    return 0;
                } else {
                    return Integer.valueOf(s);
                }
            }
        };

        formatter = new TextFormatter<>(converter, 0, filter);
    }

    public TextFormatter<Integer> getTextFormatter() {
        return formatter;
    }
}
