package com.DISetter.test.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DISetter.Service.OrderService;
import com.DISetter.Service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
public class OrderServiceTest {
 
    @InjectMocks
    private OrderService orderService;
 
    @Mock
    private UserService userService;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testGetOrders() {
        when(userService.getUserDetails()).thenReturn("John Doe");
 
        // Test the OrderService
        String orders = orderService.getOrders().toString();
        assertEquals("[Order1, Order2]", orders);
    }
 
    @Test
    public void testGetOrderUser() {
        when(userService.getUserDetails()).thenReturn("John Doe");
 
        // Test the OrderService
        String orderUser = orderService.getOrderUser();
        assertEquals("Ordered user: John Doe", orderUser);
    }
}
