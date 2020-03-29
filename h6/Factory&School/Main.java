package com.company;

import com.company.Cars.Car;
import com.company.Cars.Cars;
import com.company.Cars.FactoryCar;
import com.company.Spare.Key;
import com.company.Spare.TypeWheel;
import com.company.api.ICar;
import sun.security.smartcardio.SunPCSC;

public class Main {

    public static void main(String[] args) {
        Chel Chikatilo = new Chel("Chikatilo", 'B');
        Chel Ded = new Chel("Ded", 'C');
        Chel Ozzy = new Chel("Ozzy", 'A');
        Chikatilo.key = new Key();
        Ded.key = new Key();
        Ozzy.key = new Key();
        Car car1 = new Car(2, Chikatilo.key, 60, 30, TypeWheel.SUMMER);
        Car car2 = new Car(2, Ded.key, 60, 30, TypeWheel.WINTER);

        try {
            System.out.println(car1.open(Chikatilo.key));

            //System.out.println(car1.close(Chikatilo.key));
            System.out.println(car1.open(Ded.key));
            System.out.println(car2.open(Ozzy.key));
            System.out.println(car2.open(Ded.key));

        } catch (Exception e) {
            e.printStackTrace();
        }
        try{

            car1.refuelinh(10);
            car1.zajiganie();
            car1.refuelinh(10);
        } catch (Exception e) {
            e.printStackTrace();
            car1.stop();

            try {
                car1.refuelinh(10);
                System.out.println(car1.gekBak());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        FactoryCar factory = new FactoryCar()
                .setKeyZamok(Ozzy.key)
                .setRWheel(30)
                .setType(TypeWheel.SUMMER)
                .setVmotor(2)
                .setVbak(60);

        try {
            ICar byke = factory.getNewCar(Cars.BIKE);
            ICar bicycle = factory.getNewCar(Cars.BICYCLE);
            ICar electrocar = factory.getNewCar(Cars.ELECTROCAR);
            ICar car = factory.getNewCar(Cars.CAR);
            System.out.println(byke.getClass());
            System.out.println(bicycle.getClass());
            System.out.println(electrocar.getClass());
            System.out.println(car.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
