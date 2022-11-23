package com.tandem6.nopostore.starred.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("local")
public class MockEventService implements EventService{

    @Override
    public void publishEvent(Event event) {
        log.info("Mock");
        log.info(event.toString());
    }
}
