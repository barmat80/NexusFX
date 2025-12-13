package com.maemlab.nexusfx.nav;

import atlantafx.base.controls.Spacer;
import atlantafx.base.theme.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SidebarHeader extends VBox {

	private static final int IMAGE_WIDTH = 32;
	private final String appName;
	private final String iconPath;

	public SidebarHeader() {
		this("",  "", "");
	}

	public SidebarHeader(String appName, String iconPath) {
		this("", appName, iconPath);
	}

	public SidebarHeader(String styleClass, String appName, String iconPath) {
		super();
		this.iconPath = iconPath;
		this.appName = appName;
		setId("sidebarHeader");
		if(styleClass != null && !styleClass.isEmpty()) {
			getStyleClass().add(styleClass);
		}
		build();
	}

	private void build() {
		var logo = new HBox(10);

		if(this.iconPath != null && !this.iconPath.isEmpty()) {
			var image = new ImageView(new Image(SidebarHeader.class.getResource(this.iconPath).toString()));
			image.setFitWidth(IMAGE_WIDTH);
			image.setFitHeight(IMAGE_WIDTH);

			var imageBorder = new Insets(1);
			var imageBox = new StackPane(image);
			// imageBox.getStyleClass().add(STYLES.SIDEBAR_HEADER_IMAGE);// TODO
			imageBox.setPadding(imageBorder);
			imageBox.setPrefSize(image.getFitWidth() + imageBorder.getRight() * 2, image.getFitWidth() + imageBorder.getTop() * 2);
			imageBox.setMaxSize(image.getFitHeight() + imageBorder.getTop() * 2, image.getFitHeight() + imageBorder.getRight() * 2);
			logo.getChildren().add(imageBox);
		}

		if(this.appName != null && !this.appName.isEmpty()) {
			var titleLbl = new Label(this.appName);
			titleLbl.getStyleClass().addAll(Styles.TEXT_MUTED, Styles.TITLE_3);
			logo.getChildren().add(titleLbl);
		}

		logo.getChildren().addAll(new Spacer(), new Spacer());
		logo.setId("logo");
		logo.setAlignment(Pos.CENTER_LEFT);

		getChildren().setAll(logo);
	}
}
