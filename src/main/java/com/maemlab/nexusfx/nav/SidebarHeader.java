package com.maemlab.nexusfx.nav;

import atlantafx.base.controls.Spacer;
import atlantafx.base.theme.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SidebarHeader extends VBox {

	private static final int IMAGE_WIDTH = 32;
	private final String appName;
	private final String iconURL;

	public SidebarHeader() {
		this("",  "", "");
	}

	public SidebarHeader(String appName, String iconURL) {
		this("", appName, iconURL);
	}

	public SidebarHeader(String styleClass, String appName, String iconURL) {
		super();
		this.iconURL = iconURL;
		this.appName = appName;
		setId("sidebarHeader");
		if(styleClass != null && !styleClass.isEmpty()) {
			getStyleClass().add(styleClass);
		}
		build();
	}

	private void build() {
		var logo = new HBox(10);
		logo.setId("logo");
		logo.setAlignment(Pos.CENTER_LEFT);

		if(this.iconURL != null && !this.iconURL.isEmpty()) {
			logo.getChildren().add(buildImagePane());
		}

		if(this.appName != null && !this.appName.isEmpty()) {
			logo.getChildren().add(buildTitleLabel());
		}

		logo.getChildren().addAll(new Spacer(), new Spacer());

		getChildren().setAll(logo);
	}

	private StackPane buildImagePane() {
		var image = new ImageView(new Image(this.iconURL));
		image.setFitWidth(IMAGE_WIDTH);
		image.setFitHeight(IMAGE_WIDTH);

		var imageBorder = new Insets(1);
		var imageBox = new StackPane(image);
		// imageBox.getStyleClass().add(STYLES.SIDEBAR_HEADER_IMAGE);// TODO
		imageBox.setPadding(imageBorder);
		imageBox.setPrefSize(image.getFitWidth() + imageBorder.getRight() * 2, image.getFitWidth() + imageBorder.getTop() * 2);
		imageBox.setMaxSize(image.getFitHeight() + imageBorder.getTop() * 2, image.getFitHeight() + imageBorder.getRight() * 2);
		return imageBox;
	}

	private Node buildTitleLabel() {
		var titleLbl = new Label(this.appName);
		titleLbl.getStyleClass().addAll(Styles.TEXT_MUTED, Styles.TITLE_3);
		return titleLbl;
	}
}
