package net.unibave.compmoveltrabfinal.sms;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.unibave.compmoveltrabfinal.R;

/**
 * http://www.tutorialspoint.com/android/android_sending_sms.htm
 * http://codetheory.in/android-sms/
 */
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
        try {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
                String[] perms = {"android.permission.SEND_SMS"};
                requestPermissions(perms, 200);
            }else{
                sendSMS();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        try {
            switch (permsRequestCode) {
                case 200:
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        sendSMS();
                    } else {
                        Toast.makeText(this, "Sem permissão do dispositivo para envio de SMS!", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    Toast.makeText(this, "Sem permissão do dispositivo para envio de SMS!", Toast.LENGTH_LONG).show();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    private void sendSMS(){
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
