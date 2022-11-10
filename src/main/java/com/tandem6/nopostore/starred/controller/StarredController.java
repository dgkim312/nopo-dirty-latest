package com.tandem6.nopostore.starred.controller;

import com.tandem6.nopostore.starred.controller.dto.RequestStarredCreateDTO;
import com.tandem6.nopostore.starred.service.StarredService;
import com.tandem6.nopostore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
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

    //Controller은 번역기의 역할이고, ACL
    @PostMapping
    public ResponseEntity createStarredToStore(@Valid @RequestBody RequestStarredCreateDTO requestStarredCreateDTO){
        starredService.createStarredToStore(requestStarredCreateDTO);
        return null;
    }

}
