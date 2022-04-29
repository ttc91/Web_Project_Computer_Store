package com.example.webproject.controllers.admin;

import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add_product")
    public ResponseEntity<Product> insertProduct(@Valid @RequestBody Product product){
        service.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



}
