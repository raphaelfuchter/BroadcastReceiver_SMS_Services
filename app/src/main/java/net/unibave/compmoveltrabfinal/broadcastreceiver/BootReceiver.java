package net.unibave.compmoveltrabfinal.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import net.unibave.compmoveltrabfinal.MainActivity;

public class BootReceiver extends BroadcastReceiver {

    /**
     * Evento para quando o SO for reiniciado (ele abre o próprio app)
     * @param context context
     * @param intent intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

}
