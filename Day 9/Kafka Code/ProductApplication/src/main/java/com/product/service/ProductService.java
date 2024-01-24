package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {
	Product createProduct(Product product);

    Product updateProduct(Product product);

    List< Product > getAllProduct();

    Product getProductById(long productId);

    void deleteProduct(long productId);

}
