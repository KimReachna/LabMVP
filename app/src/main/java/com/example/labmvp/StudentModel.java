package com.example.labmvp;


import android.content.ContentValues;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StudentModel {
    private List<Student> students = new ArrayList<>();

    public StudentModel() {
        initStudents();
    }

    private void initStudents() {
        Student student1 = new Student("Ким", "Реачна");
        Student student2 = new Student("Краснова", "Диана");
        this.students.add(student1);
        this.students.add(student2);
    }

    public void loadStudents(LoadStudentsCallback studentsCallback) {
        LoadStudentsTask loadStudentsTask = new LoadStudentsTask(studentsCallback);
        loadStudentsTask.execute();
    }

    public void addStudent(ContentValues contentValues, CompleteCallback callback) {
        AddStudentTask addStudentTask = new AddStudentTask(callback);
        addStudentTask.execute(contentValues);
    }

    class LoadStudentsTask extends AsyncTask<Void, Void, List<Student>> {
        private final LoadStudentsCallback callback;

        public LoadStudentsTask(LoadStudentsCallback callback) {
            this.callback = callback;
        }

        @Override
        protected List<Student> doInBackground(Void... voids) {
            return students;
        }

        @Override
        protected void onPostExecute(List<Student> students) {
            callback.onLoad(students);
        }
    }

    interface LoadStudentsCallback {
        void onLoad(List<Student> students);
    }

    class AddStudentTask extends AsyncTask<ContentValues, Void, Void> {
        private final CompleteCallback callback;

        public AddStudentTask(CompleteCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Void doInBackground(ContentValues... contentValues) {
            Student student = new Student();
            student.setFirst(contentValues[0].get("FIRSTNAME").toString());
            student.setLast(contentValues[0].get("LASTNAME").toString());


            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            students.add((Student)student);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            callback.onComplete();
        }
    }

    interface CompleteCallback {
        void onComplete();
    }
}

