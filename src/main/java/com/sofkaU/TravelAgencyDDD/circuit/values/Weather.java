package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Weather implements ValueObject<Weather.WeatherTypes> {

    private final WeatherTypes value;

    public Weather(WeatherTypes value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public WeatherTypes value(){
        return value;
    }

    public enum WeatherTypes {
        HOT, COLD, MILD
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return value == weather.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
