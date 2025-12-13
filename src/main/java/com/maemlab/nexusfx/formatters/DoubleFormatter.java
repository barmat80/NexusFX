package com.maemlab.nexusfx.formatters;

import com.maemlab.nexusfx.filters.NumberFilter;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.text.NumberFormat;

public class DoubleFormatter {

    private final TextFormatter<Double> formatter;

    public DoubleFormatter(NumberFormat format) {
        NumberFilter filter = new NumberFilter();
        StringConverter<Double> converter = new StringConverter<>() {
            @Override
            public String toString(Double i) {
                return i == null ? "" : format.format(i);
            }

            @Override
            public Double fromString(String s) {
//                PrintUtil.debug("fromString: " + s);
                if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                    return 0.0;
                } else {
                    if(s.contains(","))
                        s = s.replace(",", ".");
                    return Double.valueOf(s);
                }
            }
        };

        formatter = new TextFormatter<>(converter, 0.0, filter);
    }

    /**
     * Creates an DoubleFormatter with default double formatting.
     */
    public DoubleFormatter() {
        this(NumberFormat.getIntegerInstance());
    }

    public TextFormatter<Double> getTextFormatter() {
        return formatter;
    }
}
