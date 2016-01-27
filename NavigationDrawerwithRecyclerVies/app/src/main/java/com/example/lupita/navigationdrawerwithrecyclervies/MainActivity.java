package com.example.lupita.navigationdrawerwithrecyclervies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

 /*   public void launchRingDialog(View view) {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please wait ...", "Load Account ...", true);
        ringProgressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Here you should write your time consuming task...
                    // Let the progress ring for 10 seconds...
                    Thread.sleep(500);
                } catch (Exception e) {

                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }*/

    public void launchRingDialog(View v){
        final EditText texto = (EditText) findViewById(R.id.nombrecito);
        //Toast mensaje = Toast.makeText(getApplicationContext(), "Cargando Perfil de: " + texto.getText(), Toast.LENGTH_SHORT);
        //mensaje.show();

        String  str=texto.getText().toString();

        if(str.equalsIgnoreCase(""))
        {
            texto.setHint("please enter username");//it gives user to hint
            texto.setError("please enter username");//it gives user to info message //use any one //
        }
        else {

            Intent myIntent = new Intent(MainActivity.this, NavigationActivity.class);
            myIntent.putExtra("user", texto.getText().toString()); //Optional parameters
            MainActivity.this.startActivity(myIntent);

            final ProgressDialog ringProgressDialog = ProgressDialog.show(MainActivity.this, "Please wait ...","Cargando Perfil de: " + texto.getText().toString(), true);
            ringProgressDialog.setCancelable(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Here you should write your time consuming task...
                        // Let the progress ring for 10 seconds...
                        Thread.sleep(1200);
                    } catch (Exception e) {

                    }
                    ringProgressDialog.dismiss();
                }
            }).start();
        }
    }


}
