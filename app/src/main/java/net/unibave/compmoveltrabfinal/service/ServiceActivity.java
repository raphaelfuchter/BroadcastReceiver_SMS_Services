package net.unibave.compmoveltrabfinal.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.unibave.compmoveltrabfinal.R;

/**
 * http://stacktips.com/tutorials/android/android-service-example
 */
public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }

    /**
     * Evento para iniciar o Service
     * @param view View
     */
    public void btnStartServiceOnClick(View view) {
        Intent intent = new Intent(ServiceActivity.this, ExampleService.class);
        startService(intent);
    }

    /**
     * Evento para parar/destruir o Service
     * @param view View
     */
    public void btnStopServiceOnClick(View view) {
        Intent intent = new Intent(ServiceActivity.this, ExampleService.class);
        stopService(intent);
    }

}
