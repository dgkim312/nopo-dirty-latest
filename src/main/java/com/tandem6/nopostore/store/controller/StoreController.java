package com.tandem6.nopostore.store.controller;

import com.tandem6.nopostore.store.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping
    public ResponseEntity allStores() {
        return new ResponseEntity(storeService.getAllStores(), HttpStatus.OK);
    }

    @GetMapping("/store/starred")
    public ResponseEntity findAllStoreOrderByRanking() {
        return new ResponseEntity(storeService.findAllStoreOrderByRanking(), HttpStatus.OK);
    }
}
