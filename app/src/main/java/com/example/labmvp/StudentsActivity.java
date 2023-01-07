package com.example.labmvp;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsActivity extends AppCompatActivity {
    private StudentsPresenter studentsPresenter;
    private StudentsAdapter studentsAdapter;
    private ProgressDialog progressDialog;

    EditText editTextStudentFirst;
    EditText editTextStudentLast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        editTextStudentFirst = findViewById(R.id.add_student_first);
        editTextStudentLast = findViewById(R.id.add_student_last);

        findViewById(R.id.button_add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentsPresenter.add();
            }
        });

        studentsAdapter = new StudentsAdapter();
        RecyclerView studentsList = findViewById(R.id.student_list);
        studentsList.setLayoutManager(layoutManager);
        studentsList.setAdapter(studentsAdapter);

        StudentModel studentModel = new StudentModel();
        studentsPresenter = new StudentsPresenter(studentModel);
        studentsPresenter.attachView(this);
        studentsPresenter.viewIsReady();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        studentsPresenter.detachView();
    }

    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", "Добавление студенты...");
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showStudents(List<Student> students) {
        studentsAdapter.setData(students);
    }

    public Student getStudentData() {
        Student student = new Student();
        student.setFirst(editTextStudentFirst.getText().toString());
        student.setLast(editTextStudentLast.getText().toString());
        return student;
    }
}
