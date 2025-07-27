package com.va.week10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/market")
public class MarketServiceController {

    @Autowired
    private MarketService marketService;

    @PostMapping("/add")
    public ResponseEntity<Market> addStock(@RequestBody Market stock) {
        return ResponseEntity.ok(marketService.addStock(stock));
    }

    @PutMapping("/stocks/reduce/{symbol}/{qty}")
    public ResponseEntity<String> reduceStock(@PathVariable String symbol, @PathVariable int qty) {
        try {
            marketService.reduceStock(symbol, qty);
            return ResponseEntity.ok("Stock reduced");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}