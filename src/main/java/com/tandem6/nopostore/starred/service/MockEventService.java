package com.tandem6.nopostore.starred.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("local")
public class MockEventService implements EventService{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void publishEvent(Event event) throws JsonProcessingException {
        log.info("Mock");
        log.info(mapper.writeValueAsString(event));
    }
}
