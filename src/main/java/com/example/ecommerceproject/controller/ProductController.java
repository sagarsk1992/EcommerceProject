package com.example.ecommerceproject.controller;
import com.example.ecommerceproject.Interfaces.ProductService;
import com.example.ecommerceproject.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //handling the Https requests
@RequestMapping("/product")
public class ProductController {

//sample Code
//    @GetMapping("/{idd}")
//    public String getProductById(@PathVariable("idd") Long  id){  //or @PathVariable Long  idd
//        return "Hi";
//    }

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //localhost:8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

}
