package com.sofkaU.TravelAgencyDDD.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.TravelAgencyDDD.plan.Activity;
import com.sofkaU.TravelAgencyDDD.plan.commands.CreatePlan;
import com.sofkaU.TravelAgencyDDD.plan.events.PlanCreated;
import com.sofkaU.TravelAgencyDDD.plan.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreatePlanUseCaseTest {

    @Test
    void CreatePlan(){
        //arrange
        PlanId planId = PlanId.of("XXXXX");

        //activity object construction
        Set<Activity> activities = new HashSet<>();
        ActivityId activityId = ActivityId.of("YYYYY");

        Activity activity = new Activity(activityId,
                new Time("15:30 p.m"),
                new Address("Street 123"),
                new Duration(2.5, "hours"));

        activities.add(activity);

        PlanDate planDate = new PlanDate(parseDate("2022-09-14"));

        var command = new CreatePlan(planId,activities,planDate);
        var useCase = new CreatePlanUseCase();


        //act
        List<DomainEvent> events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the plan"))
                .getDomainEvents();


        //assert
        PlanCreated event = (PlanCreated)events.get(0);
        Assertions.assertEquals(parseDate("2022-09-14"), event.getPlanDate().value());
        Assertions.assertEquals(activities, event.getActivities());

    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}