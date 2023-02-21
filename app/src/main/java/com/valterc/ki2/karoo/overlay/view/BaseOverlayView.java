package com.valterc.ki2.karoo.overlay.view;

import android.content.Context;
import android.view.View;

import com.valterc.ki2.data.device.BatteryInfo;
import com.valterc.ki2.data.preferences.device.DevicePreferencesView;
import com.valterc.ki2.data.shifting.ShiftingInfo;

public abstract class BaseOverlayView<TViewHolder extends BaseOverlayViewHolder> implements IOverlayView {

    private final Context context;

    private final TViewHolder viewHolder;

    public BaseOverlayView(Context context, TViewHolder viewHolder) {
        this.context = context;
        this.viewHolder = viewHolder;
    }

    public Context getContext() {
        return context;
    }

    protected TViewHolder getViewHolder() {
        return viewHolder;
    }

    @Override
    public void remove() {
        viewHolder.removeFromHierarchy();
    }

    public void show() {
        viewHolder.getOverlayView().setVisibility(View.VISIBLE);
    }

    public void hide() {
        viewHolder.getOverlayView().setVisibility(View.GONE);
    }

    public abstract void updateView(ShiftingInfo shiftingInfo, BatteryInfo batteryInfo, DevicePreferencesView devicePreferences);

}
