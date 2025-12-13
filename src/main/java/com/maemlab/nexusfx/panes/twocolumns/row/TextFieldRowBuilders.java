package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface TextFieldRowBuilders {
    interface TextField {
        Formatter width(int width);
    }

    interface Formatter {
        Optionals withoutProperty();
        Optionals stringProperty(StringProperty property);
        Optionals integerProperty(IntegerProperty property);
        Optionals doubleProperty(DoubleProperty property);
    }

    interface Optionals {
        Optionals label(String label);
        Optionals setDisabled();
        Optionals setEditableBinding(BooleanBinding binding);
        Optionals extraLabel(StringProperty extraLabel);
        Optionals extraLabel(String extraLabel);
        TextFieldRow build();
    }
}
