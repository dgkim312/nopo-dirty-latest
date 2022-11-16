package com.tandem6.nopostore.store.service;

import com.tandem6.nopostore.store.controller.dto.RequestRegionalStoreDTO;
import com.tandem6.nopostore.store.domain.Store;
import com.tandem6.nopostore.store.mapper.StoreMapper;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    public DefaultRes getAllStores() {
        final List<Store> storeList = storeMapper.findAll();
        if (storeList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeList);
    }

    public List<Store> findAllStoreOrderByRanking() {
        final List<Store> storeList = storeMapper.findAllStoreOrderByRanking();
//        if (storeList.isEmpty())
//            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
//        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), storeList);
        return storeList;
    }

    public List<Store> findRegionalStoreOrderByRanking(RequestRegionalStoreDTO requestRegionalStoreDTO) {
        final List<Store> storeList = storeMapper.findRegionalStoreOrderByRanking(requestRegionalStoreDTO);
        return storeList;
    }
}
