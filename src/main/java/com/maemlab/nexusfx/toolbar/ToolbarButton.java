package com.maemlab.nexusfx.toolbar;

import atlantafx.base.theme.Styles;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

import java.util.function.Consumer;

public class ToolbarButton extends Button {

    private final ToolbarButtonType type;
    private final Node icon;
    private final String style;
    private final Runnable action;
    private final EventHandler<ActionEvent> evt;
    private final Consumer<Runnable> runnableConsumer;
    private final BooleanProperty actionProperty;
    private final BooleanBinding disableBinding;
    private final String tooltip;
    private final double width;

    public ToolbarButton(ToolbarButtonType type, Node icon, String style, Runnable action, EventHandler<ActionEvent> evt, Consumer<Runnable> runnableConsumer,
                         BooleanProperty actionProperty, BooleanBinding disableBinding, String tooltip, double width) {
        this.type = type;
        this.icon = icon;
        this.style = style;
        this.action = action;
        this.evt = evt;
        this.runnableConsumer = runnableConsumer;
        this.actionProperty = actionProperty;
        this.disableBinding = disableBinding;
        this.tooltip = tooltip;
        this.width = width;
    }

    protected ToolbarButton build() {
        setTooltip();
        setWidth();
        setIcon();
        setStyles();
        setAction();
        setDisableBinding();
        return this;
    }

    private void setTooltip() {
        if (tooltip != null && !tooltip.isEmpty()) {
            setTooltip(new Tooltip(tooltip));
        }
    }

    private void setWidth() {
        setMaxWidth(width);
        setMinWidth(width);
        setPrefWidth(width);
    }

    private void setIcon() {
        setGraphic(icon);
    }

    private void setAction() {
        if (action != null) {
            setOnAction(evt -> {
                if(actionProperty != null) actionProperty.setValue(true);
                action.run();
                if(actionProperty != null) actionProperty.setValue(false);
            });
        }

        if(evt != null) {
            setOnAction(evt);
        }

        if(runnableConsumer != null) {
            setOnAction(evt -> runnableConsumer.accept(() -> setDisable(false)));
        }
    }

    private void setDisableBinding() {
        if(disableBinding != null)
            disableProperty().bind(disableBinding);
    }

    private void setStyles() {
        String[] styles = new String[2];
        styles[0] = Styles.FLAT;
        switch (type) {
            case ToolbarButtonType.ADD,
                ToolbarButtonType.EDIT,
                ToolbarButtonType.SAVE:
                styles[1] = Styles.ACCENT;
                break;
            case ToolbarButtonType.DELETE,
                 ToolbarButtonType.QUIT:
                styles[1] = Styles.DANGER;
                break;
            case ToolbarButtonType.CUSTOM: styles[1] = this.style;
        }

        getStyleClass().addAll(styles);
    }
}
