package com.tandem6.nopostore.starred.service;

import com.tandem6.nopostore.starred.domain.Starred;
import com.tandem6.nopostore.starred.mapper.StarredMapper;
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
public class StarredService {

    private final StarredMapper starredMapper;

    public DefaultRes getAllStarreds() {
        final List<Starred> starredList = starredMapper.findAll();
        if (starredList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), starredList);
    }

}
