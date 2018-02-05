package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Battery_ON_OFF extends Activity {

    Button save,back;
    EditText OFF,ON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery__on__off);

        save=(Button)findViewById(R.id.saveonoff_id);
        OFF=(EditText)findViewById(R.id.OFF);

        ON=(EditText)findViewById(R.id.ON);
        back=(Button)findViewById(R.id.back_id);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Battery_on_off_save.class);
                intent.putExtra ( "OFF", OFF.getText().toString() );
                intent.putExtra ( "ON", ON.getText().toString() );

                startActivity(intent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Enable_disable.class);
                startActivity(intent);
            }
        });
    }
}
