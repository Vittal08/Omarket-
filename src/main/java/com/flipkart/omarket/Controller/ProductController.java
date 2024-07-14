package com.flipkart.omarket.Controller;

import com.flipkart.omarket.exception.ProductNotFoundException;
import com.flipkart.omarket.Service.ProductService;
import com.flipkart.omarket.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/products")
@RestController
public class ProductController  {
    private ProductService ps ;
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        ResponseEntity<Product> res = new ResponseEntity<>(ps.getProductById(id),
                HttpStatus.OK);

        return res;

    }
    @GetMapping("/all")
    public List<Product> getALlProducts() {
        return ps.getALlProducts();

    }


}
