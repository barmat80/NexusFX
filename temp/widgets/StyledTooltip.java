package com.maemlab.nexusfx.widgets;

import javafx.scene.control.Tooltip;

public class StyledTooltip extends Tooltip {

	public StyledTooltip(String text, String style) {
		super();
		setText(text);
		setStyle(style);
	}

	public StyledTooltip(String text) {
		super();
		setText(text);
	}
}