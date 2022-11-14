package com.tandem6.nopostore.store.controller;

import com.tandem6.nopostore.store.controller.dto.RequestRegionalStoreDTO;
import com.tandem6.nopostore.store.controller.dto.StoreInfoDTO;
import com.tandem6.nopostore.store.domain.Store;
import com.tandem6.nopostore.store.service.StoreService;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
        List<StoreInfoDTO> storeInfoDTOList = storeService.findAllStoreOrderByRanking().stream().map(store ->
                new StoreInfoDTO(
                    store.getManagement_no(),
                    store.getLicense_issue_date(),
                    store.getStore_name(),
                    store.getLocation_address(),
                    store.getBusiness_type(),
                    store.getRanking())
        ).collect(Collectors.toList());
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeInfoDTOList), HttpStatus.OK);
    }

    @GetMapping("/store/regional_starred")
    public ResponseEntity findRegionalStoreOrderByRanking(@Valid RequestRegionalStoreDTO requestRegionalStoreDTO) {
        log.info(requestRegionalStoreDTO.toString());
        return new ResponseEntity(storeService.findRegionalStoreOrderByRanking(requestRegionalStoreDTO), HttpStatus.OK);
    }

}
