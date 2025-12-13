package com.maemlab.nexusfx.dialogs.alert;

import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public interface CustomAlertBuilders {
    interface PrimaryStage {
        ContentText setPrimaryStage(Stage primaryStage);
    }

    interface ContentText {
        Type setContentText(String content);
    }

    interface Type {
        Optionals confirm();
        ConfirmationType confirmCustom();
        Optionals info();
        Optionals warning();
        Optionals error();
        Except exception();
    }

    interface ConfirmationType {
        Optionals standard();
        Optionals buttons(ButtonType... buttons);
    }

    interface Except {
        Optionals setException(Throwable throwable);
        Optionals setException(Exception ex);
    }

    interface Optionals {
        Optionals setTitle(String title);
        Optionals setHeader(String header);
        ButtonType build();
    }
}
