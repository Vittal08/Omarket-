package com.flipkart.omarket.Service;
import com.flipkart.omarket.Dto.FakeStoreProductDto;
import com.flipkart.omarket.exception.ProductNotFoundException;
import com.flipkart.omarket.model.Category;
import com.flipkart.omarket.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
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
                            FakeStoreProductDto.class);
                if (fs == null){
                    throw new ProductNotFoundException("Product with id " + id + " doesn't exist");
                }
                return convertFsDtoToProduct(fs);
    }
    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] dtos = rs.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fs : dtos){
            products.add(convertFsDtoToProduct(fs));
        }
        return products;
    }
    public Product convertFsDtoToProduct(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setPrice(dto.getPrice());
        Category category = new Category();
        category.setDescription(dto.getCategory());
        product.setCategory(category);
        return product;
    }


    @Override
    public Product updateProduct(long id , Product product ){
        return null;
    }

    @Override
    public List<Product> getProductInSpecCategory(String category) {
        FakeStoreProductDto[] dtos  = rs.getForObject("https://fakestoreapi.com/products/category/"+category,
                FakeStoreProductDto[].class );
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fs : dtos){
            products.add(convertFsDtoToProduct(fs));
        }
        return products;
    }
//    {
//        "id": 5,
//            "title": "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
//            "price": 695,
//            "description": "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
//            "category": "jewelery",
//            "image": "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
//            "rating": {
//        "rate": 4.6,
//                "count": 400
//    private long id ;
//    private String title;
//    private double price ;
//    private String category ;
//    private String Description;
//    }
//    }
}