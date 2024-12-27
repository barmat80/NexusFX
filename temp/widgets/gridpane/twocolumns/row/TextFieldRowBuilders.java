package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import com.maemlab.nexusfx.data.beans.autocompletion.BeanConverter;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSelectionHandler;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSuggesterCallback;
import com.maemlab.nexusfx.data.beans.autocompletion.StringSuggesterCallback;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface TextFieldRowBuilders {
    interface TextField {
        Formatter width(int width);
    }

    interface Formatter {
        Suggester withoutProperty();
        Suggester stringProperty(StringProperty property);
        Suggester integerProperty(IntegerProperty property);
        Suggester doubleProperty(DoubleProperty property);
    }

    interface Suggester {
        Optionals withoutSuggester();
        Optionals beanSuggester(BeanSuggesterCallback suggester, BeanSelectionHandler handler, BeanConverter converter);
        Optionals stringSuggester(StringSuggesterCallback suggester);
    }

    interface Optionals {
        Optionals label(String label);
        Optionals setDisabled();
        Optionals setDisableBinding(BooleanBinding binding);
        Optionals extraLabel(StringProperty extraLabel);
        TextFieldRow build();
    }
}
