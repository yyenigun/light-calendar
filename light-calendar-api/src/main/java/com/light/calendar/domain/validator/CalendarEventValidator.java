package com.light.calendar.domain.validator;

import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.domain.exception.RequestNotValidException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CalendarEventValidator {

    public void validate(CalendarEventResource resource, String locale) {
        if (resource == null) {
            throw new RequestNotValidException("validation.field.mandatory.event", locale);
        }
        if (StringUtils.isEmpty(resource.getEventName())) {
            throw new RequestNotValidException("validation.field.mandatory.event.name", locale);
        }
        if (resource.getStartDate() == null) {
            throw new RequestNotValidException("validation.field.mandatory.event.startDate", locale);
        }
        if (resource.getEndDate() == null) {
            throw new RequestNotValidException("validation.field.mandatory.event.endDate", locale);
        }
        if (resource.getStartDate().after(resource.getEndDate())) {
            throw new RequestNotValidException("validation.field.event.datesMismatch", locale);
        }
    }
}
