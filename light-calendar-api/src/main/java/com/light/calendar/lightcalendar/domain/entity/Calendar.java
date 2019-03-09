package com.light.calendar.lightcalendar.domain.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "calendar")
public class Calendar extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "display_name")
    private String displayName;

    @OneToMany(mappedBy = "calendar", fetch = FetchType.EAGER)
    private Set<Event> events = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
