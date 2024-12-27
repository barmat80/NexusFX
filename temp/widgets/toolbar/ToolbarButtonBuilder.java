package com.maemlab.nexusfx.widgets.toolbar;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.kordamp.ikonli.Ikon;

import java.util.function.Consumer;

public class ToolbarButtonBuilder implements ToolbarButtonBuilders.Button, ToolbarButtonBuilders.StdButton, ToolbarButtonBuilders.CustomButton, ToolbarButtonBuilders.Action, ToolbarButtonBuilders.Optionals {
    private final static double DEFAULT_WIDTH = 34.0;

    private ToolbarButtonType type;
    private Ikon ico;
    private String style;
    private Runnable runnable;
    private EventHandler<ActionEvent> evt;
    private Consumer<Runnable> runnableConsumer;
    private BooleanProperty actionProperty;
    private BooleanBinding disableBinding;
    private String tooltip;
    private double width;

    private ToolbarButtonBuilder() {
        this.width = DEFAULT_WIDTH;
    }

    public static ToolbarButtonBuilders.Button toolbarButton() {
        return new ToolbarButtonBuilder();
    }

    public ToolbarButtonBuilders.StdButton standardButton() {
        return this;
    }

    public ToolbarButtonBuilders.Action type(ToolbarButtonType type) {
        this.type = type;
        return this;
    }

    public ToolbarButtonBuilders.CustomButton customButton() {
        this.type = ToolbarButtonType.CUSTOM;
        return this;
    }

    public ToolbarButtonBuilders.CustomButton ico(Ikon ico) {
        this.ico = ico;
        return this;
    }

    public ToolbarButtonBuilders.Action style(String style) {
        this.style = style;
        return this;
    }

    public ToolbarButtonBuilders.Optionals action(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

    public ToolbarButtonBuilders.Optionals action(EventHandler<ActionEvent> evt) {
        this.evt = evt;
        return this;
    }

    public ToolbarButtonBuilders.Optionals action(Consumer<Runnable> runnableConsumer) {
        this.runnableConsumer = runnableConsumer;
        return this;
    }

    @Override
    public ToolbarButtonBuilders.Optionals actionProperty(BooleanProperty actionProperty) {
        this.actionProperty = actionProperty;
        return this;
    }

    public ToolbarButtonBuilders.Optionals disableBinding(BooleanBinding disableBinding) {
        this.disableBinding = disableBinding;
        return this;
    }

    public ToolbarButtonBuilders.Optionals tooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    public ToolbarButtonBuilders.Optionals width(double width) {
        this.width = width;
        return this;
    }

    public ToolbarButton build() {
        var btn = new ToolbarButton(type, ico, style, runnable, evt, runnableConsumer, actionProperty, disableBinding, tooltip, width);
        return btn.build();
    }
}
