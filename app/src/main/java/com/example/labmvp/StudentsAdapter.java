package com.example.labmvp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentsAdapter extends  RecyclerView.Adapter<StudentsAdapter.StudentHolder> {
    List<Student> data = new ArrayList();

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item_view, parent,
                false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Student> students) {
        data.clear();
        data.addAll(students);
        notifyDataSetChanged();
    }

    static class StudentHolder extends RecyclerView.ViewHolder {
        TextView first;
        TextView last;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.student_item_view_first);
            last = itemView.findViewById(R.id.student_item_view_last);
        }

        void bind(Student student) {
            first.setText(student.getFirst());
            last.setText(student.getLast());
        }
    }
}
