package com.maemlab.nexusfx.widgets;

import atlantafx.base.theme.Styles;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.Node;

public final class ViewBuilderUtil {
    private ViewBuilderUtil() {}

    public static Node createCaption(String label, StringBinding binding) {
        Caption caption = new Caption(Pos.BASELINE_RIGHT);
        caption.addLabel(label, Styles.TEXT_SMALL, Styles.TEXT_MUTED);
        caption.addLabelWithBinding(binding, Styles.TEXT_SMALL, Styles.TEXT_MUTED);
        return caption;
    }
}
