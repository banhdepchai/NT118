package com.example.lab03_1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    Activity activity;
    List<Contact> contactArrayList;


    public ContactAdapter(Activity activity, List<Contact> contactArrayList) {
        this.activity = activity;
        this.contactArrayList = contactArrayList;
    }


    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        view = inflater.inflate(R.layout.item_contact, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView tvName = (TextView) view.findViewById(R.id.tv_contact);
        tvName.setText(contactArrayList.get(i).toString());

        // Trả về view kết quả.
        return view;
    }
}
