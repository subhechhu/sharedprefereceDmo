package com.subhechhu.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText_name = findViewById(R.id.editTextTextPersonName);
        findViewById(R.id.button_save).setOnClickListener(view -> {
            if (editText_name.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Empty name not allowed", Toast.LENGTH_SHORT).show();
            } else {

                //  MODE_PRIVATE: File creation mode: the default mode, where the created file can only be accessed by the calling application
                // 	MODE_APPEND: If the file already exists then write data to the end of the existing file instead of erasing it.

                SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE); // Get the sharedpreference object. Name gives the name of your preference
                SharedPreferences.Editor editor = sharedpreferences.edit(); // Get editor object from sharedpreference. You can add your SP with editor object.
                editor.putString("name", editText_name.getText().toString()); // Add your elements to the sP as a map with key, value pair
                editor.putBoolean("firsttimeuser", false);
                editor.apply(); // Save

                Toast.makeText(MainActivity.this, "Name saved", Toast.LENGTH_SHORT).show();
                editText_name.setText("");

            }
        });

        findViewById(R.id.button_view).setOnClickListener(view -> {
            SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE); // get the sharepreference object and use the same preference name and mode given when you saved it
            String name = sharedpreferences.getString("name", "defaultName"); // get the value via key that you used to store the value in

            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
        });


        findViewById(R.id.button_viewxml).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
    }
}