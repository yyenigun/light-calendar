package com.light.calendar.domain.entity;

public enum Status {
    PASSIVE(0),
    ACTIVE(1);

    private final Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}

