package com.maemlab.nexusfx.dirty;

import javafx.beans.property.BooleanPropertyBase;

public class DirtyBooleanProperty extends BooleanPropertyBase implements DirtyProperty<Boolean> {
    private final Object bean;
    private final String name;
    private final DirtyPropertyBase<Boolean> dirtyPropertyBase;

    public DirtyBooleanProperty(Object bean, String name, boolean initialValue) {
        super.setValue(initialValue);
        this.bean = bean;
        this.name = name;
        this.dirtyPropertyBase = new DirtyPropertyBase<>(this.asObject());
    }

    public DirtyBooleanProperty(String name, boolean initialValue) {
        this(null, name, initialValue);
    }

    public DirtyBooleanProperty(boolean initialValue) {
        this(null, "", initialValue);
    }

    @Override
    public Object getBean() {return bean;}

    @Override
    public String getName() {return name;}

    @Override
    public DirtyPropertyBase<Boolean> getDirtyPropertyBase() {return dirtyPropertyBase;}
}
