package com.maemlab.nexusfx.widgets.dialogs.alert;

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
        Optionals info();
        Optionals warning();
        Optionals error();
        Except exception();
    }

    interface Except {
        Optionals setException(Throwable throwable);
        Optionals setException(java.lang.Exception ex);
    }

    interface Optionals {
        Optionals setTitle(String title);
        Optionals setHeader(String header);
        ButtonType build();
    }
}
