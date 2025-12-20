package com.maemlab.nexusfx.panes.twocolumns.row;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;

/**
 * A fluent builder implementation for constructing {@link TextFieldRow} instances
 * following the {@link TextFieldRowBuilders} interface contract.
 *
 * <p>This builder provides a type-safe, step-by-step construction process for
 * creating configured text field rows with optional property bindings, formatters,
 * labels, and customization options.</p>
 *
 * <p>The builder uses a fluent API pattern where each method returns the appropriate
 * interface stage, ensuring compile-time safety and preventing invalid configurations.</p>
 *
 * <p><b>Usage:</b></p>
 * <p>Create a new builder instance using the static factory method
 * {@link #textFieldRow()}, then chain configuration methods according to your needs.</p>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * // Build a text field with string property and custom formatter
 * TextFieldRow nameField = TextFieldRowBuilder.textFieldRow()
 *     .width(250)
 *     .stringProperty(person.nameProperty())
 *     .stringFormatter(new TextFormatter<>(new UpperCaseFilter()))
 *     .label("Full Name")
 *     .build();
 *
 * // Build a numeric field with integer property
 * TextFieldRow ageField = TextFieldRowBuilder.textFieldRow()
 *     .width(100)
 *     .integerProperty(person.ageProperty())
 *     .integerFormatter(new IntegerFormatter().getTextFormatter())
 *     .label("Age")
 *     .setDisabled()
 *     .build();
 *
 * // Build a field without property binding
 * TextFieldRow notesField = TextFieldRowBuilder.textFieldRow()
 *     .width(400)
 *     .withoutProperty()
 *     .withoutFormatter()
 *     .label("Notes")
 *     .extraLabel("Optional")
 *     .build();
 * }</pre>
 *
 * @see TextFieldRow
 * @see TextFieldRowBuilders
 */
public class TextFieldRowBuilder implements TextFieldRowBuilders.TextField, TextFieldRowBuilders.Property, TextFieldRowBuilders.Formatter, TextFieldRowBuilders.Optionals {
    private int width;

    private StringProperty stringProperty;
    private IntegerProperty integerProperty;
    private DoubleProperty doubleProperty;
    private BooleanBinding editableBinding;

    private TextFormatter<String> stringFormatter;
    private TextFormatter<Integer> integerFormatter;
    private TextFormatter<Double> doubleFormatter;

    private String label;
    private StringProperty extraLabelProperty;
    private String extraLabelString;
    private boolean isEditable;

    private TextFieldRowBuilder() {
        this.isEditable = true;
        this.width = 100; // default width
    }

    public static TextFieldRowBuilders.TextField textFieldRow() {
        return new TextFieldRowBuilder();
    }

    @Override
    public TextFieldRowBuilders.Property width(int width) {
        if(width <= 0) throw new IllegalArgumentException("Width must be positive");
        this.width = width;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Formatter withoutProperty() {
        return this;
    }

    @Override
    public TextFieldRowBuilders.Formatter stringProperty(StringProperty property) {
        this.stringProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Formatter integerProperty(IntegerProperty property) {
        this.integerProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Formatter doubleProperty(DoubleProperty property) {
        this.doubleProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals withoutFormatter() {
        return this;
    }
    @Override
    public TextFieldRowBuilders.Optionals stringFormatter(TextFormatter<String> formatter) {
        this.stringFormatter = formatter;
        return this;
    }
    @Override
    public TextFieldRowBuilders.Optionals integerFormatter(TextFormatter<Integer> formatter){
        this.integerFormatter = formatter;
        return this;
    }
    @Override
    public TextFieldRowBuilders.Optionals doubleFormatter(TextFormatter<Double> formatter) {
        this.doubleFormatter = formatter;
        return this;
    }
    @Override
    public TextFieldRowBuilders.Optionals label(String label) {
        this.label = label;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals setDisabled() {
        this.isEditable = false;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals setEditableBinding(BooleanBinding binding) {
        this.editableBinding = binding;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals extraLabel(StringProperty extraLabel) {
        this.extraLabelProperty = extraLabel;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals extraLabel(String extraLabel) {
        this.extraLabelString = extraLabel;
        return this;
    }

    @Override
    public TextFieldRow build() {
        var row = new TextFieldRow().addLabel(buildLabel()).addExtraLabel(buildExtraLabel()).build(this.width, this.isEditable);
        if(stringProperty != null) row.setStringProperty(stringProperty);
        if(integerProperty != null) row.setIntegerProperty(integerProperty);
        if(doubleProperty != null) row.setDoubleProperty(doubleProperty);
        if(stringFormatter != null) row.setStringFormatter(stringFormatter);
        if(integerFormatter != null) row.setIntegerFormatter(integerFormatter);
        if(doubleFormatter != null) row.setDoubleFormatter(doubleFormatter);
        if(editableBinding != null) row.setEditableBinding(editableBinding);
        return row;
    }

    private Label buildLabel() {
        Label lbl = null;
        if (this.label != null) {
            lbl = new Label(this.label);
            GridPane.setHalignment(lbl, HPos.RIGHT);
        }
        return lbl;
    }

    private Label buildExtraLabel() {
        Label lbl = null;
        if (this.extraLabelProperty != null || this.extraLabelString != null) {
            lbl = new Label();
            if (this.extraLabelProperty != null) lbl.textProperty().bindBidirectional(this.extraLabelProperty);
            if (this.extraLabelString != null) lbl.setText(extraLabelString);
            GridPane.setHalignment(lbl, HPos.LEFT);
        }
        return lbl;
    }
}
