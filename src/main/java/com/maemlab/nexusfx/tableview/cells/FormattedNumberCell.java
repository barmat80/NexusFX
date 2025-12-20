package com.maemlab.nexusfx.tableview.cells;

import javafx.scene.control.TableCell;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

/**
 * A {@link TableCell} implementation for displaying {@link Number} values
 * formatted as currency or numeric values using a custom {@link NumberFormat}.
 *
 * <p>This cell allows customization of number formatting  by accepting a
 * {@link NumberFormat} or {@link DecimalFormat} instance in its constructor.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * // For currency formatting
 * NumberFormat euroFormat = NumberFormat.getCurrencyInstance(Locale.ITALY);
 * TableColumn<MyData, Double> priceColumn = new TableColumn<>("Price");
 * priceColumn.setCellFactory(tc -> new FormattedNumberCell<>(euroFormat));
 *
 * // For integer formatting
 * NumberFormat integerFormat = NumberFormat.getIntegerInstance();
 * TableColumn<MyData, Integer> quantityColumn = new TableColumn<>("Quantity");
 * quantityColumn.setCellFactory(tc -> new FormattedNumberCell<>(integerFormat));
 *
 * // For custom decimal formatting
 * DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
 * TableColumn<MyData, Double> valueColumn = new TableColumn<>("Value");
 * valueColumn.setCellFactory(tc -> new FormattedNumberCell<>(decimalFormat));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see TableCell
 * @see NumberFormat
 * @see DecimalFormat
 */
public class FormattedNumberCell<T> extends TableCell<T, Number> {
    private final NumberFormat formatter;

    /**
     * Constructs a new {@code FormattedNumberCell} with the specified number formatter.
     *
     * @param formatter the {@link NumberFormat} to use for formatting cell values.
     *                  Must not be {@code null}.
     * @throws NullPointerException if {@code formatter} is {@code null}
     */
    public FormattedNumberCell(NumberFormat formatter) {
        this.formatter = Objects.requireNonNull(formatter, "formatter must not be null");
    }

    /**
     * Updates the item and formatting of this cell.
     *
     * <p>If the cell is empty or the item is {@code null}, the cell text is cleared.
     * Otherwise, the item is formatted using the provided {@link NumberFormat}.</p>
     *
     * @param item the new item for the cell, may be {@code null}
     * @param empty {@code true} if the cell is empty, {@code false} otherwise
     */
    @Override
    public void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
            setText(formatter.format(item));
        }
    }
}
