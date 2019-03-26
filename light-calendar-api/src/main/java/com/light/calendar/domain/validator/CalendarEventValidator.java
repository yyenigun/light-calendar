package com.light.calendar.domain.validator;

import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.domain.exception.RequestNotValidException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CalendarEventValidator {

    public void validate(CalendarEventResource resource) {
        if (resource == null) {
            throw new RequestNotValidException("validation.field.mandatory.event", CalendarEventResource.getDefaultLocale());
        }
        if (StringUtils.isEmpty(resource.getEventName())) {
            throw new RequestNotValidException("validation.field.mandatory.event.name", resource.getLocale());
        }
        if (resource.getStartDate() == null) {
            throw new RequestNotValidException("validation.field.mandatory.event.startDate", resource.getLocale());
        }
        if (resource.getEndDate() == null) {
            throw new RequestNotValidException("validation.field.mandatory.event.endDate", resource.getLocale());
        }
        if (resource.getStartDate().after(resource.getEndDate())) {
            throw new RequestNotValidException("validation.field.event.datesMismatch", resource.getLocale());
        }
    }

    public void validateCalendarId(Long calendarId) {
        if (calendarId == null) {
            throw new RequestNotValidException("validation.field.mandatory.calendarId", CalendarEventResource.getDefaultLocale());
        }
    }
}
