package com.sofkaU.TravelAgencyDDD.circuit.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.Properties;

public class Hotel implements ValueObject<Properties> {

    private final String name;
    private final String address;

    public Hotel(String name, String address) {
        this.name = Objects.requireNonNull(name);
        this.address = Objects.requireNonNull(address);

        if(this.name.isBlank()){
            throw new IllegalArgumentException("The hotel name cannot be empty");
        }

        if(this.address.isBlank()){
            throw new IllegalArgumentException("The hotel address cannot be empty");
        }
    }


    @Override
    public Properties value() {
        return new Properties() {

            public String name() {
                return name;
            }

            public String address() {
                return address;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) && Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
