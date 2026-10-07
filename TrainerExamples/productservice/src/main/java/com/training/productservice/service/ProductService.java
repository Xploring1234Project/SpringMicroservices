package com.training.productservice.service;

import com.training.productservice.dto.ProductDTO;
import com.training.productservice.dao.ProductRepository;
import com.training.productservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;
    private final ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}