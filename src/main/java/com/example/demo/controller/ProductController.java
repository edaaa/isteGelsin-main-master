package com.example.demo.controller;

import com.example.demo.products.dto.ProductCreateDto;
import com.example.demo.products.dto.ProductDto;
import com.example.demo.products.dto.ProductResponse;
import com.example.demo.services.ProductServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@AllArgsConstructor
public class ProductController {

    private final ProductServices productServices;


    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("urun kaydetme işlemi gerçekleştirilir")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productServices.save(product), HttpStatus.OK);

    }
}
