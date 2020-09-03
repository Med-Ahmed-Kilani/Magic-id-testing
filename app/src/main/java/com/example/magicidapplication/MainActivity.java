package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText id;
     Button btnSubmit;
     TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (id.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String idNumber = id.getText().toString().trim();

                    String birth_date = idNumber.substring(0,2) + "/" + idNumber.substring(2,4) + "/" + idNumber.substring(4,6);

                    int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                    String sGender;

                    if (gender<5) sGender = "Female";
                    else sGender = "Male";

                    int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                    String sNationality;

                    if (nationality == 0) sNationality = "SA Citizen";
                    else sNationality = "Permanent Resident";

                    tvResults.setText("Date of birth: " + birth_date + "\nGender: " + sGender + "\nNationalitu: " + sNationality);

                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}