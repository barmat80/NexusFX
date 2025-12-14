package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;

import java.util.function.Consumer;

public interface BrowseRowBuilders {
    interface TextField {
        TextField width(int width);
        Icon bindStringProperty(StringProperty property);
    }

    interface Icon {
        Action icon(Node icon);
    }

    interface Action {
        Optionals action(Runnable runnable);
//        Optionals action(EventHandler<ActionEvent> evt);
        Optionals action(Consumer<Runnable> runnableConsumer);
    }

//    interface Formatter {
//        Optionals withoutProperty();
//        Optionals stringProperty(StringProperty property);
//    }

    interface Optionals {
        Optionals label(String label);
        Optionals tooltip(String tooltip);
        Optionals setDisabled();
//        Optionals setEditableBinding(BooleanBinding binding);
//        Optionals extraLabel(String extraLabel);
        BrowseRow build();
    }
}
