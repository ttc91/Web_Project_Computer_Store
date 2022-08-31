package com.example.webproject.controllers.admin;

import com.example.webproject.data.models.db.entity.Category;
import com.example.webproject.data.remotes.repositories.CategoryRepository;
import com.example.webproject.data.remotes.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/category")
public class ACategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("/add_category")
    private ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        service.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

}
