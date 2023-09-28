package com.example.lab2_listview_customadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Activity context = null;
    private List<Employee> listEmployee = null;
    private int layoutID;

    public EmployeeAdapter(Activity context, int layoutID, List<Employee> listEmployee) {
        super(context, layoutID, listEmployee);
        this.context = context;
        this.listEmployee = listEmployee;
        this.layoutID = layoutID;
    }


    @Override
    public int getCount() {
        return listEmployee.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView=inflater.inflate(layoutID, null);

        if(listEmployee.size()>0 && position>=0)
        {
            final TextView txtFullName = (TextView) convertView.findViewById(R.id.item_employee_tv_fullname);
            final Employee emp = listEmployee.get(position);
            final ImageView ivManager = (ImageView) convertView.findViewById(R.id.item_employee_iv_manager);
            final TextView tvPosition = (TextView) convertView.findViewById(R.id.item_employee_tv_position);
            LinearLayout llParent = (LinearLayout) convertView.findViewById(R.id.item_employee_ll_parent);
            txtFullName.setText(emp.getFullName());
            if(emp.isManager())
            {
                ivManager.setVisibility(View.VISIBLE);
                tvPosition.setVisibility(View.GONE);
            }
            else
            {
                ivManager.setVisibility(View.GONE);
                tvPosition.setVisibility(View.VISIBLE);
                tvPosition.setText(context.getString(R.string.staff));
            }

            if (position % 2 == 0) {
                llParent.setBackgroundResource(R.color.light_blue);
            }
        }

        return  convertView;
    }
}

