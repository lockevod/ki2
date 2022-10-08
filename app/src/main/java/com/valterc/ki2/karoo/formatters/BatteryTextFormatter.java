package com.valterc.ki2.karoo.formatters;

import androidx.annotation.NonNull;

import com.valterc.ki2.data.connection.ConnectionInfo;
import com.valterc.ki2.data.connection.ConnectionStatus;
import com.valterc.ki2.data.device.BatteryInfo;
import com.valterc.ki2.karoo.Ki2Context;

import java.util.function.Consumer;

import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;

public class BatteryTextFormatter extends SdkFormatter {

    private final Consumer<ConnectionInfo> connectionInfoConsumer = connectionInfo -> {
        connectionStatus = connectionInfo.getConnectionStatus();
    };

    private final Consumer<BatteryInfo> batteryInfoConsumer = batteryInfo -> {
        batteryValue = batteryInfo.getValue();
    };

    private ConnectionStatus connectionStatus;
    private int batteryValue;

    public BatteryTextFormatter(Ki2Context ki2Context) {
        ki2Context.getServiceClient().registerConnectionInfoListener(connectionInfoConsumer);
        ki2Context.getServiceClient().registerBatteryInfoListener(batteryInfoConsumer);
    }

    @NonNull
    @Override
    public String formatValue(double value) {
        if (connectionStatus != ConnectionStatus.ESTABLISHED) {
            return "N/A";
        }

        return Integer.toString(batteryValue);
    }

}
