package com.maemlab.nexusfx.widgets.toolbar;

import atlantafx.base.theme.Styles;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.material2.Material2AL;
import org.kordamp.ikonli.material2.Material2MZ;

import java.util.function.Consumer;

public class ToolbarButton extends Button {

    private final ToolbarButtonType type;
    private final Ikon ico;
    private final String style;
    private final Runnable action;
    private final EventHandler<ActionEvent> evt;
    private final Consumer<Runnable> runnableConsumer;
    private final BooleanProperty booleanProperty;
    private final BooleanBinding disableBinding;
    private final String tooltip;
    private final double width;

    public ToolbarButton(ToolbarButtonType type, Ikon ico, String style, Runnable action, EventHandler<ActionEvent> evt, Consumer<Runnable> runnableConsumer,
                         BooleanProperty booleanProperty, BooleanBinding disableBinding, String tooltip, double width) {
        this.type = type;
        this.ico = ico;
        this.style = style;
        this.action = action;
        this.evt = evt;
        this.runnableConsumer = runnableConsumer;
        this.booleanProperty = booleanProperty;
        this.disableBinding = disableBinding;
        this.tooltip = tooltip;
        this.width = width;
    }

    protected ToolbarButton build() {
        setTooltip();
        setWidth();
        setFontIcon();
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

    private void setFontIcon() {
        Ikon ico = switch (type) {
            case ToolbarButtonType.ADD -> Material2AL.ADD;
            case ToolbarButtonType.EDIT -> Material2AL.EDIT;
            case ToolbarButtonType.DELETE -> Material2AL.DELETE;
            case SAVE -> Material2MZ.SAVE;
            case QUIT -> Material2AL.CANCEL;
            case ToolbarButtonType.CUSTOM -> this.ico;
        };
        setGraphic(new FontIcon(ico));
    }

    private void setAction() {
        if (action != null) {
            setOnAction(evt -> {
                if(booleanProperty != null) booleanProperty.setValue(true);
                action.run();
                if(booleanProperty != null) booleanProperty.setValue(false);
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
