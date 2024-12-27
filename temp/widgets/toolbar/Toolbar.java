package com.maemlab.nexusfx.widgets.toolbar;

import javafx.scene.Node;
import javafx.scene.control.ButtonBar;

public class Toolbar extends ButtonBar {
    private final static double DEFAULT_WIDTH = 34.0;

    public Toolbar() {
        this(DEFAULT_WIDTH);
    }

    public Toolbar(double w) {
        setButtonMinWidth(w);
    }

    public void add(Node... nodes) {
        getButtons().addAll(nodes);
    }
}
