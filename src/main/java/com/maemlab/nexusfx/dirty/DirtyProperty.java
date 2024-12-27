package com.maemlab.nexusfx.dirty;

public interface DirtyProperty<T> {
    DirtyPropertyBase<T> getDirtyPropertyBase();

    default void reset() {getDirtyPropertyBase().reset();}

    default boolean isDirty() {return getDirtyPropertyBase().isDirty();}
}
