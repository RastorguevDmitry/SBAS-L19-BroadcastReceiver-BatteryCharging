package com.rdi.batterylelel;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BatteryChangeListener {

    private static final int IMG_CLIP = 10_000;

    private BatteryBroadcastReceiver mBatteryBroadcastReceiver;
    private TextView mTextIsCharging;
    private ImageView mImgBattery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextIsCharging = findViewById(R.id.is_charging);
        mImgBattery = findViewById(R.id.image_battery);
    }


    @Override
    protected void onStart() {
        super.onStart();
        setUpReciver();
    }

    @Override
    protected void onStop() {
        super.onStop();
        destroyReciver();
    }

    void setUpReciver() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        mBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this);
        registerReceiver(mBatteryBroadcastReceiver, intentFilter);
    }

    private void destroyReciver() {
        unregisterReceiver(mBatteryBroadcastReceiver);
        mBatteryBroadcastReceiver = null;
    }

    @Override
    public void onChange(BatteryInfo batteryInfo) {
        mImgBattery.setImageLevel((int) (batteryInfo.getBatterylevel() * IMG_CLIP));
        mTextIsCharging.setText(String.valueOf(batteryInfo.isCharging()));
    }
}
