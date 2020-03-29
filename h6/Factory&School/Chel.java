package com.company;

import com.company.Spare.Key;

public class Chel {
    public Key key;
    public License license;
    public Chel(String name, char cat){
        license = new License();
        license.name = name;
        license.category = cat;
    }
}
