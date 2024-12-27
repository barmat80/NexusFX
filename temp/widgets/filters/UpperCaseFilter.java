package com.maemlab.nexusfx.widgets.filters;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class UpperCaseFilter implements UnaryOperator<TextFormatter.Change> {

	@Override
	public TextFormatter.Change apply(TextFormatter.Change change) {
		String v = change.getText();
		change.setText(v.toUpperCase());
		return change;
	}

}
