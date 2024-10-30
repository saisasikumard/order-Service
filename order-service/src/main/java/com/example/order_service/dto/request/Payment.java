package com.example.order_service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment
{
    int paymentId;
    String paymentStatus;
    String TranscationId;
    int orderId;
    double amount;
}
