package com.va.week10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MarketService {

    @Autowired
    private MarketRepository marketRepository;

    public Market addStock(Market stock) {
        return marketRepository.save(stock);
    }
    
    public void reduceStock(String symbol, int quantity) {
        Market stock = marketRepository.findBySymbol(symbol)
            .orElseThrow(() -> new RuntimeException("Stock not found"));
        
        if (stock.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }

        stock.setQuantity(stock.getQuantity() - quantity);
        marketRepository.save(stock);
    }

}