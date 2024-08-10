package org.raghav.productservicedemo.Services;

import org.raghav.productservicedemo.Models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    Product createProduct();
    Product replaceProduct(Product product);
    void deleteProduct();
    Product replaceProduct();
}
