package com.maemlab.nexusfx.widgets.gridpane.twocolumns;

import com.maemlab.nexusfx.widgets.gridpane.twocolumns.row.CheckboxRow;
import com.maemlab.nexusfx.widgets.gridpane.twocolumns.row.DatePickerRow;
import com.maemlab.nexusfx.widgets.gridpane.twocolumns.row.RadioRow;
import com.maemlab.nexusfx.widgets.gridpane.twocolumns.row.TextFieldRow;
import javafx.scene.layout.GridPane;

public class TwoColumnsPane extends GridPane {
    private static final int FIRST_COL = 1;
    private static final int SECOND_COL = 2;
    private int rowCount = 0;

    public TwoColumnsPane(double hGap, double vGap) {
        setHgap(hGap);// horizontal gap between columns
        setVgap(vGap);// vertical gap between columns
    }

    public void addRow(TextFieldRow textFieldRow) {
        add(textFieldRow.getLabel(), FIRST_COL, rowCount);

        if(textFieldRow.hasExtraLabel())
            add(textFieldRow.getHBox(), SECOND_COL, rowCount);
        else
            add(textFieldRow.getTextField(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(DatePickerRow datePickerRow) {
        add(datePickerRow.getLabel(), FIRST_COL, rowCount);
        add(datePickerRow.getDatePicker(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(CheckboxRow checkboxRow) {
        add(checkboxRow.getLabel(), FIRST_COL, rowCount);
        add(checkboxRow.getCheckBox(), SECOND_COL, rowCount);
        rowCount++;
    }

    public void addRow(RadioRow radioRow) {
        add(radioRow.getLabel(), FIRST_COL, rowCount);
        add(radioRow.getVBox(), SECOND_COL, rowCount);
        rowCount++;
    }
}
