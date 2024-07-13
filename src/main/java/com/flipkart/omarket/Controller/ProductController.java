package com.flipkart.omarket.Controller;

import com.flipkart.omarket.Service.ProductService;
import com.flipkart.omarket.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/products")
public class ProductController implements ProductService {
    ProductService ps ;
    public ProductController() {
        this.ps = ps;
    }
    @Override
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {

        return null ;
    }

    @Override
    public List<Product> getALlProducts() {
        return null;
    }
}
