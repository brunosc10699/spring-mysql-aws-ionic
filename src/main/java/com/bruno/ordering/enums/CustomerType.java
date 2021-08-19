package com.bruno.ordering.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomerType {

    PERSONAL(1, "Personal"),
    BUSINESS(2, "Business");

    private Integer code;
    private String description;

    public CustomerType toEnum(Integer code){
        if(code == null) return null;

        for(CustomerType type : CustomerType.values()){
            if(code.equals(type.getCode())) return type;
        }

        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
