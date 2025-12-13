package com.maemlab.nexusfx.formatters;

import com.maemlab.nexusfx.filters.NumberFilter;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.text.NumberFormat;

public class IntegerFormatter {

    private final TextFormatter<Integer> formatter;

    /**
     * Creates an IntegerFormatter with a custom NumberFormat.
     *
     * @param format The NumberFormat to use for formatting integers
     */
    public IntegerFormatter(NumberFormat format) {
        NumberFilter filter = new NumberFilter();
        StringConverter<Integer> converter = new StringConverter<>() {
            @Override
            public String toString(Integer i) {
                return i == null ? "" : format.format(i);
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

    /**
     * Creates an IntegerFormatter with default integer formatting.
     */
    public IntegerFormatter() {
        this(NumberFormat.getIntegerInstance());
    }

    public TextFormatter<Integer> getTextFormatter() {
        return formatter;
    }
}
