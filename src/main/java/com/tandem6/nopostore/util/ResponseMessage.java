package com.tandem6.nopostore.util;

public enum ResponseMessage {
    NOT_FOUND_STORE("점포를 찾을 수가 없습니다."),
    READ_STORE("모든 점포를 조회하였습니다."),
    READ_USER("모든 사용자를 조회하였습니다."),
    ;

    private final String label;

    ResponseMessage(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
