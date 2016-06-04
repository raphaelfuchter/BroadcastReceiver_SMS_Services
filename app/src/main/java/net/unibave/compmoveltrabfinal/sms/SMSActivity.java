package net.unibave.compmoveltrabfinal.sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.unibave.compmoveltrabfinal.R;

public class SMSActivity extends AppCompatActivity {

    private EditText editTextTelefone;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);

    }

    public void btnSendSmsOnClick(View view) {
        String phoneNo = editTextTelefone.getText().toString();
        String message = editTextMessage.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS enviado.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro no envio do SMS.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
