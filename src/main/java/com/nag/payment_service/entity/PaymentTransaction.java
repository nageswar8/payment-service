package com.nag.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentTransaction {

    @Id
    private String orderId;
    private int amount;
    private String currency;
    private String status;
    private String receipt;
}
