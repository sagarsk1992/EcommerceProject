package com.example.ecommerceproject.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //handling the Https requests
@RequestMapping("/product")
public class ProductController {


    @GetMapping("/{idd}")
    public String getProductById(@PathVariable("idd") Long  id){  //or @PathVariable Long  idd
        return "Hi";
    }

}
