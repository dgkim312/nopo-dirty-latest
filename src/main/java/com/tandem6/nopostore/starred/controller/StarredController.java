package com.tandem6.nopostore.starred.controller;

import com.tandem6.nopostore.starred.service.StarredService;
import com.tandem6.nopostore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/starreds")
public class StarredController {

    private final StarredService starredService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping
    public ResponseEntity allStores() {
        return new ResponseEntity(starredService.getAllStarreds(), HttpStatus.OK);
    }

}
