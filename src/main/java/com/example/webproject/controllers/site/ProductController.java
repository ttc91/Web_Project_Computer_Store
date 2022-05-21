package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Category;
import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.CategoryService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String navigateProductPage(Model model, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null){
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        }else {
            model.addAttribute("checkLogin", false);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);

        Product lastProduct = productService.getLastProduct();
        model.addAttribute("lastProduct", lastProduct);

        model.addAttribute("productContent", "Toàn bộ sản phẩm");

        return "category";
    }

    @GetMapping("/category")
    public ModelAndView navigateProductPageByCategory(ModelMap model, @RequestParam("c_id") Integer id, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null){
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        }else {
            model.addAttribute("checkLogin", false);
        }

        Long c_id = Long.valueOf(id);

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> getProductsByC_Id = productService.getProductByCategoryId(c_id);
        model.addAttribute("products", getProductsByC_Id);

        Product lastProduct = productService.getLastProduct();
        model.addAttribute("lastProduct", lastProduct);

        Category category = categoryService.getById(c_id);
        model.addAttribute("productContent", category.getCategoryName());

        return new ModelAndView("category", model);
    }

    @RequestMapping("/search")
    public ModelAndView navigateProductPageBySearchString(ModelMap model, @RequestParam(value = "char", required = false) String productChar, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null){
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        }else {
            model.addAttribute("checkLogin", false);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> productList = productService.getProductByProductChar(productChar);
        model.addAttribute("products", productList);

        Product lastProduct = productService.getLastProduct();
        model.addAttribute("lastProduct", lastProduct);

        model.addAttribute("productContent", "Kết quả tìm kiếm sản phẩm");

        return new ModelAndView("category", model);
    }

    @RequestMapping("")
    public ModelAndView navigateProductDetail(ModelMap model,@RequestParam("p_id") Long id){

        Optional<Product> opt = productService.findById(id);
        if(opt.isPresent()){
            Product product = opt.get();
            model.addAttribute("product", product);

            Category category = product.getCategory();
            model.addAttribute("category", category);
        }

        System.out.println(id);

        return new ModelAndView("product", model);
    }

}
