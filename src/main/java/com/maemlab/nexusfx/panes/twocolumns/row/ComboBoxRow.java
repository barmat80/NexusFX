package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class ComboBoxRow<T> {
    private Label label;
    private Label extraLabel;
    private ComboBox<T> comboBox;

    protected ComboBoxRow() {}

    protected ComboBoxRow<T> withLabel(Label lbl) {
        this.label = lbl;
        return this;
    }

    public ComboBoxRow<T> withExtraLabel(Label lbl) {
        this.extraLabel = lbl;
        return this;
    }

    protected ComboBoxRow<T> build(int width, List<T> choices, boolean isDisable) {
        comboBox = new ComboBox<>();
        comboBox.setMinWidth(width);
        comboBox.setPrefWidth(width);
        comboBox.setMaxWidth(width);
        comboBox.setItems(FXCollections.observableArrayList(choices));
        comboBox.setDisable(isDisable);
        return this;
    }

    public void setAction(Runnable action) {
        comboBox.setOnAction(evt -> action.run());
    }

    public void setDefaultValue(T defaultValue) {
        comboBox.getSelectionModel().select(defaultValue);
    }

    public void bindSelectionTo(Property<T> bindingProperty) {
        bindingProperty.bind(comboBox.getSelectionModel().selectedItemProperty());
    }

    public Label getLabel() {
        return label;
    }

    public Label getExtraLabel() {
        return extraLabel;
    }

    public ComboBox<T> getComboBox() {
        return comboBox;
    }

    public Node createHBox() {
        var hbox = new HBox();
        hbox.getChildren().add(comboBox);
        if(extraLabel != null) {
            hbox.getChildren().add(extraLabel);
            HBox.setMargin(extraLabel, new Insets(8.0, 0.0, 0.0, 10.0));
        }
        return hbox;
    }

    public boolean hasExtraLabel() {
        return this.extraLabel != null;
    }
}
