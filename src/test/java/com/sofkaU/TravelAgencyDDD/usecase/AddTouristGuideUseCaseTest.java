package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.circuit.Destination;
import com.sofkaU.TravelAgencyDDD.circuit.commands.AddClient;
import com.sofkaU.TravelAgencyDDD.circuit.commands.AddTouristGuide;
import com.sofkaU.TravelAgencyDDD.circuit.events.CircuitCreated;
import com.sofkaU.TravelAgencyDDD.circuit.events.ClientAdded;
import com.sofkaU.TravelAgencyDDD.circuit.events.TouristGuideAdded;
import com.sofkaU.TravelAgencyDDD.circuit.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddTouristGuideUseCaseTest {

    private final String ROOT_ID = "XXXX";

    @InjectMocks
    private AddTouristGuideUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addTouristGuide(){

        //destinations where the guide has worked
        Set<DestinationExperience> experiences = new HashSet<>();
        experiences.add(new DestinationExperience("Hawaii"));
        experiences.add(new DestinationExperience("New York"));

        var command = new AddTouristGuide(CircuitId.of(ROOT_ID), TouristGuideId.of("YYYY"),
                new Name("Juan"),
                experiences,
                new YearsOfExperience(4)
                );

        var useCase = new AddTouristGuideUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while adding the tourist guide"))
                .getDomainEvents();

        //Assert
        var event = (TouristGuideAdded)events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Assertions.assertEquals(command.getDestinationsExperience(), event.getDestinationsExperience());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }


    private List<DomainEvent> history(){
        DestinationId destinationId = DestinationId.of("YYYYY");
        Destination destination = new Destination(
                destinationId,
                new Hotel("Hilton","Street 123"),
                new Weather(Weather.WeatherTypes.COLD),
                new City("Bogota"),
                new Country("Colombia")
        );

        Date beginningDate = parseDate("2022-09-14");
        Date endDate = parseDate("20122-09-20");
        CircuitDates circuitDates = new CircuitDates(beginningDate, endDate);

        Price price = new Price(225650.0);

        var event = new CircuitCreated(destination, circuitDates, price);
        return List.of(event);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}