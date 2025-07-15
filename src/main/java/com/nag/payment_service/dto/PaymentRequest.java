package com.nag.payment_service.dto;

import lombok.Data;

@Data
public class PaymentRequest {
    private int amount;
    private String currency;
    private String receipt;
}
