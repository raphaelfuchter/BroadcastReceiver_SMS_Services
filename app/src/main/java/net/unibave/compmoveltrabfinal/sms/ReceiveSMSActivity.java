package net.unibave.compmoveltrabfinal.sms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.unibave.compmoveltrabfinal.R;

public class ReceiveSMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_sms);

        final TextView editTextTelefone = (TextView) findViewById(R.id.textView_numero);
        final TextView editTextMessage = (TextView) findViewById(R.id.textView_mensagem);

        Intent intent = getIntent();
        if (intent != null) {
            String telefone = intent.getStringExtra(SMSReceiver.TAG_FONE);
            if (telefone != null) {
                editTextTelefone.setText(telefone);
            }

            String mensagem = intent.getStringExtra(SMSReceiver.TAG_MSG);
            if (telefone != null) {
                editTextMessage.setText(mensagem);
            }
        }
    }
}
