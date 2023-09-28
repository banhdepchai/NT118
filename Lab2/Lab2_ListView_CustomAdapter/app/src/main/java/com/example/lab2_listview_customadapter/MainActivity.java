package com.example.lab2_listview_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btn_add);
        EditText edtId = (EditText) findViewById(R.id.edt_id);
        EditText edtFullName = (EditText) findViewById(R.id.edt_fullname);
        CheckBox cbManager = (CheckBox) findViewById(R.id.cb_manager);

        ListView lvEmployee = (ListView) findViewById(R.id.lv_employee);

        EmployeeAdapter adapter = new EmployeeAdapter(this, R.layout.item_employee, arrEmployee);
        lvEmployee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String id = edtId.getText()+"";
                String fullName = edtFullName.getText()+"";
                boolean manager = false;//Nam =false
                if(cbManager.isChecked())
                {
                    manager = true;
                }

                Employee emp=new Employee();
                emp.setId(id);
                emp.setFullName(fullName);
                emp.setManager(manager);
                arrEmployee.add(emp);
                adapter.notifyDataSetChanged();
                edtId.setText("");
                edtFullName.setText("");
                cbManager.setChecked(false);
                edtId.requestFocus();
            }
        });



    }
}