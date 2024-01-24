package com.example.ProductMicroService.Service;

import com.example.ProductMicroService.Exception.DateException;
import com.example.ProductMicroService.Exception.NameException;
import com.example.ProductMicroService.Exception.PriceException;
import com.example.ProductMicroService.Exception.QtyException;
import com.example.ProductMicroService.Model.Product;
import com.example.ProductMicroService.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private int counter=1;
    LocalDate date=LocalDate.now();
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        Optional<Product> product= Optional.ofNullable(productRepository.findProductById(id));
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        ArrayList<Product> products= (ArrayList<Product>) productRepository.findAll();
        return products;
    }

    @Override
    public Product AddNewProduct(Product product) {
        Product prod=new Product();
        String str=product.getCategory().toString().substring(0,2);
        prod.setId(str+counter);
        counter++;
        char firstChar=product.getProductName().charAt(0);
        if(!(Character.isLetter(firstChar)))
        {
            throw new NameException("Product Name must start with a alphabet");
        }
        prod.setProductName(product.getProductName());
        prod.setCategory(product.getCategory());
        if(product.getPrice()<=0)
        {
            throw new PriceException("Price Cannot be less than 0");
        }
        prod.setPrice(product.getPrice());
        if(product.getQuantity()>=100)
        {
            throw new QtyException("Quantity should be less than 100");
        }
        prod.setQuantity(product.getQuantity());
        if(product.getExpirydate().isBefore(date))
        {
            throw new DateException("Expiry Date cannot be before Current Date");
        }
        prod.setExpirydate(product.getExpirydate());
        productRepository.save(prod);
        return prod;
    }

    @Override
    public void UpdateProduct(String id, Product product) {
        Optional<Product> product1= Optional.ofNullable(productRepository.findProductById(id));
        if(product1.isPresent()) {
            Product p = product1.get();
            p.setProductName(product.getProductName());
            p.setQuantity(product.getQuantity());
            p.setPrice(product.getPrice());
            p.setCategory(product.getCategory());
            productRepository.save(p);
        }
        else
        {
            throw new RuntimeException("Invalid Product ID");
        }
    }

    @Override
    public Boolean DeleteProduct(String id) {
        Optional<Product> product = Optional.ofNullable(productRepository.findProductById(id));
        if (!product.isPresent())
        {
            throw new RuntimeException("Invalid Company Code");
        }
        productRepository.deleteById(Integer.valueOf(id));
        return true;
    }

}
