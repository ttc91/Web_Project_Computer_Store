package com.example.webproject.controllers.admin;

import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService service;





}
