package com.maemlab.nexusfx.tableview.cells;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A convenience subclass of {@link FormattedNumberCell} specifically designed
 * for displaying currency values with default currency formatting.
 *
 * <p>This class provides constructors with predefined currency formatters based
 * on the default locale or a specified locale, eliminating the need to manually
 * create {@link NumberFormat} instances for common currency formatting needs.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * // Using default locale
 * TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
 * priceColumn.setCellFactory(tc -> new CurrencyCell<>());
 *
 * // Using specific locale (Italian Euro)
 * TableColumn<Product, Double> euroPriceColumn = new TableColumn<>("Price (EUR)");
 * euroPriceColumn.setCellFactory(tc -> new CurrencyCell<>(Locale.ITALY));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see FormattedNumberCell
 * @see NumberFormat#getCurrencyInstance()
 */
public class CurrencyCell<T> extends FormattedNumberCell<T> {
    /**
     * Constructs a new {@code CurrencyCell} with the default locale's
     * currency formatter.
     *
     * <p>The currency format will use the system's default locale settings
     * (e.g., USD for US locale, EUR for European locales).</p>
     */
    public CurrencyCell() {
        super(NumberFormat.getCurrencyInstance());
    }

    /**
     * Constructs a new {@code CurrencyCell} with the specified locale's
     * currency formatter.
     *
     * @param locale the {@link Locale} to use for currency formatting.
     *               Must not be {@code null}.
     * @throws NullPointerException if {@code locale} is {@code null}
     */
    public CurrencyCell(Locale locale) {
        super(NumberFormat.getCurrencyInstance(locale));
    }
}
