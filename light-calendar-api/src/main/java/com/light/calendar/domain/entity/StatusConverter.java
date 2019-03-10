package com.light.calendar.domain.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, Integer> {

    public Integer convertToDatabaseColumn(Status status) {
        return status.getValue();
    }

    public Status convertToEntityAttribute(Integer value) {
        switch (value) {
            case 1:
                return Status.ACTIVE;
            case 0:
                return Status.PASSIVE;
        }
        return null;
    }
}