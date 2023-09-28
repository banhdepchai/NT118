package com.example.listviewwitharraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtPerson = findViewById(R.id.edt_person);
        Button btnAdd = findViewById(R.id.btn_add);
        TextView tvSelected = findViewById(R.id.tv_selected);
        ListView lvPerson = findViewById(R.id.lv_person);
        personList = new ArrayList<String>();
        personList.add("Tèo");
        personList.add("Tý");
        personList.add("Bin");
        personList.add("Bo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personList);
        lvPerson.setAdapter(adapter);

        lvPerson.setOnItemClickListener((parent, view, position, id) -> {
            String person = personList.get(position);
            tvSelected.setText("Position: " + position + " Value: " + person);
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String person = edtPerson.getText().toString();
                personList.add(person);
                adapter.notifyDataSetChanged();
            }
        });


    }
}