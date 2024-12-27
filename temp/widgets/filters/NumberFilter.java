package com.maemlab.nexusfx.widgets.filters;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class NumberFilter implements UnaryOperator<TextFormatter.Change> {

	private static final String REGEXP_ONLY_DIGITS = "\\d+";
	// private static final String REGEXP_WITH_DECIMALS = "([0-9]*)?(\\\\.[0-9]*)?";// "^[0-9]*([,.][0-9]{1,2})?$";

	@Override
	public TextFormatter.Change apply(TextFormatter.Change change) {
		String prevValue = change.getControlText();
		// String newValue = change.getControlNewText();

		String currentChar = change.getText();

		if (currentChar.isEmpty() || currentChar.matches(REGEXP_ONLY_DIGITS)) {
			return change; // if change is a number or empty string
		} else if (isCommaOrDot(currentChar)) {
			if (prevValue.contains(".")) {
				change.setText("");
			} else {
				change.setText(".");
			}
			return change;
		} else {
			change.setText(""); // else make no change
			change.setRange(change.getRangeStart(), change.getRangeStart());// don't remove any selected text
			// either.
			return change;
		}
	}

	private boolean isCommaOrDot(String currentChar) {
		return currentChar.equals(".") || currentChar.equals(",");
	}
}
