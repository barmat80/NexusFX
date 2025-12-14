package com.maemlab.nexusfx.panes.twocolumns;

import com.maemlab.nexusfx.panes.twocolumns.row.*;
import javafx.scene.layout.GridPane;

public class TwoColumnsPane extends GridPane {
    protected static final int FIRST_COL = 1;
    protected static final int SECOND_COL = 2;
    protected int rowCount = 0;

    public TwoColumnsPane(double hGap, double vGap) {
        setHgap(hGap);// horizontal gap between columns
        setVgap(vGap);// vertical gap between columns
    }

    public void addRow(TextFieldRow textFieldRow) {
        add(textFieldRow.getLabel(), FIRST_COL, rowCount);

        if(textFieldRow.hasExtraLabel())
            add(textFieldRow.createHBox(), SECOND_COL, rowCount);
        else
            add(textFieldRow.getTextField(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(TextAreaRow textAreaRow) {
        add(textAreaRow.getLabel(), FIRST_COL, rowCount);
        add(textAreaRow.getTextArea(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(DatePickerRow datePickerRow) {
        add(datePickerRow.getLabel(), FIRST_COL, rowCount);
        add(datePickerRow.getDatePicker(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(CheckBoxRow checkboxRow) {
        add(checkboxRow.getLabel(), FIRST_COL, rowCount);
        add(checkboxRow.getCheckBox(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(RadioRow radioRow) {
        add(radioRow.getLabel(), FIRST_COL, rowCount);
        add(radioRow.getVBox(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(LabelRow labelRow) {
        add(labelRow.getLabel(), FIRST_COL, rowCount);
        add(labelRow.getValueLabel(), SECOND_COL, rowCount);
        rowCount++;
    }

    public <T> void addRow(ComboBoxRow<T> comboBoxRow) {
        add(comboBoxRow.getLabel(), FIRST_COL, rowCount);

        if(comboBoxRow.hasExtraLabel())
            add(comboBoxRow.createHBox(), SECOND_COL, rowCount);
        else
            add(comboBoxRow.getComboBox(), SECOND_COL, rowCount);

        rowCount++;
    }
}
