package com.maemlab.nexusfx.listview.cells;

import com.maemlab.nexusfx.listview.enhancedchecklistview.EnhancedCheckListView;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.util.function.Function;

public class EnhancedCheckListViewCell <T> extends ListCell<T> {
    private final CheckBox checkBox;
    private final HBox content;

    public EnhancedCheckListViewCell(Function<T, BooleanProperty> selectedStateCallback) {
        this.checkBox = new CheckBox();
        this.content = new HBox(10); // 10 pixels spacing
        this.content.setAlignment(Pos.CENTER_LEFT);
        this.content.getChildren().add(checkBox);

        // Add checkbox listener to update the model
        checkBox.setOnAction(e -> {
            if (getItem() != null && getListView() instanceof EnhancedCheckListView<T> listView) {
                if (checkBox.isSelected()) {
                    listView.getCheckModel().check(getItem());
                } else {
                    listView.getCheckModel().clearCheck(getItem());
                }
            }
        });
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null);
        } else {
            // Listen to check model changes
            if (getListView() instanceof EnhancedCheckListView<T> listView) {
                checkBox.setSelected(listView.getCheckModel().isChecked(item));
            }

            // Configure your cell content here
            setGraphic(content);
        }
    }

    // Helper method to add content to the cell
    protected void addContent(Node... nodes) {
        content.getChildren().addAll(nodes);
    }
}
