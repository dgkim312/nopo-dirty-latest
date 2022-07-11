package com.tandem6.nopostore.store.controller;

import com.tandem6.nopostore.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping
    public ResponseEntity AllStores() {
        return new ResponseEntity(storeService.getAllStores(), HttpStatus.OK);
    }
}
