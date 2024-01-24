package com.DISetter.test.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.DISetter.Controller.Controller;
import com.DISetter.Service.OrderService;
import com.DISetter.Service.UserService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
 
    @InjectMocks
    private Controller userController;
 
    @Mock
    private UserService userService;
 
    @Mock
    private OrderService orderService;
 
    @Autowired
    private MockMvc mockMvc;
 
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
 
    @Test
    public void testGetUserDetails() throws Exception {
        when(userService.getUserDetails()).thenReturn("John Doe");
 
        mockMvc.perform(MockMvcRequestBuilders.get("/user-details"))
                .andExpect(status().isOk())
                .andExpect(content().string("John Doe"));
    }
 
    @Test
    public void testGetUserOrders() throws Exception {
        when(userService.getUserOrders()).thenReturn("User orders: [Order1, Order2]");
 
        mockMvc.perform(MockMvcRequestBuilders.get("/user-orders"))
                .andExpect(status().isOk());
    }
 
    @Test
    public void testGetOrderUser() throws Exception {
        when(orderService.getOrderUser()).thenReturn("Ordered user: User: John Doe");
 
        mockMvc.perform(MockMvcRequestBuilders.get("/order-user"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ordered user: John Doe"));
    }
}
