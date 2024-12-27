package com.maemlab.nexusfx.widgets.toolbar;


import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.kordamp.ikonli.Ikon;

import java.util.function.Consumer;

public interface ToolbarButtonBuilders {
    interface Button {
        StdButton standardButton();
        CustomButton customButton();
    }

    interface StdButton {
        Action type(ToolbarButtonType type);
    }

    interface CustomButton {
        CustomButton ico(Ikon ico);
        Action style(String style);
    }

    interface Action {
        Optionals action(Runnable runnable);
        Optionals action(EventHandler<ActionEvent> evt);
        Optionals action(Consumer<Runnable> runnableConsumer);
    }

    interface Optionals {
        Optionals actionProperty(BooleanProperty actionBinding);
        Optionals disableBinding(BooleanBinding binding);
        Optionals tooltip(String tooltip);
        Optionals width(double width);
        ToolbarButton build();
    }
}
