package com.maemlab.nexusfx.widgets.tablecells;

import com.maemlab.nexusfx.widgets.Formatters;
import javafx.scene.control.TableCell;

public class IntegerCell<T> extends TableCell<T, Integer>  {

    @Override
    public void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
           setText(Formatters.INTEGER_FORMAT.format(item));
        }
    }
}
