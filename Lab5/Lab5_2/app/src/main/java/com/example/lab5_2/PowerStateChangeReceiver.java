package com.example.lab5_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerStateChangeReceiver extends BroadcastReceiver {


    
    @Override
    public void onReceive(Context context, Intent intent) {
        if(context == null) {
            return;
        }
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Toast.makeText(context, "Power disconnected", Toast.LENGTH_SHORT).show();
        }

//        String action = intent.getAction();
//        if (action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)) {
//            // Lấy thông tin trạng thái sạc pin
//            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//
//            // Kiểm tra trạng thái sạc pin
//            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
//                    || status == BatteryManager.BATTERY_STATUS_FULL;
//
//            // Hiển thị thông báo
//            if (isCharging) {
//                Toast.makeText(context, "Đang sạc pin", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(context, "Không sạc pin", Toast.LENGTH_SHORT).show();
//            }
//        }
    }
    
    
}
