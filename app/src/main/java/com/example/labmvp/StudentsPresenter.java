package com.example.labmvp;


import android.content.ContentValues;

import java.util.List;

public class StudentsPresenter {
    private StudentsActivity studentsActivity;
    private final StudentModel studentModel;

    public StudentsPresenter(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public void attachView(StudentsActivity activity) {
        this.studentsActivity = activity;
    }

    public void detachView() {
        studentsActivity = null;
    }

    public void loadStudents() {
        studentModel.loadStudents(new StudentModel.LoadStudentsCallback() {
            @Override
            public void onLoad(List<Student> students) {
                studentsActivity.showStudents(students);
            }
        });
    }

    public void viewIsReady() {
        loadStudents();
    }

    public void add() {
        Student student = studentsActivity.getStudentData();
        if(student.getFirst().isEmpty() || student.getLast().isEmpty()) {
            studentsActivity.showToast("Не заполнены поля");
            return;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("FIRSTNAME", student.getFirst());
        contentValues.put("LASTNAME", student.getLast());
        studentsActivity.showProgress();

        studentModel.addStudent(contentValues, new StudentModel.CompleteCallback() {
            @Override
            public void onComplete() {
                studentsActivity.hideProgress();
                loadStudents();
            }
        });


    }
}
