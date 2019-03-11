package com.light.calendar.domain.service;

import com.light.calendar.IntegrationTest;
import com.light.calendar.application.model.CalendarEventResource;
import com.light.calendar.builder.CalendarEventResourceBuilder;
import com.light.calendar.domain.entity.CalendarEvent;
import com.light.calendar.domain.entity.Status;
import com.light.calendar.domain.repository.CalendarEventRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
public class CalendarEventServiceIT extends IntegrationTest {

    @Autowired
    CalendarEventService calendarEventService;

    @Autowired
    CalendarEventRepository calendarEventRepository;

    @Test
    @Sql(scripts = "classpath:service/CalendarEventService/insert-calendar.sql")
    public void should_create_event() {
        //given
        Long calendarId = 1L;
        String locale = "en";
        CalendarEventResource calendarEventResource = CalendarEventResourceBuilder.create();

        //when
        calendarEventService.createEvent(calendarId, calendarEventResource, locale);

        //then
        Optional<CalendarEvent> calendarEventOptional = calendarEventRepository.findById(1L);
        CalendarEvent calendarEvent = calendarEventOptional.get();
        assertThat(calendarEvent).isNotNull();
        assertThat(calendarEvent.getEventName()).isEqualTo("my name");
        assertThat(calendarEvent.getEventDescription()).isEqualTo("my desc");
        assertThat(calendarEvent.getStartDate()).isNotNull();
        assertThat(calendarEvent.getEndDate()).isNotNull();
        assertThat(calendarEvent.getCreatedDate()).isNotNull();
        assertThat(calendarEvent.getUpdatedDate()).isNull();
        assertThat(calendarEvent.getStatus()).isEqualTo(Status.ACTIVE);
    }
}
