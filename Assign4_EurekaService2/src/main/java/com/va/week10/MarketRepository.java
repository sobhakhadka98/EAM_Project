package com.va.week10;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface MarketRepository extends MongoRepository<Market, String> {
    Optional<Market> findBySymbol(String symbol);
}