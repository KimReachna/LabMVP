package com.example.labmvp;

public class Student {
    private String first;
    private String last;

    public Student(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Student() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}

