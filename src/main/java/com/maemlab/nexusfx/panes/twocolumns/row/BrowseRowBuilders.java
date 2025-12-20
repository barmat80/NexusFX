package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.TextFormatter;

import java.util.function.Consumer;

public interface BrowseRowBuilders {
    interface TextField {
        Formatter width(int width);
    }

    interface Formatter {
        Property withoutFormatter();
        Property formatter(TextFormatter<String> stringFormatter);
    }

    interface Property {
        Icon stringProperty(StringProperty property);
    }

    interface Icon {
        Action icon(Node icon);
    }

    interface Action {
        Optionals action(Runnable runnable);
        //        Optionals action(EventHandler<ActionEvent> evt);
        Optionals action(Consumer<Runnable> runnableConsumer);
    }

    interface Optionals {
        Optionals label(String label);
        Optionals tooltip(String tooltip);
        Optionals setDisabled();
        Optionals setEditableBinding(BooleanBinding binding);
        BrowseRow build();
    }
}
