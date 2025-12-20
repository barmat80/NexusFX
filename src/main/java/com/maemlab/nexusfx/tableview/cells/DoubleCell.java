package com.maemlab.nexusfx.tableview.cells;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * A convenience subclass of {@link FormattedNumberCell} specifically designed
 * for displaying double values with default formatting.
 *
 * <p>This class provides constructors with predefined currency formatters based
 * on the default locale or a specified locale, eliminating the need to manually
 * create {@link DecimalFormat} instances for common double formatting needs.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * TableColumn<Product, Double> weightColumn = new TableColumn<>("Weight");
 *
 * // Using default locale
 * weightColumn.setCellFactory(tc -> new DoubleCell<>());
 *
 * // Using specific locale (Italian formatting)
 * weightColumn.setCellFactory(tc -> new DoubleCell<>(Locale.ITALY));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see FormattedNumberCell
 * @see DecimalFormat#getNumberInstance()
 */
public class DoubleCell<T> extends FormattedNumberCell<T>  {
    /**
     * Constructs a new {@code DoubleCell} with the default locale's formatter.
     */
    public DoubleCell() {
        super(DecimalFormat.getNumberInstance());
    }

    /**
     * Constructs a new {@code DoubleCell} with the specified locale's formatter.
     *
     * @param locale the {@link Locale} to use for double formatting.
     *               Must not be {@code null}.
     * @throws NullPointerException if {@code locale} is {@code null}
     */
    public DoubleCell(Locale locale) {
        super(DecimalFormat.getNumberInstance(locale));
    }
}
