package com.flipkart.omarket.Controller;
import com.flipkart.omarket.exception.ProductNotFoundException;
import com.flipkart.omarket.Service.ProductService;
import com.flipkart.omarket.model.Category;
import com.flipkart.omarket.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/products")
@RestController
public class ProductController {
    private ProductService ps;
    public ProductController(ProductService ps) {
        this.ps = ps;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        ResponseEntity<Product> res = new ResponseEntity<>(ps.getProductById(id), HttpStatus.OK);
        return res;
    }
    @GetMapping("/all")
    public List<Product> getALlProducts(){
        return ps.getAllProducts();
    }

    @GetMapping("category/{category}")
    public List<Product> getProductsInSpecCategory(@PathVariable("category")String category){
        return ps.getProductInSpecCategory(category);
    }
    //    @PatchMapping
    //    public ResponseEntity<Product> updateProduct
}