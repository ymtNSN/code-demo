package com.example.demo.design.builder;

/**
 * Created by @author ymtNSN on 2020/10/28
 */
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);

        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder carManualBuilder = new CarManualBuilder();

        director.constructSportsCar(carManualBuilder);
        Manual carManual = carManualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

    }
}
