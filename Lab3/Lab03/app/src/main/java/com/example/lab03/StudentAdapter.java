package com.example.lab03;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    private Activity context=null;
    private int layoutID;
    private List<Student> mListStudent;
    View rootView;
    EditText editId, editName, editMark;
    static int row_index = -1;

    public List<Student> getmListStudent() {
        return mListStudent;
    }

    public void setmListStudent(List<Student> mListStudent) {
        this.mListStudent = mListStudent;
    }

    public StudentAdapter(Activity context, int layoutID, List<Student> mListStudent) {
        this.context = context;
        this.layoutID = layoutID;
        this.mListStudent = mListStudent;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, null,
                false);
        rootView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        editId = rootView.findViewById(R.id.edtCode);
        editName = rootView.findViewById(R.id.edtName);
        editMark = rootView.findViewById(R.id.edtMark);
        return new StudentHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        Student student = mListStudent.get(position);
        if (student == null ) {
            return;
        }
        if (student.getName() != null)
        {
            holder.txtName.setText(student.getName());
        }
        if (student.getId() != null)
        {
            holder.txtId.setText(student.getId());
        }
        if (student.getMark() >= 0 && student.getMark() <= 10)
        {
            holder.txtMark.setText(Integer.toString(student.getMark()));
        }
        holder.student_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                row_index = pos;
                if(pos != RecyclerView.NO_POSITION){
                    Student clickedStudent = mListStudent.get(pos);
                    //Toast.makeText(view.getContext(), "You clicked " + clickedStudent.getName(), Toast.LENGTH_SHORT).show();
                    editId.setText(clickedStudent.getId());
                    editName.setText(clickedStudent.getName());
                    editMark.setText(Integer.toString(clickedStudent.getMark()));
                    System.out.println(Integer.toString(row_index+1));
                    notifyDataSetChanged();
                }
            }
        });

        holder.student_item_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Position is " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        if(row_index==position){
            holder.student_item_layout.setBackgroundColor(R.color.teal_200);
        }
        else
        {
            holder.student_item_layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }
    @NonNull
    @Override
    public int getItemCount() {
        return mListStudent.size();
    }


    class StudentHolder extends RecyclerView.ViewHolder {
        TextView txtId, txtName, txtMark;
        LinearLayout student_item_layout;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txtCode);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtMark = (TextView) itemView.findViewById(R.id.txtMark);
            student_item_layout = (LinearLayout) itemView.findViewById(R.id.student_item_layout);
        }

    }
}
