package com.light.calendar.domain.service;

import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.domain.entity.Calendar;
import com.light.calendar.domain.entity.CalendarEvent;
import com.light.calendar.domain.entity.Status;
import com.light.calendar.domain.exception.RequestNotValidException;
import com.light.calendar.domain.repository.CalendarEventRepository;
import com.light.calendar.domain.repository.CalendarRepository;
import com.light.calendar.domain.validator.CalendarEventValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CalendarEventService {

    private CalendarEventValidator calendarEventValidator;
    private CalendarEventRepository calendarEventRepository;
    private CalendarRepository calendarRepository;
    private ModelMapper modelMapper;

    public CalendarEventService(CalendarEventValidator calendarEventValidator,
                                CalendarEventRepository calendarEventRepository,
                                CalendarRepository calendarRepository,
                                ModelMapper modelMapper) {
        this.calendarEventValidator = calendarEventValidator;
        this.calendarEventRepository = calendarEventRepository;
        this.calendarRepository = calendarRepository;
        this.modelMapper = modelMapper;
    }

    public void createEvent(Long calendarId, CalendarEventResource calendarEventResource, String locale) {
        calendarEventValidator.validate(calendarEventResource, locale);
        Calendar calendar = calendarRepository.findByIdAndStatus(calendarId, Status.ACTIVE)
                .orElseThrow(() -> new RequestNotValidException("validation.calendar.not.found", locale));
        CalendarEvent calendarEvent = modelMapper.map(calendarEventResource, CalendarEvent.class);
        calendarEvent.setCreatedDate(new Date());
        calendarEvent.setCalendar(calendar);
        calendarEvent.setStatus(Status.ACTIVE);
        calendarEventRepository.save(calendarEvent);
    }
}
