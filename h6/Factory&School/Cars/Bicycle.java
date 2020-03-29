package com.company.Cars;

import com.company.Spare.Key;
import com.company.Spare.Spare;
import com.company.Spare.TypeWheel;
import com.company.api.ICar;

public class Bicycle implements ICar {

    Spare zap;

    public Bicycle(int RWheel, TypeWheel type) {
        zap = new Spare(RWheel, type);
    }

    @Override
    public boolean open(Key key) throws Exception {

        throw new Exception("Its Bicycle!");
    }

    @Override
    public boolean close(Key key) throws Exception {
        throw new Exception("Its Bicycle!");
    }


    public boolean drive = false;
    public boolean stop = false;
    @Override
    public void drive() {
        drive = true;
        stop = false;
    }

    @Override
    public void stop() {

        stop = true;
        drive = false;
    }

    @Override
    public void zajiganie() throws Exception {
        throw new Exception("Its Bicycle!");
    }

    @Override
    public int refuelinh( int v) throws Exception {
        throw new Exception("Its Bicycle!");

    }

    public int gekBak() throws Exception {
        throw new Exception("Its Bicycle!");
    }
}
