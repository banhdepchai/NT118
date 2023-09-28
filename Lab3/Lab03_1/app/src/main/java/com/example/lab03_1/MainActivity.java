package com.example.lab03_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        db.addContact(new Contact("Nguyen Van A", "0123456789"));
        db.addContact(new Contact("Nguyen Van B", "0123456789"));
        db.addContact(new Contact("Nguyen Van C", "0123456789"));
        db.addContact(new Contact("Nguyen Van D", "0123456789"));
        db.addContact(new Contact("Nguyen Van E", "0123456789"));
        db.addContact(new Contact("Nguyen Van G", "0123456789"));
        db.addContact(new Contact("Nguyen Van H", "0123456789"));
        db.addContact(new Contact("Nguyen Van K", "0123456789"));
        db.addContact(new Contact("Nguyen Van L", "0123456789"));


        // Reading all contacts
        List<Contact> contacts = db.getAllContacts();
        Log.e("Reading: ", "Reading all contacts..");
        for (Contact cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.e("Name: ", log);
        }

        ListView lv_main = findViewById(R.id.listview_contacts);
        ContactAdapter adapter = new ContactAdapter(this, contacts);
        lv_main.setAdapter(adapter);
        lv_main.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                db.deleteContact(contacts.get(i).getId());
                contacts.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}