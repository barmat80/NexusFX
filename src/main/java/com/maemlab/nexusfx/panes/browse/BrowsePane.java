package com.maemlab.nexusfx.panes.browse;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class BrowsePane extends GridPane {
    private final Label lbl;
    private final TextField tf;
    private final IconButton btn;

    public BrowsePane(Label label, TextField textField, IconButton button) {
        this.lbl = label;
        this.tf = textField;
        this.btn = button;
    }

    public BrowsePane build() {
        if (lbl != null) {
            this.add(lbl, 0, 0);
        }
        this.add(tf, 1, 0);
        this.add(btn, 2, 0);

        setColAndRowConstraints();
        return this;
    }

    public TextField getTextField() {
        return tf;
    }

    private void setColAndRowConstraints() {
        var cc = new ColumnConstraints();
        cc.setPrefWidth(100);
        cc.setMinWidth(10);
        cc.setHgrow(Priority.SOMETIMES);
        getColumnConstraints().add(cc);
        getColumnConstraints().add(cc);
        getColumnConstraints().add(cc);

        var rc = new RowConstraints();
        rc.setMinHeight(10);
        rc.setPrefHeight(20);
        rc.setMaxHeight(20);
        rc.setVgrow(Priority.SOMETIMES);
        getRowConstraints().add(rc);
    }
}
