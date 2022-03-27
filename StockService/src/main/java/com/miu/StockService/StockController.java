package com.miu.StockService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class StockController {

    private Random random;

    @GetMapping("/stock/{id}")
    public ResponseEntity<?> getStockBasedOnId(@PathVariable String id) {
        random = new Random();
        int number = random.nextInt(100);
        System.out.println("the number is " + number);
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
