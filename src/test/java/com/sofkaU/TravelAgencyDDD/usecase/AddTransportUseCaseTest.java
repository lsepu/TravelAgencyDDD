package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.commands.AddMeal;
import com.sofkaU.TravelAgencyDDD.plan.commands.AddTransport;
import com.sofkaU.TravelAgencyDDD.plan.events.MealAdded;
import com.sofkaU.TravelAgencyDDD.plan.events.PlanCreated;
import com.sofkaU.TravelAgencyDDD.plan.events.TransportAdded;
import com.sofkaU.TravelAgencyDDD.plan.values.*;
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
class AddTransportUseCaseTest {

    private final String ROOT_ID = "XXXX";

    @InjectMocks
    private AddTransportUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addTransport() {

        var command = new AddTransport(
                PlanId.of(ROOT_ID),
                TransportId.of("ZZZZZ"),
                new TransportType(TransportType.Vehicles.CAR),
                new NumberOfPassengers(5)
        );

        var useCase = new AddTransportUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong while adding the transport"))
                .getDomainEvents();

        //Assert
        var event = (TransportAdded) events.get(0);
        Assertions.assertEquals(command.getTransportType().value(), event.getTransportType().value());
        Assertions.assertEquals(command.getTransportType().value(), event.getTransportType().value());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

    private List<DomainEvent> history() {
        Set<Activity> activities = new HashSet<>();
        ActivityId activityId = ActivityId.of("YYYYY");
        Activity activity = new Activity(activityId,
                new Time("15:30"),
                new Address("Street 123"),
                new Duration(2.5, "hours"));

        activities.add(activity);
        PlanDate planDate = new PlanDate(parseDate("2022-09-14"));

        var event = new PlanCreated(activities, planDate);
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