package com.light.calendar.lightcalendar.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "calendar_id", referencedColumnName = "id", nullable = false)
    private Calendar calendar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
