package com.company.school;

import java.util.ArrayList;
import java.util.List;

public class Pupil {
    private String FIO;
    private String classs;
    private List<Subject> subjects= new ArrayList<>();
    private double mark;

    public double getMark() {
        return mark;
    }

    public Pupil(String FIO, String classs, List<Subject> subjects) {
        this.FIO = FIO;
        this.classs = classs;
        this.subjects.addAll(subjects);
        mark = subjects.stream()
                .map(Subject::getMark)
                .mapToDouble(Double::doubleValue).average().getAsDouble();
    }
}
