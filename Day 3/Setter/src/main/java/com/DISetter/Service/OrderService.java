package com.DISetter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
 
@Service
public class OrderService {
 
    private UserService userService;
 
    @Autowired
    public void setUserService(@Lazy @Qualifier("userService") UserService userService) {
        this.userService = userService;
    }
 
    public List<String> getOrders() {
        // Simulate fetching orders
        List<String> orderList = new ArrayList<>();
        orderList.add("Order1");
        orderList.add("Order2");
        return orderList;
    }
 
    public String getOrderUser() {
        // Return String with user details as Ordered user
        return "Ordered user: " + userService.getUserDetails();
    }
}
