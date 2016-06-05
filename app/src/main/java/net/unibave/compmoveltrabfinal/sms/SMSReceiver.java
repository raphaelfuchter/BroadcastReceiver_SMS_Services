package net.unibave.compmoveltrabfinal.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {
    private String TAG = SMSReceiver.class.getSimpleName();

    public SMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the data (SMS data) bound to intent
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs;

        String str = "";

        if (bundle != null) {

            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");

            if(pdus != null) {
                msgs = new SmsMessage[pdus.length];

                // For every SMS message received
                for (int i = 0; i < msgs.length; i++) {

                    // Convert Object array
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                    // Sender's phone number
                    str += "SMS from " + msgs[i].getOriginatingAddress() + " : ";

                    // Fetch the text message
                    str += msgs[i].getMessageBody();

                    str += "\n";
                }
            }

            // Display the entire SMS Message
            Log.d(TAG, str);
        }
    }
}