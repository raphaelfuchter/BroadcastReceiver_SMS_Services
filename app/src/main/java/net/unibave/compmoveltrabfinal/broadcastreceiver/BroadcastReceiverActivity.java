package net.unibave.compmoveltrabfinal.broadcastreceiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import net.unibave.compmoveltrabfinal.R;

/**
 * http://www.tutorialspoint.com/android/android_broadcast_receivers.htm
 * http://stacktips.com/tutorials/android/how-to-start-an-application-at-device-bootup-in-android
 */
public class BroadcastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    /**
     * Evento do botão Outras Opções Disponíveis
     * @param view view
     */
    public void btnOutrasOpcoesDisponiveis(View view) {
        new MaterialDialog.Builder(this)
                .items(R.array.array_broadcastreceiver)
                .show();
    }

}
