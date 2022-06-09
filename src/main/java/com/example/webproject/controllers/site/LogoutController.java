package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.CartProductService;
import com.example.webproject.data.remotes.services.CartService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public ModelAndView logOut(ModelMap model, HttpSession session){

        session.removeAttribute("customer");

        model.addAttribute("checkLogin", false);
        model.addAttribute("numOfProductInCart", 0);
        List<Product> productList = productService.getTop4NewProduct();
        model.addAttribute("products", productList);

        Product topSellProduct = productService.getTopSellProduct();
        model.addAttribute("topSellProduct", topSellProduct);

        List<Product> productBestList = productService.getTop4BestProduct();
        model.addAttribute("productsBest", productBestList);

        return new ModelAndView("forward:/", model);
    }

}
