package com.maemlab.nexusfx.dirty;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

import java.util.Objects;

public class DirtyPropertyBase<T> {
    private final ObjectProperty<T> originalProperty;
    private final Property<T> dirtyProperty;
    private final ObservableValue<Boolean> isDirty;

    public DirtyPropertyBase(Property<T> originalProp) {
        this.originalProperty = new SimpleObjectProperty<>(originalProp.getValue());
        this.dirtyProperty = originalProp;
        this.isDirty = Bindings.createBooleanBinding(
                                                        () -> !Objects.equals(this.originalProperty.getValue(), this.dirtyProperty.getValue()),
                                                        this.originalProperty,
                                                        this.dirtyProperty
                                                        );
    }

    public void reset() {
        this.dirtyProperty.setValue(this.originalProperty.getValue());
    }

    public boolean isDirty() {return isDirty.getValue();}
}
