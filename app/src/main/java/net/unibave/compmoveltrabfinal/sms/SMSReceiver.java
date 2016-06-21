package net.unibave.compmoveltrabfinal.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import net.unibave.compmoveltrabfinal.MainActivity;

public class SMSReceiver extends BroadcastReceiver {

    static final String TAG_FONE = "fone";
    static final String TAG_MSG = "msg";

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        SmsMessage sms = msgs[0];

        Intent it = new Intent(context, ReceiveSMSActivity.class);
        it.putExtra(TAG_FONE, sms.getOriginatingAddress());// Telefone
        it.putExtra(TAG_MSG, sms.getMessageBody());// Mensagem
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}