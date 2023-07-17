package com.example.demo.services;

import com.example.demo.products.dto.ProductCreateDto;
import com.example.demo.products.dto.ProductDto;
import com.example.demo.products.dto.ProductResponse;
import com.example.demo.products.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductServices {
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

    @Override
    public ProductResponse save(ProductDto productDto) {

        ModelMapper modelMapper = new ModelMapper();
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productRepository.save(productEntity);
        return new ProductResponse(messageSource.getMessage("product.create.success", null, Locale.ENGLISH));


    }
}
