package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText editText;
    TextView tv;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.movedatabutton);
        b2=findViewById(R.id.savedatabutton);
        editText =findViewById(R.id.editText);
        tv=findViewById(R.id.tv1);
        aSwitch=findViewById(R.id.switch1);
        loadData();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(editText.getText().toString());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
                Toast.makeText(MainActivity.this, "Succesful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("text", editText.getText().toString());
        editor.putBoolean("switch",aSwitch.isChecked());
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences=getSharedPreferences("name",MODE_PRIVATE);
        String text=sharedPreferences.getString("text","");
        Boolean onOff =sharedPreferences.getBoolean("switch",false);

        tv.setText(text);
        aSwitch.setChecked(onOff);
    }
}