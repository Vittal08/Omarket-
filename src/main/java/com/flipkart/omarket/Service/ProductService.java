package com.flipkart.omarket.Service;
import com.flipkart.omarket.exception.ProductNotFoundException;
import com.flipkart.omarket.model.Category;
import com.flipkart.omarket.model.Product;
import java.util.*;
public interface ProductService {

    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product updateProduct(long id , Product product );
    List<Product>getProductInSpecCategory(String category);

}