package com.maemlab.nexusfx.tableview.cells;

import javafx.scene.control.TableCell;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * A {@link TableCell} implementation for displaying {@link LocalDate} values
 * formatted using a custom {@link DateTimeFormatter}.
 *
 * <p>This cell allows customization of dates formatting by accepting a
 * {@link DateTimeFormatter} instance in its constructor.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 * TableColumn<MyData, LocalDate> dateColumn = new TableColumn<>("Date");
 * dateColumn.setCellFactory(tc -> new DateCell<>(formatter));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see TableCell
 * @see DateTimeFormatter
 * @see LocalDate
 */
public class DateCell<T> extends TableCell<T, LocalDate> {

    private final DateTimeFormatter formatter;

    /**
     * Constructs a new {@code DateCell} with the specified date formatter.
     *
     * @param formatter the {@link DateTimeFormatter} to use for formatting cell values.
     *                  Must not be {@code null}.
     * @throws NullPointerException if {@code formatter} is {@code null}
     */
    public DateCell(DateTimeFormatter formatter) {
        this.formatter = Objects.requireNonNull(formatter, "formatter must not be null");
    }

    /**
     * Updates the item and formatting of this cell.
     *
     * <p>If the cell is empty or the item is {@code null}, the cell text is cleared.
     * Otherwise, the item is formatted using the provided {@link DateTimeFormatter}.</p>
     *
     * @param item the new item for the cell, may be {@code null}
     * @param empty {@code true} if the cell is empty, {@code false} otherwise
     */
    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        } else {
            setText(formatter.format(item));
        }
    }
}
