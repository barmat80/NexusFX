package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextFormatter;

/**
 * Defines a fluent builder API for constructing {@link TextFieldRow} instances.
 *
 * <p>This interface provides a type-safe builder pattern with multiple stages
 * that guide users through the configuration process: width configuration,
 * property binding (optional), formatter application (optional), and additional
 * customization options.</p>
 *
 * <p>The builder pattern ensures a clear and intuitive API where each stage
 * returns the appropriate next interface, preventing invalid configurations
 * and providing IDE auto-completion support.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * // Simple text field with string property
 * TextFieldRow row1 = builder
 *     .width(200)
 *     .stringProperty(myStringProperty)
 *     .withoutFormatter()
 *     .label("Name")
 *     .build();
 *
 * // Numeric field with custom formatter
 * TextFormatter<Integer> customFormatter = new TextFormatter<>(
 *     new IntegerStringConverter()
 * );
 * TextFieldRow row2 = builder
 *     .width(150)
 *     .integerProperty(myIntegerProperty)
 *     .integerFormatter(customFormatter)
 *     .label("Quantity")
 *     .setDisabled()
 *     .build();
 *
 * // Field without property binding
 * TextFieldRow row3 = builder
 *     .width(300)
 *     .withoutProperty()
 *     .stringFormatter(myFormatter)
 *     .label("Notes")
 *     .extraLabel("Optional")
 *     .build();
 * }</pre>
 *
 * @see TextFieldRow
 */
public interface TextFieldRowBuilders {
    interface TextField {
        Property width(int width);
    }

    interface Property {
        Formatter withoutProperty();
        Formatter stringProperty(StringProperty property);
        Formatter integerProperty(IntegerProperty property);
        Formatter doubleProperty(DoubleProperty property);
    }

    interface Formatter {
        Optionals withoutFormatter();
        Optionals stringFormatter(TextFormatter<String> formatter);
        Optionals integerFormatter(TextFormatter<Integer> formatter);
        Optionals doubleFormatter(TextFormatter<Double> formatter);
    }

    interface Optionals {
        Optionals label(String label);
        Optionals setDisabled();
        Optionals setEditableBinding(BooleanBinding binding);
        Optionals extraLabel(StringProperty extraLabel);
        Optionals extraLabel(String extraLabel);
        TextFieldRow build();
    }
}
