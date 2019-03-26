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
import java.util.List;
import java.util.stream.Collectors;

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

    public void createEvent(Long calendarId, CalendarEventResource calendarEventResource) {
        calendarEventValidator.validate(calendarEventResource);
        Calendar calendar = calendarRepository.findByIdAndStatus(calendarId, Status.ACTIVE)
                .orElseThrow(() -> new RequestNotValidException("validation.calendar.not.found", calendarEventResource.getLocale()));
        CalendarEvent calendarEvent = modelMapper.map(calendarEventResource, CalendarEvent.class);
        calendarEvent.setCreatedDate(new Date());
        calendarEvent.setCalendar(calendar);
        calendarEvent.setStatus(Status.ACTIVE);
        calendarEventRepository.save(calendarEvent);
    }

    public List<CalendarEventResource> retrieveEvents(Long calendarId,
                                                      String locale,
                                                      Date startDate,
                                                      Date endDate) {
        calendarEventValidator.validateCalendarId(calendarId);
        Calendar calendar = calendarRepository.findByIdAndStatus(calendarId, Status.ACTIVE)
                .orElseThrow(() -> new RequestNotValidException("validation.calendar.not.found", locale));
        List<CalendarEvent> calendarEvents = calendarEventRepository
                .findByCalendarAndStatusBetweenStartDateAndEndDate(calendar, Status.ACTIVE, startDate, endDate);
        return calendarEvents.stream()
                .map(c -> modelMapper.map(c, CalendarEventResource.class))
                .collect(Collectors.toList());
    }
}
