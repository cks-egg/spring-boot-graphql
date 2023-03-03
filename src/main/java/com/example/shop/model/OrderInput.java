package com.example.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class OrderInput {

    @Id @GeneratedValue
    @Column()
    private Long id;

    @Column()
    private String userId;

    @Column()
    private Long itemId;

    @Column(nullable = false)
    private int amount;
}
