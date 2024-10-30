package com.example.order_service.dto.response;

import com.example.order_service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {
    Order order;
    double amount;
    String transactionId;
    String message;

}
