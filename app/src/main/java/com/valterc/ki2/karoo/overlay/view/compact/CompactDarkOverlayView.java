package com.valterc.ki2.karoo.overlay.view.compact;

import android.view.View;

import com.valterc.ki2.R;
import com.valterc.ki2.data.preferences.PreferencesView;
import com.valterc.ki2.karoo.Ki2ExtensionContext;

public class CompactDarkOverlayView extends CompactOverlayView {

    public CompactDarkOverlayView(Ki2ExtensionContext context, PreferencesView preferences, View view) {
        super(context, preferences, view);

        getViewHolder().getOverlayView().setBackgroundResource(R.drawable.background_overlay_dark);

        getViewHolder().getTextViewGearing().setTextColor(getContext().getColor(android.R.color.primary_text_dark));
        getViewHolder().getTextViewGearingExtra().setTextColor(getContext().getColor(android.R.color.primary_text_dark));
        getViewHolder().getTextViewGearingRatio().setTextColor(getContext().getColor(android.R.color.primary_text_dark));
    }

}
