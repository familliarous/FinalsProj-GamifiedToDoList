package com.example.finalsproj_gamifiedtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button logBtn;
    Button regBtn;
    EditText unVw;
    EditText passVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logBtn = findViewById(R.id.btn_login);
        regBtn = findViewById(R.id.btn_register);
        unVw = findViewById(R.id.txtvw_username);
        passVw = findViewById(R.id.txtvw_password);

        myDB = new DatabaseHelper(getApplicationContext());
        addData();
    }

    public void addData(){

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(unVw.getText().toString(),
                                passVw.getText().toString());
                if (isInserted)
                    Toast.makeText(getApplicationContext(),"Data Inserted!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Data failed to insert.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
