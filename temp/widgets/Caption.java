package com.maemlab.nexusfx.widgets;

import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class Caption extends Region {

	private final HBox hbox;

	public Caption(Pos alignment) {
		hbox = new HBox();
		hbox.setAlignment(alignment);
		getChildren().add(hbox);
	}

	public void addLabel(String text, String... styles) {
		var lbl = new Label(text + " ");
		lbl.getStyleClass().addAll(styles);
		hbox.getChildren().add(lbl);
	}

	public void addLabelWithBinding(StringBinding binding, String... styles) {
		var lbl = new Label();
		lbl.getStyleClass().addAll(styles);
		lbl.textProperty().bind(binding);
		hbox.getChildren().add(lbl);
	}

}
