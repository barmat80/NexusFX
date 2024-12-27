package com.maemlab.nexusfx.dirty;

import javafx.beans.property.StringPropertyBase;

public class DirtyStringProperty extends StringPropertyBase implements DirtyProperty<String> {
    private final Object bean;
    private final String name;
    private final DirtyPropertyBase<String> dirtyPropertyBase;

    public DirtyStringProperty(Object bean, String name, String initialValue) {
        super.setValue(initialValue);
        this.bean = bean;
        this.name = name;
        this.dirtyPropertyBase = new DirtyPropertyBase<>(this);
    }

    public DirtyStringProperty(String name, String initialValue) {
        this(null, name, initialValue);
    }

    public DirtyStringProperty(String initialValue) {
        this(null, "", initialValue);
    }

    @Override
    public Object getBean() {
        return bean;
    }

    @Override
    public String getName() {
        return name;
    }

    public DirtyPropertyBase<String> getDirtyPropertyBase() {return dirtyPropertyBase;}
}
