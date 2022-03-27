package com.miu.ProductService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int productNumber;
    private String name;
    private Integer numberOnStock;
}
