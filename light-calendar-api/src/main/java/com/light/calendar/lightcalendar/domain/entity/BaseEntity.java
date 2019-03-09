package com.light.calendar.lightcalendar.domain.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status", nullable = false)
    private Status status;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
