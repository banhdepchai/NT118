package com.example.lab2_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {


    private List<Employee> employees;

    EmployeeAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        TextView textViewFullname = holder.itemView.findViewById(R.id.item_employee_tv_fullname);
        textViewFullname.setText(employee.getFullName());
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.white);
        } else {
            holder.itemView.setBackgroundResource(R.color.light_blue);
        }
        ImageView ivManager = holder.itemView.findViewById(R.id.item_employee_iv_manager);
        TextView tvPosition = holder.itemView.findViewById(R.id.item_employee_tv_position);

        if (employee.isManager())
        {
            ivManager.setVisibility(View.VISIBLE);
            tvPosition.setVisibility(View.GONE);
        }
        else
        {
            ivManager.setVisibility(View.GONE);
            tvPosition.setVisibility(View.VISIBLE);
            tvPosition.setText(holder.itemView.getContext().getString(R.string.staff));
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    static class  EmployeeViewHolder extends RecyclerView.ViewHolder {

        private View itemView;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }
}
