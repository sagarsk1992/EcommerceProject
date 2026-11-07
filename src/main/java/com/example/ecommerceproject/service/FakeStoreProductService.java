package com.example.ecommerceproject.service;

import com.example.ecommerceproject.infaces.ProductService;
import com.example.ecommerceproject.dtos.FakeStoreProductDto;
import com.example.ecommerceproject.models.Category;
import com.example.ecommerceproject.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service   /* if u miss this annotatipn u will get error like No qualifying bean of type 'com.example.ecommerceproject.interfaces.ProductService'
available*/
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setDesc(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    public Product getProductById(Long id) {
        //Call FakeStore API here to get the Product with given id.
        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        //1st param -> URL
        //2nd param -> Response of type its says fakestoreDTo json returning right that to DTO object type

        if (fakeStoreProductDto == null) {
            return null;
        }

        //Convert FakeStore DTO into Product object.
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
