package com.DISetter.test.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DISetter.Service.OrderService;
import com.DISetter.Service.UserService;

import java.util.Collections;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
public class UserServiceTest {
 
    @InjectMocks
    private UserService userService;
 
    @Mock
    private OrderService orderService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testGetUserDetails() {
        // Test the UserService
        String userDetails = userService.getUserDetails();
        assertEquals("John Doe", userDetails);
    }
 
    @Test
    public void testGetUserOrders() {
        // Mock the behavior of the OrderService
        when(orderService.getOrders()).thenReturn(Collections.singletonList("Order1, Order2"));
 
        // Test the UserService
        String userOrders = userService.getUserOrders();
        assertEquals("User orders: [Order1, Order2]", userOrders);
    }
}
