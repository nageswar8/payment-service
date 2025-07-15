package com.nag.payment_service.service;

import com.nag.payment_service.dto.PaymentRequest;
import com.nag.payment_service.dto.PaymentResponse;
import com.nag.payment_service.entity.PaymentTransaction;
import com.nag.payment_service.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RazorpayService {

    private final PaymentRepository paymentRepository;
    private final RazorpayClient razorpayClient;

    public PaymentResponse createOrder(PaymentRequest paymentRequest) throws RazorpayException {

        int amountInPaise = paymentRequest.getAmount() * 100;

        JSONObject orderRequest = new JSONObject();

        orderRequest.put("amount", paymentRequest.getAmount()*100);
        orderRequest.put("currency", paymentRequest.getCurrency());
        orderRequest.put("receipt", paymentRequest.getReceipt());
        orderRequest.put("payment_capture",1);

        Order order = razorpayClient.orders.create(orderRequest);

        PaymentTransaction build = PaymentTransaction.builder()
                .orderId(order.get("id"))
                .amount(paymentRequest.getAmount())
                .currency(paymentRequest.getCurrency())
                .receipt(paymentRequest.getReceipt())
                .status(order.get("status"))
                .build();
        paymentRepository.save(build);
        PaymentResponse response = new PaymentResponse();
        response.setOrderId(order.get("id"));
        response.setStatus(order.get("status"));
        response.setRazorpayKey("rzp_test_YourKeyHere");
        response.setAmount(amountInPaise);
        response.setCurrency(paymentRequest.getCurrency());
        return response;
    }

    public PaymentTransaction getStatus(String orderId) {
        return paymentRepository.findById(orderId).orElse(null);
    }

}
