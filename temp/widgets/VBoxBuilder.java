package com.maemlab.nexusfx.widgets;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class VBoxBuilder {
    private double prefWidth;
    private double prefHeight;
    private double insetsTop;
    private double insetsRight;
    private double insetsBottom;
    private double insetsLeft;
    private boolean fixedDimensions;
    private final List<Node> nodes;

    private VBoxBuilder() {
        nodes = new ArrayList<>();
        this.fixedDimensions = false;
    }

    public static VBoxBuilder vbox() {
        return new VBoxBuilder();
    }

    public VBoxBuilder dimensions(double prefWidth, double prefHeight) {
        this.prefWidth = prefWidth;
        this.prefHeight = prefHeight;
        return this;
    }

    public VBoxBuilder setFixedDimensions() {
        this.fixedDimensions = true;
        return this;
    }

    public VBoxBuilder insets(double insetsTop, double insetsRight, double insetsBottom, double insetsLeft) {
        this.insetsTop = insetsTop;
        this.insetsRight = insetsRight;
        this.insetsBottom = insetsBottom;
        this.insetsLeft = insetsLeft;
        return this;
    }

    public VBoxBuilder add(Node n) {
        nodes.add(n);
        return this;
    }

    public VBox build() {
        var vbox = new VBox(toArray());

        vbox.setPrefWidth(prefWidth);
        vbox.setPrefHeight(prefHeight);

        if(this.fixedDimensions) {
            vbox.setMinWidth(prefWidth);
            vbox.setMaxWidth(prefWidth);
            vbox.setMinHeight(prefHeight);
            vbox.setMaxHeight(prefHeight);
        }

        setMarginsOnNodes();
        return vbox;
    }

    private Node[] toArray() {
        return nodes.toArray(new Node[0]);
    }

    private void setMarginsOnNodes() {
        Insets insets = new Insets(this.insetsTop, this.insetsRight, this.insetsBottom, this.insetsLeft);
        for (Node n : this.nodes) {
            VBox.setMargin(n, insets);
        }
    }
}
