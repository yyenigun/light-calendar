package com.light.calendar.domain.repository;

import com.light.calendar.domain.entity.Calendar;
import com.light.calendar.domain.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Calendar findByIdAndStatus(Long id, Status status);
}
