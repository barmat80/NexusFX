package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class BrowseRowBuilder implements BrowseRowBuilders.TextField, BrowseRowBuilders.Icon, BrowseRowBuilders.Action, BrowseRowBuilders.Optionals {

    private int width;
    private StringProperty property;
    private Node icon;
    private Runnable runnable;
//    private EventHandler<ActionEvent> evt;
    private Consumer<Runnable> runnableConsumer;
    private String label;
    private String tooltip;
//    private StringProperty property;
    private boolean isEditable;

    private BrowseRowBuilder(){
        this.isEditable = true;
        this.width = 100; // default width
    }

    public static BrowseRowBuilder browseRow() {
        return new BrowseRowBuilder();
    }

    @Override
    public BrowseRowBuilders.TextField width(int width) {
        if(width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
        return this;
    }

    @Override
    public BrowseRowBuilders.Icon bindStringProperty(StringProperty property) {
        this.property = property;
        return this;
    }

    @Override
    public BrowseRowBuilders.Action icon(Node icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public BrowseRowBuilders.Optionals action(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }

//    @Override
//    public BrowseRowBuilders.Optionals action(EventHandler<ActionEvent> evt) {
//        this.evt = evt;
//        return this;
//    }

    @Override
    public BrowseRowBuilders.Optionals action(Consumer<Runnable> runnableConsumer) {
        this.runnableConsumer = runnableConsumer;
        return this;
    }

    @Override
    public BrowseRowBuilders.Optionals tooltip(String tooltip) {
        this.tooltip = tooltip;
        return this;
    }

    @Override
    public BrowseRowBuilders.Optionals label(String label) {
        this.label = label;
        return this;
    }

    @Override
    public BrowseRowBuilders.Optionals setDisabled() {
        this.isEditable = false;
        return this;
    }

    @Override
    public BrowseRow build() {
        var row = new BrowseRow().addLabel(buildLabel()).build(this.tooltip, this.icon, this.runnable, this.runnableConsumer, this.width, this.isEditable);
        if(property != null) row.bindStringProperty(property);
        return row;
    }

    private Label buildLabel() {
        Label lbl = null;
        if (this.label != null) {
            lbl = new Label(this.label);
            GridPane.setHalignment(lbl, HPos.RIGHT);
        }
        return lbl;
    }
}
