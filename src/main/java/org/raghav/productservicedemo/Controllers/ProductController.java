package org.raghav.productservicedemo.Controllers;

import org.raghav.productservicedemo.Exceptions.ProductLimitReachedException;
import org.raghav.productservicedemo.Models.Product;
import org.raghav.productservicedemo.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id")long id)
            throws ProductLimitReachedException {
        if(id>100){
            throw new ProductLimitReachedException("Limit is reached");
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
       return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public String replaceProduct(@PathVariable("id")long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id")long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id")long id) {
    }

//    @ExceptionHandler({RuntimeException.class, NullPointerException.class})
//    public ResponseEntity<String> handleException() {
//        System.out.println("Something went Wrong");
//        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public ResponseEntity<String> handleIndexException() {
//        System.out.println("Something went Wrong");
//        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRunTimeException() {
//        System.out.println("Something Wrong");
//        return new ResponseEntity<>("Something Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
