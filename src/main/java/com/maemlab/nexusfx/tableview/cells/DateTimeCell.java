package com.maemlab.nexusfx.tableview.cells;

import javafx.scene.control.TableCell;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * A {@link TableCell} implementation for displaying {@link LocalDateTime} values
 * formatted using a custom {@link DateTimeFormatter}.
 *
 * <p>This cell allows customization of datetime formatting by accepting a
 * {@link DateTimeFormatter} instance in its constructor.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
 * TableColumn<MyData, LocalDateTime> dateTimeColumn = new TableColumn<>("DateTime");
 * dateTimeColumn.setCellFactory(tc -> new DateTimeCell<>(formatter));
 * }</pre>
 *
 * @param <T> the type of the TableView's items
 *
 * @see TableCell
 * @see DateTimeFormatter
 * @see LocalDateTime
 */
public class DateTimeCell<T> extends TableCell<T, LocalDateTime> {

    private final DateTimeFormatter formatter;

    /**
     * Constructs a new {@code DateTimeCell} with the specified datetime formatter.
     *
     * @param formatter the {@link DateTimeFormatter} to use for formatting cell values.
     *                  Must not be {@code null}.
     * @throws NullPointerException if {@code formatter} is {@code null}
     */
    public DateTimeCell(DateTimeFormatter formatter) {
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
    public void updateItem(LocalDateTime item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        } else {
            setText(formatter.format(item));
        }
    }
}
