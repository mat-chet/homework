package com.company.school;

public class Subject {
    private String Subject;
    private Double mark;

    public Subject(String subject, Double mark) {
        Subject = subject;
        this.mark = mark;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return Subject;
    }

    public Double getMark() {
        return mark;
    }
}
