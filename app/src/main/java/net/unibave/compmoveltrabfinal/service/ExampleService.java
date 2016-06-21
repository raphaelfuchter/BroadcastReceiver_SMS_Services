package net.unibave.compmoveltrabfinal.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ExampleService extends Service {

    private static final String TAG = "ExampleService";

    private boolean isRunning  = false;

    @Override
    public void onCreate() {
        Log.v(TAG, "Service onCreate");
        isRunning = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "Service onStartCommand");
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
                        Log.v(TAG, "Service está executando");
                    }
                }

                stopSelf();//Parar service após terminar a sua tarefa/função
            }
        }).start();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent arg0) {
        Log.v(TAG, "Service onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        isRunning = false;
        Log.v(TAG, "Service foi parado/destruido");
    }
}
