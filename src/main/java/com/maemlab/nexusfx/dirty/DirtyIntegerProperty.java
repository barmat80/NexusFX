package com.maemlab.nexusfx.dirty;

import javafx.beans.property.IntegerPropertyBase;

public class DirtyIntegerProperty extends IntegerPropertyBase implements DirtyProperty<Integer> {
    private final Object bean;
    private final String name;
    private final DirtyPropertyBase<Integer> dirtyPropertyBase;

    public DirtyIntegerProperty(Object bean, String name, int initialValue) {
        super.setValue(initialValue);
        this.bean = bean;
        this.name = name;
        this.dirtyPropertyBase = new DirtyPropertyBase<>(this.asObject());
    }

    public DirtyIntegerProperty(String name, int initialValue) {
        this(null, name, initialValue);
    }

    public DirtyIntegerProperty(int initialValue) {
        this(null, "", initialValue);
    }

    @Override
    public Object getBean() {return bean;}

    @Override
    public String getName() {return name;}

    @Override
    public DirtyPropertyBase<Integer> getDirtyPropertyBase() {return dirtyPropertyBase;}
}
