package com.maemlab.nexusfx.widgets;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatters {

    private Formatters(){}

    public static final String EURO = "\u20AC";
    public static final String SPACE = " ";

    public static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,##0");
    //public static final DecimalFormat INTEGER_FORMAT_WITH_CURRENCY = new DecimalFormat(EURO  + SPACE + "###,##0");
    public static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("###,##0.00");
    public static final DecimalFormat DOUBLE_FORMAT_WITH_CURRENCY = new DecimalFormat(EURO + SPACE + "###,##0.00");

    public static final DateTimeFormatter IT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy",Locale.ITALIAN);
    public static final DateTimeFormatter IT_DATETIME_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss",Locale.ITALIAN);
}
