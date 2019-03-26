package com.light.calendar.domain.repository;

import com.light.calendar.domain.entity.Calendar;
import com.light.calendar.domain.entity.CalendarEvent;
import com.light.calendar.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {

    List<CalendarEvent> findByCalendarAndStatusBetweenStartDateAndEndDate(Calendar calendar, Status status, Date startDate, Date endDate);
}
