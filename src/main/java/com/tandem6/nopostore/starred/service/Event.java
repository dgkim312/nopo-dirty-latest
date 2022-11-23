package com.tandem6.nopostore.starred.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@RequiredArgsConstructor
public abstract class Event implements Serializable {

    private final String eventId;
    private final String version;
    private final Object payload;
    private final long unixTime;
}
