package com.maemlab.nexusfx.nav;

import atlantafx.base.theme.Styles;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SidebarFooter extends HBox {

	public SidebarFooter() {
		this("", "");
	}

	public SidebarFooter(String styleClass, String appVersion) {
		super();
		setId("sidebarFooter");
		if(styleClass != null && !styleClass.isEmpty()) {
			getStyleClass().add(styleClass);
		}
		build(appVersion);
	}

	private void build(String appVersion) {
		var footer = new HBox();
		footer.setId("sidebarFooter");

		if(appVersion != null && !appVersion.isEmpty()) {
			var versionLbl = new Label("v" + appVersion);
			versionLbl.getStyleClass().addAll(Styles.TEXT_SMALL, Styles.TEXT_BOLDER, Styles.TEXT_SUBTLE);
			footer.getChildren().add(versionLbl);
		}

		/*-versionLbl.setCursor(Cursor.HAND);
		versionLbl.setOnMouseClicked(e -> {
			var homepage = System.getProperty("app.homepage");
			if (homepage != null) {
				DefaultEventBus.getInstance().publish(new BrowseEvent(URI.create(homepage)));
			}
		});*/
		// versionLbl.setTooltip(new Tooltip("Visit homepage"));

		getChildren().setAll(footer);
	}
}
