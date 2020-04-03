package com.company.Cars;

import com.company.Spare.Key;
import com.company.Spare.TypeWheel;
import com.company.api.ICar;

public class FactoryCar {

    int Vmotor;
    Key keyZamok;
    int Vbak;
    int RWheel;
    TypeWheel type;

    public FactoryCar setVmotor(int vmotor) {
        Vmotor = vmotor;
        return this;
    }

    public FactoryCar setKeyZamok(Key keyZamok) {
        this.keyZamok = keyZamok;
        return this;
    }

    public FactoryCar setVbak(int vbak) {
        Vbak = vbak;
        return this;
    }

    public FactoryCar setRWheel(int RWheel) {
        this.RWheel = RWheel;
        return this;
    }

    public FactoryCar setType(TypeWheel type) {
        this.type = type;
        return this;
    }

    public ICar getNewCar(Cars cc) throws Exception {
        switch (cc){
            case CAR:
                return new Car(Vmotor,keyZamok,Vbak,RWheel,type);

            case ELECTROCAR:
                return new ElectroCar(Vmotor,keyZamok,Vbak,RWheel,type);

            case BIKE:
                return new Bike(Vmotor,keyZamok,Vbak,RWheel,type);

            case BICYCLE:
                return new Bicycle(RWheel,type);


            default:
                throw new Exception("Error type!");
        }
    }
}
