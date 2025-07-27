package com.va.week10;

import com.va.week10.Order;
import com.va.week10.OrderRepository;
import com.va.week10.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;  // 🔹 Add this

    public Order saveOrder(Order order) {
        if (!userRepo.existsById(order.getUserId())) {
            throw new IllegalArgumentException("Invalid userId: User does not exist");
        }
        return orderRepo.save(order);
    }

    public List<Order> getOrdersByUser(String userId) {
        return orderRepo.findByUserId(userId);
    }
}
