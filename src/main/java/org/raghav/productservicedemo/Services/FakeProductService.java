package org.raghav.productservicedemo.Services;

import org.raghav.productservicedemo.Dtos.FakeStoreProductDto;
import org.raghav.productservicedemo.Models.Category;
import org.raghav.productservicedemo.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService {

    private String apiUrl = "https://fakestoreapi.com/products/";
    private RestTemplate restTemplate;

    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(apiUrl + id,
                FakeStoreProductDto.class);
        Product product = this.ConvertToProduct(fakeStoreProductDto);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    private Product ConvertToProduct(FakeStoreProductDto dto) {
        Product product = new Product();

        // Set the ID; if dto.getId() is null, default to 0
        product.setId(dto.getId() != null ? dto.getId() : 0);

        // Map title to Name in Product
        product.setName(dto.getTitle());

        // Map Description
        product.setDescription(dto.getDescription());

        // Map Price
        product.setPrice(dto.getPrice());

        // Convert category string to Category object
        if (dto.getCategory() != null) {
            Category category = new Category();
            category.setId(0); // Default ID; adjust as necessary
            category.setName(dto.getCategory());
            product.setCategory(category);
        } else {
            product.setCategory(null);
        }

        return product;
    }
}