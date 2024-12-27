package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class RadioRow {
    private final Label label;
    private final VBox vbox;
    private final ToggleGroup toggleGroup;

    protected RadioRow(Label label) {
        this.label = label;
        vbox = new VBox(10);
        toggleGroup = new ToggleGroup();
    }

    protected RadioRow build(String[] radioNames, String selected) {
        for (String name : radioNames) {
            var radio = new RadioButton(name);
            radio.setToggleGroup(toggleGroup);
            radio.setSelected(selected.equalsIgnoreCase(name));
            vbox.getChildren().add(radio);
        }
        return this;
    }

    protected void setStringProperty(StringProperty property) {
        toggleGroup.selectedToggleProperty().addListener(evt -> {
            RadioButton chk = (RadioButton) toggleGroup.getSelectedToggle();
            property.bind(chk.textProperty());
        });
    }

    public Label getLabel() {
        return label;
    }

    public VBox getVBox() {
        return vbox;
    }

    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }
}
