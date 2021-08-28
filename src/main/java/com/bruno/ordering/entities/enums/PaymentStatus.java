package com.bruno.ordering.entities.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum PaymentStatus {

    PENDING(1, "Pending"),
    PAID(2, "Paid out"),
    CANCELED(3, "Canceled");

    private Integer code;
    private String description;

    public static PaymentStatus toEnum(Integer code){
        if(code == null) return null;

        for(PaymentStatus status : PaymentStatus.values())
            if(code.equals(status.getCode())) return status;

        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
