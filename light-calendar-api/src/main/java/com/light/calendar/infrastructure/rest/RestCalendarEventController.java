package com.light.calendar.infrastructure.rest;

import com.light.calendar.application.controller.CalendarEventController;
import com.light.calendar.application.model.CalendarEventResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestCalendarEventController implements CalendarEventController {

    @PostMapping("/calendars/{calendarId}/events")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void createEvent(Long calendarId, CalendarEventResource request) {
        //TODO implement create event
    }

    @GetMapping("/calendars/{calendarId}/events")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<CalendarEventResource> listEvents(Long calendarId, Date startDate, Date endDate) {
        //TODO implement list events
        return null;
    }
}
