package com.nag.payment_service.dto;

import lombok.Data;

@Data
public class PaymentResponse {

    private String orderId;
    private String status;
    private String razorpayKey;
    private int amount;        // in paise
    private String currency;
}
