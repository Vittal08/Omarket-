package com.flipkart.omarket.Service;

import com.flipkart.omarket.model.Product;

import java.util.*;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getALlProducts();


}
