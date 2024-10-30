package com.example.order_service.service;

import com.example.order_service.dto.request.Payment;

import com.example.order_service.dto.request.TransactionRequest;
import com.example.order_service.dto.response.TransactionResponse;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String message;
        Order order=transactionRequest.getOrder();
        Payment payment = new Payment();
        //place rest call to payment

        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        HttpEntity<Payment> requestEntity = new HttpEntity<>(payment);
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9090/payment/doPayment",requestEntity, Payment.class);
        System.out.println("Order ID: " + order.getId() + ", Amount: " + order.getPrice());
        // Create HttpEntity with the request body and headers

        message= paymentResponse.getPaymentStatus().equals("Success")?"Success your order placed successfully":"payment error ,order added to cart";
        Order savedOrder=orderRepo.save(order);
        System.out.println("Order ID: " + order.getId() + ", Amount: " + order.getPrice());
        System.out.println(paymentResponse.getAmount()+" "+ paymentResponse.getOrderId());
        TransactionResponse transactionResponse=new TransactionResponse();
        transactionResponse.setOrder(savedOrder);
        transactionResponse.setAmount(paymentResponse.getAmount());
        transactionResponse.setTransactionId(paymentResponse.getTranscationId());
        transactionResponse.setMessage(message);
        return transactionResponse;
    }
}
