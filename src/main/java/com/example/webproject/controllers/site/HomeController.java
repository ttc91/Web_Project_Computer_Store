package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String index(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        return "index";
    }




}
