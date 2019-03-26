package com.light.calendar.application.controller;

import com.light.calendar.application.model.CalendarEventResource;

import java.util.Date;
import java.util.List;

public interface CalendarEventController {

    void createEvent(Long calendarId, CalendarEventResource resource);

    List<CalendarEventResource> listEvents(Long calendarId, String locale, Date startDate, Date endDate);

}
