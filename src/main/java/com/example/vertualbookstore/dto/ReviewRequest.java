package com.example.vertualbookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {
    private Integer rating;
    private String comment;
}

