package com.maemlab.nexusfx.nav;

import atlantafx.base.theme.Styles;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.concurrent.atomic.AtomicInteger;

public class SidebarMenu extends VBox {
	private static final int SIZE = 48;
	private final ToggleGroup tg = new ToggleGroup();

	private static final AtomicInteger idCounter = new AtomicInteger(0);

	public SidebarMenu() {
		setAlignment(Pos.TOP_LEFT);
		setFillWidth(true);
	}

	public ToggleButton addItem(String label, Node icon, String navbarStyle, Node relatedView) {
		return  addItem(calcItemId(), label, icon, navbarStyle, relatedView);
	}

	public ToggleButton addItem(String id, String label, Node icon, String navbarStyle, Node relatedView) {
		var btn = addItem(id, label, icon, navbarStyle);
		if(relatedView != null) {
			relatedView.visibleProperty().bind(btn.selectedProperty());
		}
		return btn;
	}

	public ToggleButton addItem(String label, Node icon, String navbarStyle) {
		return addItem(calcItemId(), label, icon, navbarStyle);
	}

	public ToggleButton addItem(String id, String label, Node icon, String navbarStyle) {
		var btn = new ToggleButton(label, icon);
		btn.setId(id);
		btn.setGraphicTextGap(10);
		btn.getStyleClass().addAll(navbarStyle, Styles.TEXT_BOLD);
		btn.setAlignment(Pos.CENTER_LEFT);

		tg.getToggles().add(btn);
		getChildren().add(btn);

		return btn;
	}

	private String calcItemId() {
		return "sm_item_" + idCounter.incrementAndGet();
	}
}
