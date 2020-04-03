package com.company.Spare;

public class Spare {


    private Motor motor;
    private Lock zamok;

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Lock getZamok() {
        return zamok;
    }

    public void setZamok(Lock zamok) {
        this.zamok = zamok;
    }

    public Bak getBak() {
        return bak;
    }

    public void setBak(Bak bak) {
        this.bak = bak;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    private Bak bak;
    private Wheel wheel;
    public Spare(int Vmotor, Key keyZamok, int Vbak, int RWheel, TypeWheel type){
        motor = new Motor(Vmotor);
        zamok = new Lock(keyZamok);
        bak = new Bak(Vbak);
        wheel = new Wheel(RWheel,type);

    }


    public Spare(int RWheel, TypeWheel type){
        motor = null;
        zamok = null;
        bak = null;
        wheel = new Wheel(RWheel,type);

    }



}
