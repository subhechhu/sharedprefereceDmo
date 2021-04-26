

package com.subhechhu.sharepreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

// riong 
//        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE); // Sharedpreference value can be read from anywhere in the app when you give the same name of the preference
//        String name = sharedpreferences.getString("name", "defaultName"); // use same key to get the value which you used during saving
//        Toast.makeText(MainActivity2.this, name, Toast.LENGTH_SHORT).show();
//
        FragmentManager fm= getSupportFragmentManager(); // like shared preference, get a fragmentmanager to create the fragment
        FragmentTransaction ft= fm.beginTransaction(); // start a series of edit operations on the Fragments associated with this FragmentManager.
        PreferenceFragment pf= new PreferenceFragment(); // Instance of the fragment that we have created below
        ft.replace(android.R.id.content, pf); // where do we need to put the fragment?
        ft.commit(); // start
    }

    public static class PreferenceFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            addPreferencesFromResource(R.xml.preferences); // Do nothing, just add the view/file thats present in xml directory in Res with filename preference.xml
        }
    }
}