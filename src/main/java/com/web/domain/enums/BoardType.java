package com.web.domain.enums;

/**
 * @author : taeyoung
 * @since : 2018-12
 */
public enum  BoardType {
    notice("공지사항"), free("자유계시판");

    private String value;

    BoardType(String value){
        this.value  = value;
    }

    public String getValue() {
        return this.value;
    }
}
