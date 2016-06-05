package net.unibave.compmoveltrabfinal.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.unibave.compmoveltrabfinal.R;

/**
 * http://www.tutorialspoint.com/android/android_sending_sms.htm
 * http://codetheory.in/android-sms/
 */
public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    public void btnSendSmsOnClick(View view) {
        Intent intent = new Intent(this, SendSMSActivity.class);
        startActivity(intent);
    }

    public void btnReceiveSmsOnClick(View view) {
        //Intent intent = new Intent(this, SendSMSActivity.class);
        //startActivity(intent);
    }

}
