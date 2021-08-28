package com.bruno.ordering.entities;

import com.bruno.ordering.entities.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Integer paymentStatus;

    @OneToOne
    @JoinColumn(name = "order_id")
    @MapsId
    private Order order;

    public PaymentStatus getPaymentStatus(){
        return PaymentStatus.toEnum(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus.getCode();
    }

}