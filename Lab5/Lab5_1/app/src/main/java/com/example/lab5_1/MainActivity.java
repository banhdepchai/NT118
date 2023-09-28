package com.example.lab5_1;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private IntentFilter filter;

    public void processReceive(Context context, Intent intent) {
        Toast.makeText(context, getString(R.string.you_have_a_new_message), Toast.LENGTH_LONG).show();

        TextView tvContent = findViewById(R.id.tv_content);

        final String SMS_EXTRA = "pdus";
        Bundle bundle = intent.getExtras();

        Object[] messages = (Object[]) bundle.get(SMS_EXTRA);
        String sms = "";

        SmsMessage smsMsg;
        for (int i = 0; i < messages.length; i++) {
            sms += "Message " + (i + 1) + ":\n";
            smsMsg = SmsMessage.createFromPdu((byte[]) messages[i]);
            sms += smsMsg.getMessageBody() + "\n";
            sms += "From: " + smsMsg.getOriginatingAddress() + "\n";
        }

        tvContent.setText(sms);
    }

    private void initBroadcastReceiver() {
        filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                processReceive(context, intent);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (broadcastReceiver == null) {
            initBroadcastReceiver();
        }

        registerReceiver(broadcastReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBroadcastReceiver();
    }
}