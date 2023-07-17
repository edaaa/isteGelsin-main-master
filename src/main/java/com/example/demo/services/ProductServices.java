package com.example.demo.services;

import com.example.demo.products.dto.ProductCreateDto;
import com.example.demo.products.dto.ProductDto;
import com.example.demo.products.dto.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductServices {
    public ProductResponse save(ProductDto productDto);
}
