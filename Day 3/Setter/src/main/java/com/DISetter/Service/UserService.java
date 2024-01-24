package com.DISetter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 
@Service
public class UserService {
 
    private String userName = "John Doe";
    private OrderService orderService;
 
    @Autowired
    public void setOrderService(@Qualifier("orderService") OrderService orderService) {
        this.orderService = orderService;
    }
 
    public String getUserDetails() {
        // Simulate fetching user details
        return this.userName;
    }
 
    public String getUserOrders() {
        // Return String with user details as User orders
        return "User orders: " + orderService.getOrders();
    }
}
