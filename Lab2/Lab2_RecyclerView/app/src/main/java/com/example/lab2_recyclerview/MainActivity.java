package com.example.lab2_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EmployeeAdapter adapter;
    RecyclerView employeeRv;
    Button addBtn;
    EditText idEt;
    EditText fullnameEt;
    CheckBox isManagerCkb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<Employee> employees = new ArrayList<Employee>();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBtn = (Button) findViewById(R.id.btn_add_new_employee);
        employeeRv = (RecyclerView) findViewById(R.id.rv_employee);
        idEt = (EditText) findViewById(R.id.et_new_eployee_id);
        fullnameEt = (EditText) findViewById(R.id.et_new_eployee_name);
        isManagerCkb = (CheckBox) findViewById(R.id.ckb_new_eployee_isManager);

        adapter = new EmployeeAdapter(employees);

        employeeRv.setAdapter(adapter);

        addBtn.setOnClickListener((view) -> {
            Employee employee = new Employee(idEt.getText().toString(), fullnameEt.getText().toString(), isManagerCkb.isChecked());
            employees.add(employee);
            adapter.notifyItemInserted(employees.size() - 1);

            idEt.setText("");
            fullnameEt.setText("");
            isManagerCkb.setChecked(false);
            idEt.requestFocus();
        });

    }
}