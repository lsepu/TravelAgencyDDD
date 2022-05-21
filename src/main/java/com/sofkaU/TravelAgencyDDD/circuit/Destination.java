package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;

public class Destination extends Entity<DestinationId> {

    private Hotel hotel;
    private Weather weather;
    private City city;
    private Country country;

    public Destination(DestinationId entityId, Hotel hotel, Weather weather, City city, Country country) {
        super(entityId);
        this.hotel = hotel;
        this.weather = weather;
        this.city = city;
        this.country = country;
    }

    public void changeHotel(Hotel hotel){
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Weather getWeather() {
        return weather;
    }

    public City getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }
}
