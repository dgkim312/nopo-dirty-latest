package com.tandem6.nopostore.starred.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@ToString
@RequiredArgsConstructor
public abstract class Event {
    private final String eventId;
    private final String version;
    private final Object payload;
    //private final long unixTime;  = Instant.now().getEpochSecond();
    private final long unixTime;
}
