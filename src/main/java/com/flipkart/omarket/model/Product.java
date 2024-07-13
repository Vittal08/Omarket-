package com.flipkart.omarket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel{
private long id ;
private String imageurl;
private String description ;
private Category category ;
private String title ;

}
