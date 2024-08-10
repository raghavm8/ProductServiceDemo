package org.raghav.productservicedemo.Controllers;

import org.raghav.productservicedemo.Models.Product;
import org.raghav.productservicedemo.Services.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/*
* Get - get a product
* Push - create a product
* Put - replace a product
* Patch - update a product
* Delete - delete a product
* */

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id")long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id")long id, @RequestBody Product product) {
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")long id, @RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")long id) {
    }
}
