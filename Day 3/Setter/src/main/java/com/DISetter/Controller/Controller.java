package com.DISetter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DISetter.Service.OrderService;
import com.DISetter.Service.UserService;
 
@RestController
public class Controller {
 
    private UserService userService;
    private OrderService orderService;
 
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
 
    @GetMapping("/user-details")
    public String getUserDetails() {
        return userService.getUserDetails();
    }
 
    @GetMapping("/user-orders")
    public String getUserOrders() {
        return userService.getUserOrders();
    }
 
    @GetMapping("/order-user")
    public String getOrderUser() {
        return orderService.getOrderUser();
    }
}