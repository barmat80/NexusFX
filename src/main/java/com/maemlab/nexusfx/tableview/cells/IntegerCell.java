package com.maemlab.nexusfx.tableview.cells;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A convenience subclass of {@link FormattedNumberCell} specifically designed
 * for displaying integer values with default formatting.
 *
 * <p>This class provides constructors with predefined currency formatters based
 * on the default locale or a specified locale, eliminating the need to manually
 * create {@link NumberFormat} instances for common integer formatting needs.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * TableColumn<Product, Integer> itemColumn = new TableColumn<>("Items");
 *
 * // Using default locale
 * itemColumn.setCellFactory(tc -> new IntegerCell<>());
 *
 * // Using specific locale (Italian formatting)
 * itemColumn.setCellFactory(tc -> new IntegerCell<>(Locale.ITALY));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see FormattedNumberCell
 * @see NumberFormat#getIntegerInstance()
 */
public class IntegerCell<T> extends FormattedNumberCell<T>  {
    /**
     * Constructs a new {@code IntegerCell} with the default locale's formatter.
     */
    public IntegerCell() {
        super(NumberFormat.getIntegerInstance());
    }

    /**
     * Constructs a new {@code IntegerCell} with the specified locale's formatter.
     *
     * @param locale the {@link Locale} to use for double formatting.
     *               Must not be {@code null}.
     * @throws NullPointerException if {@code locale} is {@code null}
     */
    public IntegerCell(Locale locale) {
        super(NumberFormat.getIntegerInstance(locale));
    }
}
