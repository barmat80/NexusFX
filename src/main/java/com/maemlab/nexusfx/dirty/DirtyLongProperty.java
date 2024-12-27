package com.maemlab.nexusfx.dirty;

import javafx.beans.property.LongPropertyBase;

public class DirtyLongProperty extends LongPropertyBase implements DirtyProperty<Long> {
    private final Object bean;
    private final String name;
    private final DirtyPropertyBase<Long> dirtyPropertyBase;

    public DirtyLongProperty(Object bean, String name, long initialValue) {
        super.setValue(initialValue);
        this.bean = bean;
        this.name = name;
        this.dirtyPropertyBase = new DirtyPropertyBase<>(this.asObject());
    }

    public DirtyLongProperty(String name, long initialValue) {
        this(null, name, initialValue);
    }

    public DirtyLongProperty(long initialValue) {
        this(null, "", initialValue);
    }

    @Override
    public Object getBean() {return bean;}

    @Override
    public String getName() {return name;}

    @Override
    public DirtyPropertyBase<Long> getDirtyPropertyBase() {return dirtyPropertyBase;}
}
