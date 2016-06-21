package net.unibave.compmoveltrabfinal.sms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import net.unibave.compmoveltrabfinal.R;

public class SendSMSActivity extends AppCompatActivity {

    private EditText editTextTelefone;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
    }

    /**
     * Evento do botão para enviar SMS
     * @param view view
     */
    public void btnSendSmsOnClick(View view) {
        String phoneNo = editTextTelefone.getText().toString();
        String message = editTextMessage.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();// Cria instancia de SMSManager
            smsManager.sendTextMessage(phoneNo, null, message, null, null);// Envia a mensagem
            Toast.makeText(getApplicationContext(), "SMS enviado.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Erro no envio do SMS.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /**
     * Evento do botão para enviar SMS pelo Intent
     * @param view view
     */
    public void btnSendSmsIntentOnClick(View view) {
        String phoneNo = editTextTelefone.getText().toString();
        String message = editTextMessage.getText().toString();

        Uri uri = Uri.fromParts("sms", phoneNo, null);// Cria Uri com o número de telefone
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);// Cria intent com a URI e o evento para envio de SMS
        it.putExtra("sms_body", message);// Define a mensagem do SMS
        startActivity(it);// Inicia o intent
}

}
