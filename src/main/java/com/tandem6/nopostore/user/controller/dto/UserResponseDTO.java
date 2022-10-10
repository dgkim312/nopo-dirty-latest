package com.tandem6.nopostore.user.controller.dto;

import com.tandem6.nopostore.user.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class UserResponseDTO {
    private final User user;
}
