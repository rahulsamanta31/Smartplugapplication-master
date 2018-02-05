package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Enable_disable extends Activity {

    Switch manual_on_off, battery_on_off,cloud_on_off;

    Button setting;
  /*  public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";


/*    private String mDeviceName;
    private String mDeviceAddress;*/

    private String mDeviceName;
    private String mDeviceAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enable_disable);
        battery_on_off = (Switch) findViewById(R.id.batery_id_ON_OFF);
        manual_on_off = (Switch) findViewById(R.id.manual_id_ON_OFF);
        setting=(Button)findViewById(R.id.setting);
        cloud_on_off=(Switch)findViewById(R.id.cloud_id_ON_OFF);



        final Intent intent = getIntent();
        mDeviceName = intent.getStringExtra(Utils.EXTRAS_DEVICE_NAME);
        mDeviceAddress = intent.getStringExtra(Utils.EXTRAS_DEVICE_ADDRESS);

        manual_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(getApplication(), Manual_ON_OFF.class);
                    intent.putExtra(Utils.EXTRAS_DEVICE_NAME, mDeviceName);
                    intent.putExtra(Utils.EXTRAS_DEVICE_ADDRESS, mDeviceAddress);
                    startActivity(intent);
                }
            }
        });

        battery_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(getApplication(), Battery_ON_OFF.class);
                    startActivity(intent);
                }
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),Setting.class);
                startActivity(intent1);
            }
        });


        cloud_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent1=new Intent(getApplicationContext(),Cloud_ON_OFF.class);
                    startActivity(intent1);
                }
            }
        });


    }


    public void Dialog(View view) {

    }
}


//Swir




