package com.rdi.batterylelel;

public class BatteryInfo {

    private final float mBatterylevel;
    private final boolean mIsCharging;


    public BatteryInfo(float batterylevel, boolean isCharging) {
        mBatterylevel = batterylevel;
        mIsCharging = isCharging;
    }

    public float getBatterylevel() {
        return mBatterylevel;
    }

    public boolean isCharging() {
        return mIsCharging;
    }

    @Override
    public String toString() {
        return "BatteryInfo{" +
                "mBatterylevel=" + mBatterylevel +
                ", mIsCharging=" + mIsCharging +
                '}';
    }
}
