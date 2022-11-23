package com.tandem6.nopostore.starred.service;

import com.tandem6.nopostore.starred.controller.dto.RequestStarredCreateDTO;
import com.tandem6.nopostore.starred.domain.Starred;
import com.tandem6.nopostore.starred.mapper.StarredMapper;
import com.tandem6.nopostore.util.DefaultRes;
import com.tandem6.nopostore.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StarredService {

    private final StarredMapper starredMapper;
    private final EventService eventService;


    public DefaultRes getAllStarreds() {
        final List<Starred> starredList = starredMapper.findAll();
        if (starredList.isEmpty())
            return DefaultRes.res(HttpStatus.NOT_FOUND.value(), ResponseMessage.NOT_FOUND_STORE.label());
        return DefaultRes.res(HttpStatus.OK.value(), ResponseMessage.READ_STORE.label(), starredList);
    }

    @Transactional
    public void createStarredToStore(RequestStarredCreateDTO requestStarredCreateDTO) {
        // requestStarredCreateDTO 비즈니스 적인 유효성을 확인해야 하는 것은 요기서 처리
        starredMapper.insertStarred(requestStarredCreateDTO);
        eventService.publishEvent( new CreateStarredEvent("0.1", requestStarredCreateDTO));

    }
}
