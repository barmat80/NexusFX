package com.maemlab.nexusfx.dialogs.modal;

import com.maemlab.nexusfx.dialogs.alert.CustomAlertBuilder;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Modal {
	private static final double PREF_HEIGHT = 300;
	private static final double PREF_WIDTH = 500;

	private final String modalTitle;
    private final String baseCSS;
    private final Region view;
	private final double width;
	private final double height;
	private final ObservableList<Image> icons;

	public Modal(String title, String baseCSS, Region region, ObservableList<Image> icons) {
		this(title, baseCSS, region, PREF_WIDTH, PREF_HEIGHT, icons);
	}

	public Modal(String title, String baseCSS, Region region, double width, double height) {
		this(title, baseCSS, region, width, height, null);
	}

	public Modal(String title, String baseCSS, Region region, double width, double height, ObservableList<Image> icons) {
		this.modalTitle = title;
        this.baseCSS = baseCSS;
		this.view = region;
		this.width = width;
		this.height = height;
        this.icons = icons;
    }

	public void open() {
		Scene scene = new Scene(this.view, this.width, this.height);
		scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource(this.baseCSS)).toExternalForm());

		Stage stage = new Stage();
		stage.setTitle(modalTitle);
		if(icons!=null) stage.getIcons().addAll(icons); // Copy icons from primary stage
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initStyle(StageStyle.UTILITY);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setOnCloseRequest(evt ->  {
			CustomAlertBuilder.customAlert()
							  .setPrimaryStage(stage)
							  .setContentText("Usare i pulsanti per salvare o uscire")
							  .warning()
							  .build();
			evt.consume();
		});// to bypass the close button
		stage.setScene(scene);

		// Show the dialog and wait until the user closes it
		stage.showAndWait();
	}
}
