package com.light.calendar.builder;

import com.light.calendar.application.model.CalendarEventResource;

import java.util.Date;

public class CalendarEventResourceBuilder {

    public static CalendarEventResource create() {
        CalendarEventResource resource = new CalendarEventResource();
        resource.setStartDate(new Date());
        resource.setEndDate(new Date());
        resource.setEventName("my name");
        resource.setEventDescription("my desc");
        resource.setLocale("EN");
        return resource;
    }
}
