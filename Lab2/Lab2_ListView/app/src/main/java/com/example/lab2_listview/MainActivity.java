package com.example.lab2_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSelection = findViewById(R.id.tv_selection);
        ListView lvPerson = findViewById(R.id.lv_person);
        final String[] arr = {"Teo", "Ty", "Bin", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tvSelection.setText("Position: " + position + " Value: " + arr[position]);
                    }
                }
        );


    }
}