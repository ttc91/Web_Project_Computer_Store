package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.dto.ProductDto;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productList){
            ProductDto dto = new ProductDto();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setProductContent(product.getProductContent());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setProductPriceFormat(df.format(BigDecimal.valueOf(product.getProductPrice())));

            dto.setProductAvatar(product.getProductAvatar());
            dto.setCategory(product.getCategory());
            productDtoList.add(dto);
        }

        model.addAttribute("products", productDtoList);

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

        List<Product> productList = productService.getProductByCategoryId(c_id);
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productList){
            ProductDto dto = new ProductDto();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setProductContent(product.getProductContent());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setProductPriceFormat(df.format(BigDecimal.valueOf(product.getProductPrice())));

            dto.setProductAvatar(product.getProductAvatar());
            dto.setCategory(product.getCategory());
            productDtoList.add(dto);
        }
        model.addAttribute("products", productDtoList);

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
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productList){
            ProductDto dto = new ProductDto();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setProductContent(product.getProductContent());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setProductPriceFormat(df.format(BigDecimal.valueOf(product.getProductPrice())));

            dto.setProductAvatar(product.getProductAvatar());
            dto.setCategory(product.getCategory());
            productDtoList.add(dto);
        }
        model.addAttribute("products", productDtoList);

        Product lastProduct = productService.getLastProduct();
        model.addAttribute("lastProduct", lastProduct);

        model.addAttribute("productContent", "Kết quả tìm kiếm sản phẩm");

        return new ModelAndView("category", model);
    }

    @RequestMapping("")
    public ModelAndView navigateProductDetail(ModelMap model,@RequestParam("p_id") Long id, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null){
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        }else {
            model.addAttribute("checkLogin", false);
        }

        Optional<Product> opt = productService.findById(id);
        if(opt.isPresent()){
            Product product = opt.get();

            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductContent(product.getProductContent());

            DecimalFormat df = new DecimalFormat("#,###.00");
            productDto.setProductPriceFormat(df.format(BigDecimal.valueOf(product.getProductPrice())));

            productDto.setProductAvatar(product.getProductAvatar());
            productDto.setCategory(product.getCategory());

            model.addAttribute("product", productDto);

            Category category = product.getCategory();
            model.addAttribute("category", category);
        }

        System.out.println(id);

        return new ModelAndView("product", model);
    }

}
