package com.example.order_service.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.logging.Level;

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@Table(name="ORDER_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue
    int id;
    String name;
    int qty;
    double price;
}
