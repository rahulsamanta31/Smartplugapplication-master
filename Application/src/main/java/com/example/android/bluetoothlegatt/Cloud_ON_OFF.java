package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.util.Patterns;
import android.view.View;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Cloud_ON_OFF extends Activity implements View.OnClickListener  {


    Button Login,back;
    EditText mail,password;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud__on__off);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        mail =(EditText)findViewById(R.id.editText_username);
        password=(EditText)findViewById(R.id.editText_password);
        Login =(Button)findViewById(R.id.savecoud);
        back=(Button)findViewById(R.id.backcloud);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),Enable_disable.class);
                startActivity(intent);
            }
        });



      //  awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.editText_username, Patterns.EMAIL_ADDRESS, R.string.emailerror);

        Login.setOnClickListener(this);


    }

    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Intent intent=new Intent(getApplication(),Cloud_operation.class);
            startActivity(intent);
            //process the data further
        }
    }

    @Override
    public void onClick(View view) {
        if (view == Login) {
            submitForm();
        }
    }

}
