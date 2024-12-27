package com.maemlab.nexusfx.widgets.formatters;

import com.maemlab.nexusfx.widgets.Formatters;
import com.maemlab.nexusfx.widgets.filters.NumberFilter;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class DoubleFormatter {

    private final TextFormatter<Double> formatter;

    public DoubleFormatter() {
        NumberFilter filter = new NumberFilter();
        StringConverter<Double> converter = new StringConverter<>() {
            @Override
            public String toString(Double i) {
//                PrintUtil.debug("toString: " + i);
//                PrintUtil.debug("toString: " + Formatters.DOUBLE_FORMAT.format(i));
                return Formatters.DOUBLE_FORMAT.format(i);
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

    public TextFormatter<Double> getTextFormatter() {
        return formatter;
    }
}
