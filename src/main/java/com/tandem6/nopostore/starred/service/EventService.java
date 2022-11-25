package com.tandem6.nopostore.starred.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface EventService {
    public void publishEvent(Event event) throws JsonProcessingException;
}
