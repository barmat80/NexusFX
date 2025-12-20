package com.maemlab.nexusfx.dialogs;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class FileChooserDialogs {
    private FileChooserDialogs() {}

    public static File chooseDirectory(String title, File initialDirectory, Window window) {
        var chooser = new DirectoryChooser();
        chooser.setTitle(title);
        if(initialDirectory != null)
            chooser.setInitialDirectory(initialDirectory);

        File dir = chooser.showDialog(window);
        return dir == null ? initialDirectory : dir;
    }

    public static File chooseFile(String title, File initialFile, Window window) {
        return chooseFile(title, initialFile, window, new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif"));
    }

    public static File chooseFile(String title, File initialFile, Window window, FileChooser.ExtensionFilter... extensionFilters)  {
        var chooser = new FileChooser();
        chooser.setTitle(title);

        if (extensionFilters != null && extensionFilters.length > 0) {
            chooser.getExtensionFilters().addAll(extensionFilters);
        }

        if(initialFile != null && initialFile.getParentFile() != null) {
            chooser.setInitialDirectory(initialFile.getParentFile());
            chooser.setInitialFileName(initialFile.getName());
        }

        File selected = chooser.showOpenDialog(window);
//        return f == null ? (initialFile == null ? new File("") : initialFile) : f;
        return selected != null ? selected : initialFile;

    }
}
