package com.tandem6.nopostore.starred.service;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class CreateStarredEvent extends Event implements Serializable {

    public CreateStarredEvent(String version, Object payload) {
        super(UUID.randomUUID().toString(), version, payload, Instant.now().getEpochSecond());
    }

    @Override
    public String toString() {
        return "CreateStarredEvent{} " + super.toString();
    }
}
