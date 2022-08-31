package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.dto.ProductDto;
import com.example.webproject.data.models.db.entity.Category;
import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.CartProductService;
import com.example.webproject.data.remotes.services.CartService;
import com.example.webproject.data.remotes.services.CategoryService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String navigateProductPage(Model model, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> productList = productService.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
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
    public ModelAndView navigateProductPageByCategory(ModelMap model, @RequestParam("c_id") Integer id, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        Long c_id = Long.valueOf(id);

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> productList = productService.getProductByCategoryId(c_id);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
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
    public ModelAndView navigateProductPageBySearchString(ModelMap model, @RequestParam(value = "char", required = false) String productChar, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);

        List<Product> productList = productService.getProductByProductChar(productChar);
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
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
    public ModelAndView navigateProductDetail(ModelMap model, @RequestParam("p_id") Long id, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            Boolean checkLogin = true;
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        Optional<Product> opt = productService.findById(id);
        if (opt.isPresent()) {
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

    @RequestMapping("/management")
    public ModelAndView navigateToProductManagement(ModelMap model, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);

        return new ModelAndView("management", model);

    }

    @PostMapping("/management_update")
    @ResponseBody
    public ModelAndView navigateToUpdateProduct(ModelMap model, @RequestParam("p_img_link") String productAvatar,
                                                @RequestParam("p_name") String productName, @RequestParam("p_content") String productContent,
                                                @RequestParam("p_price") double productPrice, @RequestParam("p_id") Long productId) {

        Optional<Product> opt = productService.findById(productId);
        if (opt != null) {

            if (productName.length() < 5) {
                model.addAttribute("check", true);
                return new ModelAndView("redirect:/product/management/", model);
            }

            Product product = opt.get();
            product.setProductAvatar(productAvatar);
            product.setProductName(productName);
            product.setProductContent(productContent);
            product.setProductPrice(productPrice);
            productService.save(product);
        }
        model.addAttribute("check", false);
        return new ModelAndView("redirect:/product/management/", model);
    }

    @PostMapping("/management_delete")
    @ResponseBody
    public ModelAndView navigateToDeleteProduct(ModelMap model, @RequestParam("p_id") Long productId) {

        Optional<Product> opt = productService.findById(productId);
        if (opt != null) {
            Product product = opt.get();
            productService.delete(product);
        }

        model.addAttribute("check", false);
        return new ModelAndView("redirect:/product/management/", model);
    }

    @RequestMapping("/management_insert_form")
    public ModelAndView navigateToInsertProductForm(ModelMap model) {
        model.addAttribute("check", true);
        model.addAttribute("check_content", true);
        return new ModelAndView("insert_product", model);
    }

    @PostMapping("/management_insert")
    @ResponseBody
    public ModelAndView navigateToInsertProduct(ModelMap model, @RequestParam("p_img_link") String productAvatar,
                                                @RequestParam("p_name") String productName, @RequestParam("p_content") String productContent,
                                                @RequestParam("p_price") Double productPrice) {


        Category category = categoryService.getById(Long.valueOf(1));

        if (productAvatar.length() > 0 && productName.length() > 0 && productContent.length() > 0 && productPrice != 0.0) {
            if (productName.length() > 5 && productContent.length() > 5) {
                Product product = new Product();
                product.setProductAvatar(productAvatar);
                product.setProductName(productName);
                product.setCategory(category);
                product.setNumOfSell(Long.valueOf(0));
                product.setProductDiscount(0.0);
                product.setProductNewPrice(productPrice);
                product.setProductPrice(productPrice);
                product.setProductContent(productContent);
                productService.save(product);

                model.addAttribute("check", false);
                return new ModelAndView("redirect:/product/management/", model);
            }

            model.addAttribute("check", false);
            model.addAttribute("check_content", true);
            return new ModelAndView("insert_product", model);
        }

        model.addAttribute("check", true);
        model.addAttribute("check_content", false);
        return new ModelAndView("insert_product", model);


    }


}
