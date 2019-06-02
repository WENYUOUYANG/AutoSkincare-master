package com.example.auto_skincare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Float.parseFloat;

public class profile_update extends AppCompatActivity {

    DatabaseHelper myDb = new DatabaseHelper(this);
    Spinner SkinType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile);

        SkinType = (Spinner) findViewById(R.id.skin_type_spinner);
        final String[] Etypes = {"Please select:","Dry Skin","Oil Skin","Combination Skin", "Normal Skin", "Sensitive Skin"};
        ArrayAdapter<String> TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Etypes);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SkinType.setAdapter(TypeAdapter);
    }

    public void ProfileonClick(View view){
        Button profile_save_Butt = (Button) findViewById(R.id.saveButton);
        EditText id = (EditText) findViewById(R.id.editName);
        EditText age = (EditText) findViewById(R.id.editAge);


        String ID = id.getText().toString();
        String Age = age.getText().toString();

        while (true) {

            if (ID.matches("")) {
                Toast.makeText(this, "plz enter your name ", Toast.LENGTH_SHORT).show();
                break;
            } else if (Age.matches("")) {
                Toast.makeText(this, "plz enter your age ", Toast.LENGTH_SHORT).show();
                break;
            } else {
                int finalAge = Integer.parseInt(Age);

                Intent goHome = new Intent(this, MainActivity.class);
                startActivity(goHome);

                //myDb.insertData_profile(ID, finalAge, skin_type, product_preference);
                break;
            }
        }
    }

}
