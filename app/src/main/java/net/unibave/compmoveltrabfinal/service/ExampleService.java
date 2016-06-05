package net.unibave.compmoveltrabfinal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ExampleService extends Service {

    private static final String TAG = "ExampleService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Toast.makeText(ServiceActivity.context, "Service onCreate", Toast.LENGTH_LONG).show();
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(ServiceActivity.context, "Service onStartCommand", Toast.LENGTH_LONG).show();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if(isRunning){
                        Toast.makeText(ServiceActivity.context, "Service está executando", Toast.LENGTH_LONG).show();
                    }
                }

                stopSelf();//Parar service após terminar a sua tarefa/função
            }
        }).start();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Toast.makeText(ServiceActivity.context, "Service onBind", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        Toast.makeText(ServiceActivity.context, "Service foi parado/destruido", Toast.LENGTH_LONG).show();
    }
}
