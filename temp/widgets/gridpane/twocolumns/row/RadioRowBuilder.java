package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class RadioRowBuilder {
    private String label;
    private String[] names;
    private StringProperty property;

    private RadioRowBuilder(){}

    public static RadioRowBuilder radioRow() {
        return new RadioRowBuilder();
    }

    public RadioRowBuilder label(String label) {
        this.label = label;
        return this;
    }

    public RadioRowBuilder names(String[] names) {
        this.names = names;
        return this;
    }
    
    public RadioRowBuilder stringFormatter(StringProperty property) {
        this.property = property;
        return this;
    }

    public RadioRow build() {
        var radioRow = new RadioRow(buildLabel()).build(this.names, this.property.get());
        radioRow.setStringProperty(this.property);
        return radioRow;
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
