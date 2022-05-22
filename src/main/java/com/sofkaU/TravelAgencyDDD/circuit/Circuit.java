package com.sofkaU.TravelAgencyDDD.circuit;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.events.*;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import com.sofkaU.TravelAgencyDDD.plan.values.PlanId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Circuit extends AggregateEvent<CircuitId> {

    protected TouristGuide touristGuide;
    protected Set<PlanId> planIds;
    protected Set<Client> clients;
    protected Destination destination;
    protected CircuitDates circuitDates;
    protected Price price;

    public Circuit(CircuitId entityId, Destination destination, CircuitDates circuitDates, Price price) {
        super(entityId);
        appendChange(new CircuitCreated(destination, circuitDates, price));
        subscribe(new CircuitChange(this));
    }

    private Circuit(CircuitId entityId){
        super(entityId);
        subscribe(new CircuitChange(this));
    }

    public static Circuit from (CircuitId entityId, List<DomainEvent> events){
        var circuit = new Circuit(entityId);
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

        appendChange(new ClientTravelPointsAdded(clientId, travelPoints)).apply();
    }

    public void addPlan(PlanId planId){
        Objects.requireNonNull(planId);

        appendChange(new PlanAdded(planId)).apply();
    }

    public void changeTouristGuideYearsOfExperience(TouristGuideId touristGuideId, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(touristGuideId);
        Objects.requireNonNull(yearsOfExperience);

        appendChange(new TouristGuideYearsOfExperienceChanged(touristGuideId, yearsOfExperience)).apply();
    }

    public void changeDestinationHotel(DestinationId destinationId, Hotel hotel){
        Objects.requireNonNull(destinationId);
        Objects.requireNonNull(hotel);

        appendChange(new DestinationHotelChanged(destinationId, hotel)).apply();
    }

    public void addTouristGuideDestinationExperience(TouristGuideId touristGuideId, DestinationExperience destinationExperience){
        Objects.requireNonNull(touristGuideId);
        Objects.requireNonNull(destinationExperience);

        appendChange(new TouristGuideDestinationExperienceAdded(touristGuideId, destinationExperience)).apply();
    }

    public void addTouristGuide(TouristGuideId touristGuideId, Name name, PhoneNumber phoneNumber, Set<DestinationExperience> destinationsExperience,
                                YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(touristGuideId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(destinationsExperience);

        appendChange(new TouristGuideAdded(touristGuideId, name, phoneNumber, destinationsExperience, yearsOfExperience));
    }

    public void notifyMarketinArea(String message){
        Objects.requireNonNull(message);

        appendChange(new MarketingAreaNotified(message));
    }

    protected Optional<Client> getClientById(ClientId entityId){
        return clients
                .stream()
                .filter(client -> client.identity().equals(entityId))
                .findFirst();
    }


}
