package com.light.calendar.domain.validator;

import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.builder.CalendarEventResourceBuilder;
import com.light.calendar.domain.exception.RequestNotValidException;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CalendarEventValidatorTest {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private CalendarEventValidator calendarEventValidator;

    @Before
    public void initialize() {
        calendarEventValidator = new CalendarEventValidator();
    }

    @Test
    public void should_throw_event_resource_mandatory_exception_when_resource_is_null() {
        //given
        CalendarEventResource resource = null;
        String locale = "en";

        //when event validator is called
        Throwable throwable = catchThrowable(() -> calendarEventValidator.validate(resource, locale));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(RequestNotValidException.class);
        RequestNotValidException exception = (RequestNotValidException) throwable;
        assertThat(exception.getMessage()).isEqualTo("validation.field.mandatory.event");
    }

    @Test
    public void should_throw_mandatory_exception_when_event_name_is_null() {
        //given
        CalendarEventResource resource = CalendarEventResourceBuilder.create();
        resource.setEventName(null);
        String locale = "en";

        //when event validator is called
        Throwable throwable = catchThrowable(() -> calendarEventValidator.validate(resource, locale));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(RequestNotValidException.class);
        RequestNotValidException exception = (RequestNotValidException) throwable;
        assertThat(exception.getMessage()).isEqualTo("validation.field.mandatory.event.name");
    }

    @Test
    public void should_throw_mandatory_exception_when_event_start_date_is_null() {
        //given
        CalendarEventResource resource = CalendarEventResourceBuilder.create();
        resource.setStartDate(null);
        String locale = "en";

        //when event validator is called
        Throwable throwable = catchThrowable(() -> calendarEventValidator.validate(resource, locale));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(RequestNotValidException.class);
        RequestNotValidException exception = (RequestNotValidException) throwable;
        assertThat(exception.getMessage()).isEqualTo("validation.field.mandatory.event.startDate");
    }

    @Test
    public void should_throw_mandatory_exception_when_event_end_date_is_null() {
        //given
        CalendarEventResource resource = CalendarEventResourceBuilder.create();
        resource.setEndDate(null);
        String locale = "en";

        //when event validator is called
        Throwable throwable = catchThrowable(() -> calendarEventValidator.validate(resource, locale));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(RequestNotValidException.class);
        RequestNotValidException exception = (RequestNotValidException) throwable;
        assertThat(exception.getMessage()).isEqualTo("validation.field.mandatory.event.endDate");
    }

    @Test
    public void should_throw_mandatory_exception_when_start_date_is_after_end_date() throws ParseException {
        //given
        CalendarEventResource resource = CalendarEventResourceBuilder.create();
        resource.setStartDate(DateUtils.parseDate("2019-06-30", DATE_FORMAT));
        resource.setEndDate(DateUtils.parseDate("2019-05-30", DATE_FORMAT));
        String locale = "en";

        //when event validator is called
        Throwable throwable = catchThrowable(() -> calendarEventValidator.validate(resource, locale));

        //then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(RequestNotValidException.class);
        RequestNotValidException exception = (RequestNotValidException) throwable;
        assertThat(exception.getMessage()).isEqualTo("validation.field.event.datesMismatch");
    }
}
