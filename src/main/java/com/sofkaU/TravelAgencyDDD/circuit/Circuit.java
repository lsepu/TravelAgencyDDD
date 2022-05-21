package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.events.*;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Circuit extends AggregateEvent<CircuitId> {

    protected TouristGuide touristGuide;
    protected Set<PlanId> planIds;
    protected Set<Client> clients;
    protected Destination destination;
    protected CircuitDates circuitDates;
    protected Price price;

    public Circuit(CircuitId entityId, Destination destination, CircuitDates circuitDates, Price price, TouristGuide touristGuide) {
        super(entityId);
        appendChange(new CircuitAdded(destination, touristGuide, circuitDates, price));
        subscribe(new CircuitChange(this));
    }

    private Circuit(CircuitId entityId){
        super(entityId);
        subscribe(new CircuitChange(this));
    }

    public static Circuit from (CircuitId sectionId, List<DomainEvent> events){
        var circuit = new Circuit(sectionId);
        events.forEach(circuit::applyEvent);
        return circuit;
    }

    //behaviors

    public void addClient(ClientId clientId, Name name, PhoneNumber phoneNumber, PassportNumber passportNumber,
                          IdentificationCard identificationCard, TravelPoints travelPoints){
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(passportNumber);
        Objects.requireNonNull(identificationCard);
        Objects.requireNonNull(travelPoints);

        appendChange(new ClientAdded(clientId, name, phoneNumber, passportNumber, identificationCard, travelPoints)).apply();
    }

    public void addClientTravelPoints(ClientId clientId, TravelPoints travelPoints){
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(travelPoints);

        appendChange(new ClientTravelPointsAdded(clientId, travelPoints));
    }

    public void addPlan(PlanId planId){
        Objects.requireNonNull(planId);
        this.planIds.add(planId);
    }

    public void changeTouristGuideYearsOfExperience(TouristGuideId touristGuideId, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(touristGuideId);
        Objects.requireNonNull(yearsOfExperience);

        appendChange(new TouristGuideYearsOfExperienceChanged(touristGuideId, yearsOfExperience));
    }

    public void changeDestinationHotel(DestinationId destinationId, Hotel hotel){
        Objects.requireNonNull(destinationId);
        Objects.requireNonNull(hotel);

        appendChange(new DestinationHotelChanged(destinationId, hotel));
    }

    public void AddTouristGuideDestinationExperience(TouristGuideId touristGuideId, DestinationExperience destinationExperience){
        Objects.requireNonNull(touristGuideId);
        Objects.requireNonNull(destinationExperience);

        appendChange(new TouristGuideDestinationExperienceAdded(touristGuideId, destinationExperience));
    }


}
