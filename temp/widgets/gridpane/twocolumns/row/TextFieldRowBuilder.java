package com.maemlab.nexusfx.widgets.gridpane.twocolumns.row;

import com.maemlab.nexusfx.data.beans.autocompletion.BeanConverter;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSelectionHandler;
import com.maemlab.nexusfx.data.beans.autocompletion.BeanSuggesterCallback;
import com.maemlab.nexusfx.data.beans.autocompletion.StringSuggesterCallback;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TextFieldRowBuilder implements TextFieldRowBuilders.TextField, TextFieldRowBuilders.Formatter, TextFieldRowBuilders.Suggester, TextFieldRowBuilders.Optionals {
    private int width;

    private StringProperty stringProperty;
    private IntegerProperty integerProperty;
    private DoubleProperty doubleProperty;
    private BooleanBinding disableBinding;

    private BeanSuggesterCallback beanSuggester;
    private BeanSelectionHandler beanHandler;
    private BeanConverter beanConverter;
    private StringSuggesterCallback stringSuggester;

    private String label;
    private StringProperty extraLabel;
    private boolean isEditable;

    private TextFieldRowBuilder() {
        this.isEditable = true;
    }

    public static TextFieldRowBuilders.TextField textFieldRow() {
        return new TextFieldRowBuilder();
    }

    @Override
    public TextFieldRowBuilders.Formatter width(int width) {
        this.width = width;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Suggester withoutProperty() {
        return this;
    }

    @Override
    public TextFieldRowBuilders.Suggester stringProperty(StringProperty property) {
        this.stringProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Suggester integerProperty(IntegerProperty property) {
        this.integerProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Suggester doubleProperty(DoubleProperty property) {
        this.doubleProperty = property;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals withoutSuggester() {
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals beanSuggester(BeanSuggesterCallback suggester, BeanSelectionHandler handler, BeanConverter converter) {
        this.beanSuggester = suggester;
        this.beanHandler = handler;
        this.beanConverter = converter;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals stringSuggester(StringSuggesterCallback suggester) {
        this.stringSuggester = suggester;
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
    public TextFieldRowBuilders.Optionals setDisableBinding(BooleanBinding binding) {
        this.disableBinding = binding;
        return this;
    }

    @Override
    public TextFieldRowBuilders.Optionals extraLabel(StringProperty extraLabel) {
        this.extraLabel = extraLabel;
        return this;
    }

    @Override
    public TextFieldRow build() {
        var row = new TextFieldRow().addLabel(buildLabel()).addExtraLabel(buildExtraLabel()).build(this.width, this.isEditable);
        if(stringProperty != null) row.setStringProperty(stringProperty);
        if(integerProperty != null) row.setIntegerProperty(integerProperty);
        if(doubleProperty != null) row.setDoubleProperty(doubleProperty);
        if(disableBinding != null) row.setDisableBinding(disableBinding);
        if(beanSuggester != null) row.setBeanSuggester(beanSuggester, beanHandler, beanConverter);
        if(stringSuggester != null) row.setStringSuggester(stringSuggester);
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
        if (this.extraLabel != null) {
            lbl = new Label("ciccio");
            lbl.textProperty().bindBidirectional(this.extraLabel);
            GridPane.setHalignment(lbl, HPos.LEFT);
        }
        return lbl;
    }
}
