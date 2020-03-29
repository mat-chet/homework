package com.company.school;

import java.util.ArrayList;
import java.util.List;

public class SchMain1 {
    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();

        subjects.add(new Subject("Math",5.0));
        subjects.add(new Subject("History",4.0));
        subjects.add(new Subject("Fiz-ra",3.7));
        subjects.add(new Subject("Trud",5.0));
        subjects.add(new Subject("OBJ",7.0));

        Pupil Max = new Pupil("Max","5г",subjects);
        System.out.println(Max.getMark());

    }
}
