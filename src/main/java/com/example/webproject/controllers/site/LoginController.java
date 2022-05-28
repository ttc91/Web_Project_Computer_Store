package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.CustomerService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView navigateToLoginForm(ModelMap model){

        model.addAttribute("check", true);

        return new ModelAndView("login", model);
    }

    @RequestMapping("")
    public ModelAndView navigateToLoginFormWhenFail(ModelMap model, @RequestParam("success") String value, Authentication authentication, HttpServletRequest request){

        Boolean check = Boolean.valueOf(value);

        if(check){
            String username = authentication.getName();
            Customer customer = customerService.findCustomerByCustomerPhoneNumber(username);
            request.getSession().setAttribute("customer", customer);
            model.addAttribute("customer", customer);

            List<Product> productList = productService.getTop4NewProduct();
            model.addAttribute("products", productList);

            Product topSellProduct = productService.getTopSellProduct();
            model.addAttribute("topSellProduct", topSellProduct);

            List<Product> productBestList = productService.getTop4BestProduct();
            model.addAttribute("productsBest", productBestList);

            model.addAttribute("checkLogin", true);

            return new ModelAndView("index", model);
        }

        model.addAttribute("check", check);

        return new ModelAndView("login", model);
    }




}
