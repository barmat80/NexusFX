package com.maemlab.nexusfx.widgets.tablecells;

import com.maemlab.nexusfx.widgets.Formatters;
import javafx.scene.control.TableCell;

public class DoubleCell<T> extends TableCell<T, Double>  {

    @Override
    public void updateItem(Double item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
           setText(Formatters.DOUBLE_FORMAT.format(item));
        }
    }
}
