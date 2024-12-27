package com.maemlab.nexusfx.widgets.table;

import javafx.scene.control.TableColumn;

public final class ColumnUtil {

	private ColumnUtil() {
	}

	public static <S, T> TableColumn<S, T> createUnsortableColumn(String label, double width, String... styles) {
		return createColumn(label, width, false, styles);
	}

	public static <S, T> TableColumn<S, T> createSortableColumn(String label, double width, String... styles) {
		return createColumn(label, width, true, styles);
	}

	public static <S, T> TableColumn<S, T> createColumn(String label, double width, boolean sortable, String... styles) {
		TableColumn<S, T> col = new TableColumn<>(label);
		col.setText(label);
		// col.setMaxWidth(width);
		col.setMinWidth(width);
		col.setPrefWidth(width);
		col.setResizable(true);
		col.setSortable(sortable);
		col.getStyleClass().addAll(styles);
		return col;
	}
}
