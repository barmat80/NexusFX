package com.maemlab.nexusfx.listview.enhancedchecklistview;

import java.util.HashMap;
import java.util.Map;

import com.maemlab.nexusfx.listview.enhancedchecklistview.impl.CheckBitSetModelBase;
import com.maemlab.nexusfx.listview.enhancedchecklistview.impl.IndexedCheckModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EnhancedCheckListView<T> extends ListView<T> {

    private final Map<T, BooleanProperty> itemBooleanMap;

    public EnhancedCheckListView() {
        this(FXCollections.observableArrayList());
    }
    
    public EnhancedCheckListView(ObservableList<T> items) {
        super(items);
        this.itemBooleanMap = new HashMap<>();
        
        setCheckModel(new CheckListViewBitSetCheckModel<>(getItems(), itemBooleanMap));
        itemsProperty().addListener(ov -> setCheckModel(new CheckListViewBitSetCheckModel<>(getItems(), itemBooleanMap)));

        //TODO I think this isn't useful anymore and that I can call setCellFactory from outside, pointing to the itemBooleanMap
        // to handle the selection

//        setCellFactory(listView -> {
//            final CheckBoxListCell<T> checkBoxListCell = new CheckBoxListCell<>(this::getItemBooleanProperty);
//            checkBoxListCell.focusedProperty().addListener((o, ov, nv) -> {
//                if (nv) {
//                    final Parent parent = checkBoxListCell.getParent();
//                    if (parent != null) {
//                        parent.requestFocus();
//                    }
//                }
//            });
//            return checkBoxListCell;
//        });

        addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.SPACE) {
                T item = getSelectionModel().getSelectedItem();
                if (item != null) {
                    final IndexedCheckModel<T> checkModel = getCheckModel();
                    if (checkModel != null) {
                        if (checkModel.isChecked(item)) {
                            checkModel.clearCheck(item);
                        } else {
                            checkModel.check(item);
                        }
                    }
                }
            }
        });
    }

    /**
     * Returns the {@link BooleanProperty} for a given item index in the 
     * CheckListView. This is useful if you want to bind to the property.
     */
    public BooleanProperty getItemBooleanProperty(int index) {
        if (index < 0 || index >= getItems().size()) return null;
        return getItemBooleanProperty(getItems().get(index));
    }
    
    /**
     * Returns the {@link BooleanProperty} for a given item in the 
     * CheckListView. This is useful if you want to bind to the property.
     */
    public BooleanProperty getItemBooleanProperty(T item) {
        return itemBooleanMap.get(item);
    }
    
    // --- Check Model
    private final ObjectProperty<IndexedCheckModel<T>> checkModel = new SimpleObjectProperty<>(this, "checkModel");
    
    /**
     * Sets the 'check model' to be used in the CheckListView - this is the
     * code that is responsible for representing the selected state of each
     * {@link CheckBox} - that is, whether each {@link CheckBox} is checked or 
     * not (and not to be confused with the 
     * selection model concept, which is used in the ListView control to 
     * represent the selection state of each row).
     */
    public final void setCheckModel(IndexedCheckModel<T> value) {
        checkModelProperty().set(value);
    }

    /**
     * Returns the currently installed check model.
     */
    public final IndexedCheckModel<T> getCheckModel() {
        return checkModel.get();
    }

    /**
     * The check model provides the API through which it is possible
     * to check single or multiple items within a CheckListView, as  well as inspect
     * which items have been checked by the user. Note that it has a generic
     * type that must match the type of the CheckListView itself.
     */
    public final ObjectProperty<IndexedCheckModel<T>> checkModelProperty() {
        return checkModel;
    }

    private static class CheckListViewBitSetCheckModel<T> extends CheckBitSetModelBase<T> {
        private final ObservableList<T> items;

        CheckListViewBitSetCheckModel(final ObservableList<T> items, final Map<T, BooleanProperty> itemBooleanMap) {
            super(itemBooleanMap);
            
            this.items = items;
            this.items.addListener((ListChangeListener<T>) c -> updateMap());
            
            updateMap();
        }

        @Override public T getItem(int index) {
            return items.get(index);
        }
        
        @Override public int getItemCount() {
            return items.size();
        }
        
        @Override public int getItemIndex(T item) {
            return items.indexOf(item);
        }
    }
}
