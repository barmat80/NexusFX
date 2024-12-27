package com.maemlab.nexusfx.widgets.dialogs.alert;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Inspired by AtlantaFX
 */

public class CustomAlert {
	private final Stage ownerStage;
	private final AlertType alertType;
	private final String title;
	private final String header;
	private final String contentText;
	private final String exception;
	private javafx.scene.control.Alert alert;

	public CustomAlert(Stage ownerStage, AlertType alertType, String title, String header, String contentText, String exception) {
		this.ownerStage = ownerStage;
		this.alertType = alertType;
		this.title = title;
		this.header = header;
		this.contentText = contentText;
		this.exception = exception;
	}

	public Optional<ButtonType> show() {
		alert = new javafx.scene.control.Alert(this.alertType);
		alert.setTitle(this.title);
		alert.setHeaderText(this.header);
		alert.setContentText(this.contentText);

		setExceptionArea();

		alert.initOwner(this.ownerStage);
        return alert.showAndWait();
	}

	private void setExceptionArea() {
		if (exception != null) {
			var textArea = new TextArea();
			textArea.setText(this.exception);
			textArea.setEditable(false);
			textArea.setWrapText(false);
			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			var content = new GridPane();
			content.setMaxWidth(Double.MAX_VALUE);
			content.add(new Label("Full stacktrace:"), 0, 0);
			content.add(textArea, 0, 1);

			alert.getDialogPane().setExpandableContent(content);
		}
	}

	public boolean isShowing() {
		if (alert != null) {
			return alert.isShowing();
		}
		return false;
	}
}
