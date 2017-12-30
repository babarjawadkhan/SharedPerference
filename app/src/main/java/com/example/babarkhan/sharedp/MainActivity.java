package com.example.babarkhan.sharedp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calulate;
    EditText todayexp;
    EditText prevexp;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calulate = (Button) findViewById(R.id.calculate);
        todayexp = (EditText) findViewById(R.id.todayexp);
        prevexp = (EditText) findViewById(R.id.prevexp);
        sharedPreferences=getSharedPreferences("expensive", Context.MODE_PRIVATE);
        prevexp.setText("Your Previus Expensive is : "+ String.valueOf(sharedPreferences.getInt("exp",0)));


        calulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int expensive;
                expensive = Integer.valueOf(todayexp.getText().toString());

                Toast.makeText(MainActivity.this, "your previus  : " + String.valueOf(expensive), Toast.LENGTH_SHORT).show();


                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("exp",expensive);
                edit.apply();

            }
        });


    }
}
