package com.maemlab.nexusfx.dirty;

import javafx.beans.property.DoublePropertyBase;

public class DirtyDoubleProperty extends DoublePropertyBase implements DirtyProperty<Double> {
    private final Object bean;
    private final String name;
    private final DirtyPropertyBase<Double> dirtyPropertyBase;

    public DirtyDoubleProperty(Object bean, String name, double initialValue) {
        super.setValue(initialValue);
        this.bean = bean;
        this.name = name;
        this.dirtyPropertyBase = new DirtyPropertyBase<>(this.asObject());
    }

    public DirtyDoubleProperty(String name, double initialValue) {
        this(null, name, initialValue);
    }

    public DirtyDoubleProperty(double initialValue) {
        this(null, "", initialValue);
    }

    @Override
    public Object getBean() {return bean;}

    @Override
    public String getName() {return name;}

    @Override
    public DirtyPropertyBase<Double> getDirtyPropertyBase() {return dirtyPropertyBase;}
}
