package com.abc.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String description;
    private Double price;
}
