package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.CartProduct;
import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.services.CartProductService;
import com.example.webproject.data.remotes.services.CartService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    CartService cartService;

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {

        Customer customer = (Customer)session.getAttribute("customer");
        if(customer != null){
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);

            Cart cart = cartService.findCartByCustomer(customer);
            Long numOfProductInCart = cartProductService.countCartProductByCart(cart);
            model.addAttribute("numOfProductInCart", numOfProductInCart);

        }else {
            model.addAttribute("checkLogin", false);
            model.addAttribute("numOfProductInCart", 0);
        }

        List<Product> productList = productService.getTop4NewProduct();
        model.addAttribute("products", productList);

        Product topSellProduct = productService.getTopSellProduct();
        model.addAttribute("topSellProduct", topSellProduct);

        List<Product> productBestList = productService.getTop4BestProduct();
        model.addAttribute("productsBest", productBestList);


        return "index";
    }





}
