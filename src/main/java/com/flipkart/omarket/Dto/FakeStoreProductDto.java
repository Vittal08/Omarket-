package com.flipkart.omarket.Dto;

import lombok.Data;

@Data
public class FakeStoreProductDto {
    private long id ;
    private String title;
    private double price ;
    private String category ;
    private String Description;


    /*
    {
                id:1,
                title:'...',
                price:'...',
                category:'...',
                description:'...',
                image:'...'
            }
     */
}
