package org.raghav.productservicedemo.Services;

import org.raghav.productservicedemo.Models.Product;
import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    String replaceProduct(long id, Product product);
    void deleteProduct(long id);
    Product updateProduct(long id, Product product);
}
