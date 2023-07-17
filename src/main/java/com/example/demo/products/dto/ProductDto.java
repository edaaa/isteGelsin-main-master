package com.example.demo.products.dto;

import com.example.demo.products.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String sku;
    private String barcode;
    private ProductType type;
    private boolean frozen;
    private Double price;
    private String unitType;
    private int stocks;

}
