package com.example.demo.design.builder;

/**
 * Created by @author ymtNSN on 2020/10/27
 */
public interface Builder {

    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
