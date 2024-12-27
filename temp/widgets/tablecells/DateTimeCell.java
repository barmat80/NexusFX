package com.maemlab.nexusfx.widgets.tablecells;

import com.maemlab.nexusfx.widgets.Formatters;
import javafx.scene.control.TableCell;

import java.time.LocalDate;

public class DateTimeCell<T> extends TableCell<T, LocalDate> {

    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
            setText(Formatters.IT_DATETIME_FORMAT.format(item));
        }
    }
}
