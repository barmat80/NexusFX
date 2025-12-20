module NexusFX {
    requires atlantafx.base;

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;

    exports com.maemlab.nexusfx;
    exports com.maemlab.nexusfx.dirty;
    exports com.maemlab.nexusfx.dialogs.alert;
    exports com.maemlab.nexusfx.dialogs.modal;
    exports com.maemlab.nexusfx.filters;
    exports com.maemlab.nexusfx.formatters;
    exports com.maemlab.nexusfx.listview.cells;
    exports com.maemlab.nexusfx.listview.enhancedchecklistview;
    exports com.maemlab.nexusfx.nav;
    exports com.maemlab.nexusfx.panes.browse;
    exports com.maemlab.nexusfx.panes.twocolumns;
    exports com.maemlab.nexusfx.panes.twocolumns.row;
    exports com.maemlab.nexusfx.tableview;
    exports com.maemlab.nexusfx.tableview.cells;
    exports com.maemlab.nexusfx.toolbar;
}