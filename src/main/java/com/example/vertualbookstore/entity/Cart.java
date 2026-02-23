package com.example.vertualbookstore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Cart belongs to user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Book added in cart
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private int quantity;
}
