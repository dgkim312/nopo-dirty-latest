package com.tandem6.nopostore.starred.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public abstract class Event {
    private final String eventId;
    private final String version;
    private final Object payload;
    private final long unixTime;
}
