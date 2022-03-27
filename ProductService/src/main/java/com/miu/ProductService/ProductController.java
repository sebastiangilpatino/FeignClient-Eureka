package com.miu.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("api/product/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable String productId) {
        ResponseEntity<?> stockEntity = productFeignClient.getStock(productId);
        Integer stock = (Integer) stockEntity.getBody();
        Product product = new Product(Integer.parseInt(productId), "anyName", stock);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @FeignClient(name = "StockService")
    interface ProductFeignClient {
        @GetMapping("/api/stock/{productId}")
        ResponseEntity<?> getStock(@PathVariable String productId);
    }
}
