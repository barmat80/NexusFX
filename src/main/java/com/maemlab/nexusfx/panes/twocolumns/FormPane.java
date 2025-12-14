package com.maemlab.nexusfx.panes.twocolumns;

import com.maemlab.nexusfx.panes.twocolumns.row.BrowseRow;

public class FormPane extends TwoColumnsPane {
    private static final int THIRD_COL = 3;

    public FormPane(double hGap, double vGap) {
        super(hGap, vGap);
    }

    public void add(BrowseRow browseRow) {
        add(browseRow.getLabel(), FIRST_COL, rowCount);
        add(browseRow.getTextField(), SECOND_COL, rowCount);
        add(browseRow.getButton(), THIRD_COL, rowCount);
        rowCount++;
    }
}
