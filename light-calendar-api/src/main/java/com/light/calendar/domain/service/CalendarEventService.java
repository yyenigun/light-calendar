package com.light.calendar.domain.service;

import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.domain.repository.CalendarEventRepository;
import com.light.calendar.domain.validator.CalendarEventValidator;
import org.springframework.stereotype.Service;

@Service
public class CalendarEventService {

    private CalendarEventValidator calendarEventValidator;
    private CalendarEventRepository calendarEventRepository;

    public CalendarEventService(CalendarEventValidator calendarEventValidator, CalendarEventRepository calendarEventRepository) {
        this.calendarEventValidator = calendarEventValidator;
        this.calendarEventRepository = calendarEventRepository;
    }

    public void createEvent(CalendarEventResource calendarEvent, String locale) {
        calendarEventValidator.validate(calendarEvent,locale);
        //TODO call create event repository
    }
}
