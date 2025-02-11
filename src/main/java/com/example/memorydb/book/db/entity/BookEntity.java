package com.example.memorydb.book.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "book")
public class BookEntity{

    @Id //프라이머리 키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //MySQL
    private Long id;

    private String name;
    private String category;
    private BigDecimal amount;
}
