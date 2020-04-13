package com.example.muhammadfaheem.Hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;


public class RecieveSMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        String smsBody = "";
        String sendingNumber = "";

//        MainActivity n = new MainActivity();
        if (intentExtras != null) {

            SmsManager sms1 = SmsManager.getDefault();
            Object[] sms = (Object[]) intentExtras.get("pdus");
            if (sms == null || sms.length ==0){
                Log.d("TEST", "sdsdad");
                return;
            }
            for (Object sm : sms) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sm);
                smsBody = smsMessage.getMessageBody().trim();
                sendingNumber = smsMessage.getOriginatingAddress();

                if (smsBody.equalsIgnoreCase("hi")) {
                    sms1.sendTextMessage(sendingNumber, null, "Hello", null, null);
                }

            }
        }
    }
}
