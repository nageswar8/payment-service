package com.nag.payment_service.controller;

import com.nag.payment_service.dto.PaymentRequest;
import com.nag.payment_service.dto.PaymentResponse;
import com.nag.payment_service.entity.PaymentTransaction;
import com.nag.payment_service.service.RazorpayService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final RazorpayService razorpayService;

    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponse> initiate(@RequestBody PaymentRequest request) throws RazorpayException {

        PaymentResponse order = razorpayService.createOrder(request);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/status/{orderId}")
    public ResponseEntity<PaymentTransaction> getStatus(@PathVariable String orderId) {
        PaymentTransaction tx = razorpayService.getStatus(orderId);
        return tx!=null?ResponseEntity.ok(tx):ResponseEntity.notFound().build();

    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload,
                                                @RequestHeader("X-Razorpay-Signature") String signature) {
        System.out.println("Webhook payload: " + payload);
        System.out.println("Signature: " + signature);
        return ResponseEntity.ok("Webhook received");

        //rzp_test_3vsHncQLyte3qc
        //a4op3JhlSXYERHgkuXzy0erl
    }

}
