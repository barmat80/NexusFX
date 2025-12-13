package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

public class LabelRow {
    private Label descriptionLabel;
    private Label valueLabel;

    public LabelRow build(String description, String value, int width) {
        descriptionLabel = new Label(description);
        GridPane.setHalignment(descriptionLabel, HPos.RIGHT);

        valueLabel = new Label(value);
        valueLabel.setPrefWidth(width);
        valueLabel.setMinWidth(width);
        valueLabel.setMaxWidth(width);
        GridPane.setHalignment(valueLabel, HPos.LEFT);

        return this;
    }

    public void setDescriptionStyles(List<String> styles) {descriptionLabel.getStyleClass().addAll(styles);}

    public void setValueStyles(List<String> styles) {valueLabel.getStyleClass().addAll(styles);}

    public void setBinding(StringBinding binding) {valueLabel.textProperty().bind(binding);}

    public void setStringProperty(StringProperty stringProperty) {
        valueLabel.textProperty().bindBidirectional(stringProperty);
    }

    public Label getLabel() {
        return descriptionLabel;
    }

    public Label getValueLabel() {return valueLabel;}
}
