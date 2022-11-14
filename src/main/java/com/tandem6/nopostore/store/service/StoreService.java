package com.tandem6.nopostore.store.service;

import com.tandem6.nopostore.starred.controller.dto.RequestStarredCreateDTO;
import com.tandem6.nopostore.store.controller.dto.RequestRegionalStoreDTO;
import com.tandem6.nopostore.store.domain.Store;
import com.tandem6.nopostore.store.mapper.StoreMapper;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class StoreService {

    private StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper){
        this.storeMapper = storeMapper;
    }

    public DefaultRes getAllStores() {
        final List<Store> storeList = storeMapper.findAll();
        if (storeList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeList);
    }

    public DefaultRes findAllStoreOrderByRanking() {
        final List<Store> storeList = storeMapper.findAllStoreOrderByRanking();
        if (storeList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeList);
    }

    public DefaultRes findRegionalStoreOrderByRanking(RequestRegionalStoreDTO requestRegionalStoreDTO) {
        final List<Store> storeList = storeMapper.findRegionalStoreOrderByRanking(requestRegionalStoreDTO);
        if (storeList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeList);
    }
}
