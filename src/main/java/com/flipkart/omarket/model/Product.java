package com.flipkart.omarket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
private double price ;
private Category category ;
private String title ;

}
