package com.maemlab.nexusfx.dirty;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PropertyTest {
    @Test
    void booleanTest() {
        boolean value = true;
        DirtyBooleanProperty dirtyProperty = new DirtyBooleanProperty(value);
        dirtyProperty.setValue(false);
        assertTrue(dirtyProperty.isDirty());
        dirtyProperty.reset();
        assertFalse(dirtyProperty.isDirty());
    }

    @Test
    void stringTest() {
        DirtyStringProperty dirtyProperty = new DirtyStringProperty("mattia");
        dirtyProperty.setValue("Elia");
        assertTrue(dirtyProperty.isDirty());
        dirtyProperty.reset();
        assertFalse(dirtyProperty.isDirty());
    }

    @Test
    void doubleTest() {
        DirtyDoubleProperty dirtyProperty = new DirtyDoubleProperty(1.0);
        dirtyProperty.setValue(2.0);
        assertTrue(dirtyProperty.isDirty());
        dirtyProperty.reset();
        assertFalse(dirtyProperty.isDirty());
    }

    @Test
    void intTest() {
        DirtyIntegerProperty dirtyProperty = new DirtyIntegerProperty(1);
        dirtyProperty.setValue(2);
        assertTrue(dirtyProperty.isDirty());
        dirtyProperty.reset();
        assertFalse(dirtyProperty.isDirty());
    }

    @Test
    void longTest() {
        DirtyLongProperty dirtyProperty = new DirtyLongProperty(11111);
        dirtyProperty.setValue(22222);
        assertTrue(dirtyProperty.isDirty());
        dirtyProperty.reset();
        assertFalse(dirtyProperty.isDirty());
    }
}
