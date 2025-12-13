package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class CheckBoxRow {
    private CheckBox checkBox;

    protected CheckBoxRow() {
    }

    protected CheckBoxRow build(String text, boolean isDisable) {
        checkBox = new CheckBox(text);
        checkBox.setAllowIndeterminate(false);
        checkBox.setDisable(isDisable);
        return this;
    }

    protected void setBooleanProperty(BooleanProperty property) {
        checkBox.selectedProperty().bindBidirectional(property);
    }

    public Label getLabel() {return new Label();}

    public CheckBox getCheckBox() {
        return checkBox;
    }
}
