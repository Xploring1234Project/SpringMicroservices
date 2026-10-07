package com.training.productservice.controller;

import com.training.productservice.dto.ProductDTO;
import com.training.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDTO>> getAllProducts()
    {
        List<ProductDTO> productList=productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    //http:localhost:8082/api/products/msg
    @GetMapping("/msg")
    public String getMessage()
    {
        return "testing gateway from product service";
    }
}
