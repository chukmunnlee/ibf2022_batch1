package main;

import java.util.Date;

import models.Car;
import models.TurboChargedCar;

public class Main {

    public static void main(String[] args) {

        Car myCar = new Car("SAA1232A"); 
        Car myOtherCar = new TurboChargedCar("T12345");

        myCar.setColour("red");
        myCar.setMake("Honda");
        myCar.setRegistration("S12345A");
        myCar.setRegistrationDate(new Date());

        myCar.horn();
        System.out.printf("color: %s, make: %s, registration: %s\n"
            , myCar.getColour(), myCar.getMake(), myCar.getRegistration());

        myCar.accelerate();
        myCar.accelerate();
        myCar.accelerate();

        System.out.printf("acceleration: %d\n", myCar.getAcceleration());

        if (myOtherCar instanceof TurboChargedCar) {
            // Cast into a TurboChargedCar type
            TurboChargedCar turbo = (TurboChargedCar)myOtherCar;
            turbo.setTurbo(true);
        }


    }
    
}
