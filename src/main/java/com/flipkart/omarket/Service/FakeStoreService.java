package com.flipkart.omarket.Service;

import com.flipkart.omarket.Dto.FakeStoreProductDto;
import com.flipkart.omarket.exception.ProductNotFoundException;
import com.flipkart.omarket.model.Category;
import com.flipkart.omarket.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service

public class FakeStoreService implements ProductService {
    RestTemplate rs;
    public FakeStoreService(RestTemplate rs) {
        this.rs = rs;
    }
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
                FakeStoreProductDto fs = rs.getForObject(
                        "https://fakestoreapi.com/products/" + id,
                            FakeStoreProductDto.class
                );
                if (fs == null){
                    throw new ProductNotFoundException("Product with id " + id + " doesn't exist");
                }
                return convertProductToFsDto(fs);
    }

    @Override
    public List<Product> getALlProducts() {
        return null;
    }
    public Product convertProductToFsDto(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setPrice(dto.getPrice());

        Category category = new Category();
        category.setDescription(dto.getCategory());
        product.setCategory(category);
        return product;
    }
}