package com.maemlab.nexusfx.nav;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class Sidebar extends ScrollPane {
	private SidebarMenu sidebarMenu;

	public Sidebar(SidebarMenu sm) {
		this(-1, -1);
		sidebarMenu = sm;
	}

	public Sidebar(double prefHeight, double prefWidth) {
		setFitToHeight(true);
		setFitToWidth(true);

		if (prefHeight > 0) {
			setPrefHeight(prefHeight);
		}

		if (prefWidth > 0) {
			setPrefWidth(prefWidth);
		}
	}

	public Sidebar build(String appName, String appVersion, String iconPath, String headerStyleClass, String footerStyleClass) {
		var bp = new BorderPane();
		bp.setTop(new SidebarHeader(headerStyleClass, appName, iconPath));
		bp.setCenter(sidebarMenu);
		bp.setBottom(new SidebarFooter(footerStyleClass, appVersion));
		setContent(bp);
		return this;
	}
}
