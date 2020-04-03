package com.company.Cars;

import com.company.Spare.Key;
import com.company.Spare.Spare;
import com.company.Spare.TypeWheel;
import com.company.api.ICar;

public class ElectroCar implements ICar {

    Spare zap;

    public ElectroCar(int Vmotor, Key keyZamok, int Vbak, int RWheel, TypeWheel type) {
        zap = new Spare(Vmotor, keyZamok, Vbak, RWheel, type);
    }

    @Override
    public boolean open(Key key) throws Exception {
        if(zap.getZamok().open)
            return false;

        if(zap.getZamok().open(key))
            return true;
        throw new Exception("The key doesnt fit");
    }

    @Override
    public boolean close(Key key) throws Exception {
        if(!zap.getZamok().open)
            return false;

        if(zap.getZamok().open(key))
            return true;

        throw new Exception("The key doesnt fit");
    }
    public boolean drive = false;
    public boolean stop = false;
    @Override
    public void drive() {

        zap.getMotor().work = true;
        drive = true;
        stop = false;
    }

    @Override
    public void stop() {
        zap.getMotor().work = false;
        stop = true;
        drive = false;
    }

    @Override
    public void zajiganie() throws Exception {
        if(zap.getZamok().open) {
            if(zap.getBak().getVn()>0)
                zap.getMotor().work = true;
            else
                throw new Exception("Battery is free!");
            return;
        }

        throw new Exception("Car is closed!");
    }

    @Override
    public int refuelinh( int v) throws Exception {
        if(zap.getMotor().work)
            throw new Exception("Motor is working!");

        return zap.getBak().refuelinh(v);

    }

    public int gekBak(){
        return zap.getBak().getVn();
    }
}
