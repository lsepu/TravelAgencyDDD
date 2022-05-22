package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.events.ItineraryNotification;
import com.sofkaU.TravelAgencyDDD.plan.events.PlanCreated;
import com.sofkaU.TravelAgencyDDD.plan.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NotifyItineraryUseCaseTest {

    private final String ROOT_ID = "XXXX";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyItinerary() {

        var event = planCreatedEvent();
        event.setAggregateRootId(ROOT_ID);

        var useCase = new NotifyItineraryUseCase();
        useCase.addRepository(repository);

        when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while sending the email with the day itinerary"))
                .getDomainEvents();

        //Assert
        var notification = (ItineraryNotification) events.get(0);
        Assertions.assertEquals("email sent with the day itinerary information", notification.getNotification());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }


    private PlanCreated planCreatedEvent() {
        Set<Activity> activities = new HashSet<>();
        ActivityId activityId = ActivityId.of("YYYYY");
        Activity activity = new Activity(activityId,
                new ActivityName("Museum visit"),
                new Time("15:30"),
                new Address("Street 123"),
                new Duration(2.5, "hours"));

        activities.add(activity);
        PlanDate planDate = new PlanDate(parseDate("2022-09-14"));

        var event = new PlanCreated(activities, planDate);
        return event;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}