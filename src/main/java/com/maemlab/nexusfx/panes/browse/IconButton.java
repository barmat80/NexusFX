package com.maemlab.nexusfx.panes.browse;

import atlantafx.base.theme.Styles;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.function.Consumer;

public class IconButton extends Button {
    private final static double DEFAULT_BUTTON_WIDTH = 34.0;

    private final String tooltip;
    private final Runnable action;
    private final Consumer<Runnable> runnableConsumer;
    private final Node icon;

    public IconButton(String tooltip, Node icon) {
        this(tooltip, null, null, icon);
    }

    public IconButton(String tooltip, Runnable action, Node icon) {
        this(tooltip, action, null, icon);
    }

    public IconButton(String tooltip, Consumer<Runnable> runnableConsumer, Node icon) {
        this(tooltip, null, runnableConsumer, icon);
    }

    public IconButton(String tooltip, Runnable action, Consumer<Runnable> runnableConsumer, Node icon) {
        this.tooltip = tooltip;
        this.action = action;
        this.runnableConsumer = runnableConsumer;
        this.icon = icon;
        build();
    }

    private void build() {
        setTooltip();
        setMaxWidth(DEFAULT_BUTTON_WIDTH);
        setMinWidth(DEFAULT_BUTTON_WIDTH);
        setPrefWidth(DEFAULT_BUTTON_WIDTH);
        setGraphic(icon);
        getStyleClass().addAll(Styles.BUTTON_ICON, Styles.FLAT, Styles.ACCENT);

        var insets = new Insets(0, 0, 0, 10);
        GridPane.setMargin(this, insets);
        GridPane.setVgrow(this, Priority.SOMETIMES);

        if (action != null) {
            setOnAction(e -> action.run());
        }

        if(runnableConsumer != null) {
            setOnAction(e -> runnableConsumer.accept(() -> setDisable(false)));
        }
    }

    private void setTooltip(){
        if (tooltip != null) {
            Tooltip tt = new Tooltip(tooltip);
            setTooltip(tt);
        }
    }

    public void setAction(Runnable action) {
        setOnAction(e -> action.run());
    }

    public void setAction(Consumer<Runnable> action) {
        setOnAction(e -> runnableConsumer.accept(() -> setDisable(false)));
    }
}
