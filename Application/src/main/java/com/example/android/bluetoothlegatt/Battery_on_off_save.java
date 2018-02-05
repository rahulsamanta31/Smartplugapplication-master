package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class Battery_on_off_save extends Activity {
    TextView textview;
    Button button;
    IntentFilter intentfilter;
    int deviceStatus;
    String currentBatteryStatus="Battery Info";
    int batteryLevel;

     TextView off,on;
     ImageView dynamicchange;

     Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_on_off_save);

        textview = (TextView)findViewById(R.id.textViewBatteryStatus);


        on=(TextView)findViewById(R.id.editText_ON);
        off=(TextView)findViewById(R.id.editTextOFF);

        Bundle bb;
        bb=getIntent().getExtras();
        off.setText(bb.getString("OFF"));
        on.setText(bb.getString("ON"));

        dynamicchange=(ImageView)findViewById(R.id.imageView);
        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Battery_on_off_save.this.registerReceiver(broadcastreceiver,intentfilter);






    }
    private BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryLevel=(int)(((float)level / (float)scale) * 100.0f);

            if(deviceStatus == BatteryManager.BATTERY_STATUS_CHARGING){

                textview.setText(currentBatteryStatus+" = Charging at "+batteryLevel+" %");
                dynamicchange.setImageResource(R.drawable.batterycahrging);
            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_DISCHARGING){

                textview.setText(currentBatteryStatus+" = Discharging at "+batteryLevel+" %");
                dynamicchange.setImageResource(R.drawable.notcharging);
            }

            if (deviceStatus == BatteryManager.BATTERY_STATUS_FULL){

                textview.setText(currentBatteryStatus+"= Battery Full at "+batteryLevel+" %");

            }

            if(deviceStatus == BatteryManager.BATTERY_STATUS_UNKNOWN){

                textview.setText(currentBatteryStatus+" = Unknown at "+batteryLevel+" %");
            }


            if (deviceStatus == BatteryManager.BATTERY_STATUS_NOT_CHARGING){

                textview.setText(currentBatteryStatus+" = Not Charging at "+batteryLevel+" %");

            }

        }
    };
}
