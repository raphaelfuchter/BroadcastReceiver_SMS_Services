package net.unibave.compmoveltrabfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.unibave.compmoveltrabfinal.broadcastreceiver.BroadcastReceiverActivity;
import net.unibave.compmoveltrabfinal.service.ServiceActivity;
import net.unibave.compmoveltrabfinal.sms.SMSActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Evento do botão Broadcast Receiver
     * @param view View
     */
    public void btnOkOnClickBroadcastReceiver(View view) {
        Intent intent = new Intent(this, BroadcastReceiverActivity.class);
        startActivity(intent);
    }

    /**
     * Evento do botão SMS
     * @param view View
     */
    public void btnOkOnClickSMS(View view) {
        Intent intent = new Intent(this, SMSActivity.class);
        startActivity(intent);
    }

    /**
     * Evento do botão Service
     * @param view View
     */
    public void btnOkOnClickService(View view) {
        Intent intent = new Intent(this, ServiceActivity.class);
        startActivity(intent);
    }

}
