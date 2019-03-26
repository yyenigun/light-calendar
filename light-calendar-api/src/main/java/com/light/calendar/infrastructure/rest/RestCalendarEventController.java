package com.light.calendar.infrastructure.rest;

import com.light.calendar.application.controller.CalendarEventController;
import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.domain.service.CalendarEventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestCalendarEventController implements CalendarEventController {

    private CalendarEventService calendarEventService;

    public RestCalendarEventController(CalendarEventService calendarEventService) {
        this.calendarEventService = calendarEventService;
    }

    @PostMapping("/calendars/{calendarId}/events")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void createEvent(Long calendarId, CalendarEventResource resource) {
        calendarEventService.createEvent(calendarId, resource);
    }

    @GetMapping("/calendars/{calendarId}/events")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<CalendarEventResource> listEvents(Long calendarId,
                                                  @RequestParam(required = false) String locale,
                                                  @RequestParam(required = false) Date startDate,
                                                  @RequestParam(required = false) Date endDate) {
        return calendarEventService.retrieveEvents(calendarId, locale, startDate, endDate);
    }
}
