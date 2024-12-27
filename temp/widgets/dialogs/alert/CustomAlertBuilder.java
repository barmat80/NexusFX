package com.maemlab.nexusfx.widgets.dialogs.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class CustomAlertBuilder implements CustomAlertBuilders.PrimaryStage, CustomAlertBuilders.ContentText, CustomAlertBuilders.Type, CustomAlertBuilders.Except, CustomAlertBuilders.Optionals {
	private Stage primaryStage;
	private Alert.AlertType alertType;
	private String title;
	private String header;
	private String contentText;
	private String exception;

	public static CustomAlertBuilders.PrimaryStage customAlert() {
		return new CustomAlertBuilder();
	}

	@Override
	public CustomAlertBuilders.ContentText setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
		return this;
	}

	@Override
	public CustomAlertBuilders.Type setContentText(String contentText) {
		this.contentText = contentText;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals confirm() {
		alertType = Alert.AlertType.CONFIRMATION;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals info() {
		alertType = Alert.AlertType.INFORMATION;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals warning() {
		alertType = Alert.AlertType.WARNING;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals error() {
		alertType = Alert.AlertType.ERROR;
		return this;
	}

	@Override
	public CustomAlertBuilders.Except exception() {
		alertType = Alert.AlertType.ERROR;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals setException(Throwable throwable) {
		var stringWriter = new StringWriter();
		var printWriter = new PrintWriter(stringWriter);
		throwable.printStackTrace(printWriter);
		exception = stringWriter.toString();
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals setException(Exception ex) {
		var stringWriter = new StringWriter();
		var printWriter = new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);
		exception = stringWriter.toString();
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals setTitle(String title) {
		this.title = title;
		return this;
	}

	@Override
	public CustomAlertBuilders.Optionals setHeader(String header) {
		this.header = header;
		return this;
	}

	@Override
	public ButtonType build() {
		CustomAlert ca = new CustomAlert(primaryStage, alertType, getTitle(), header, contentText, exception);
		Optional<ButtonType>result = ca.show();
		if(result.isPresent() && result.get() == ButtonType.OK) {
			return ButtonType.OK;
		}
		return ButtonType.CANCEL;
	}

	private String getTitle() {
		if(title == null || title.isEmpty()) {
			return switch (alertType) {
				case Alert.AlertType.CONFIRMATION -> "Conferma";
				case Alert.AlertType.WARNING -> "Attenzione";
                case Alert.AlertType.INFORMATION -> "Info";
				case Alert.AlertType.ERROR -> "Errore";
				case NONE -> "";
			};
		}
		return title;
	}
}
