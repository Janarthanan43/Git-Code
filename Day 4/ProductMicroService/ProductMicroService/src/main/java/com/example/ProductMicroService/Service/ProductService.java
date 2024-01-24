package com.example.ProductMicroService.Service;

import com.example.ProductMicroService.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> getProductById(String id);
    List<Product> getAllProducts();
    Product AddNewProduct(Product product);
    void UpdateProduct(String id,Product product);
    Boolean DeleteProduct(String id);


}
