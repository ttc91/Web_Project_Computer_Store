package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Category;
import com.example.webproject.data.remotes.repositories.CategoryRepository;
import com.example.webproject.data.remotes.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String getCategoryPage(Model model) {

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        return "category";
    }

}
