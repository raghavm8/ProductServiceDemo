package org.raghav.productservicedemo.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Product {
    private long id;
    private String Name    ;
    private String Description;
    private double Price;
    private Category category;
}
