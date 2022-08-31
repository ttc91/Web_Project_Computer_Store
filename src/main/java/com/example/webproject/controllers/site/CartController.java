package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.dto.ProductInCartDto;
import com.example.webproject.data.models.db.entity.*;
import com.example.webproject.data.remotes.services.CartProductService;
import com.example.webproject.data.remotes.services.CartService;
import com.example.webproject.data.remotes.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public ModelAndView navigateCartPage(ModelMap model, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);
        } else {
            model.addAttribute("checkLogin", false);
        }

        Cart cart = cartService.findCartByCustomer(customer);

        List<CartProduct> cartProducts = cartProductService.findCartProductByCart(cart);
        List<ProductInCartDto> productInCartDtoList = new ArrayList<>();

        Double totalPriceInCart = 0.0;

        for (CartProduct item : cartProducts) {

            Optional<Product> opt = productService.findById(item.getProduct().getProductId());
            Product product = opt.get();

            ProductInCartDto dto = new ProductInCartDto();
            dto.setProductId(product.getProductId());
            dto.setProductImgLink(product.getProductAvatar());
            dto.setProductName(product.getProductName());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setTotalPrice(df.format(BigDecimal.valueOf(item.getQuantity() * product.getProductPrice())));
            dto.setQuantity(item.getQuantity());

            productInCartDtoList.add(dto);

            totalPriceInCart += item.getQuantity() * product.getProductPrice();
        }

        DecimalFormat df = new DecimalFormat("#,###.00");
        String format = df.format(totalPriceInCart);

        model.addAttribute("productInCarts", productInCartDtoList);
        model.addAttribute("totalPriceInCart", format);

        return new ModelAndView("cart", model);
    }

    @RequestMapping("/add")
    public String actionAddToCart(Model model, @RequestParam("p_id") Long productId, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartService.findCartByCustomer(customer);


        if (cart != null) {

            Product product = new Product();
            Optional<Product> opt = productService.findById(productId);

            if (opt.isPresent()) {
                product = opt.get();
            }

            CartProduct cartProduct = cartProductService.findCartProductByCartAndProduct(cart, product);
            if (cartProduct != null) {
                Long quantity = cartProduct.getQuantity();
                cartProduct.setQuantity(quantity + 1);
                cartProductService.save(cartProduct);
            } else {
                cartProduct = new CartProduct();

                CartProductKey cartProductKey = new CartProductKey();
                cartProductKey.setCartId(cart.getCartId());
                cartProductKey.setProductId(product.getProductId());

                cartProduct.setId(cartProductKey);
                cartProduct.setCart(cart);
                cartProduct.setProduct(product);
                cartProduct.setQuantity(Long.valueOf(1));
                cartProductService.save(cartProduct);
            }

        } else {
            cart = new Cart();
            cartService.save(cart);

            cart.setCustomer(customer);
            cartService.save(cart);

            Product product = new Product();
            Optional<Product> opt = productService.findById(productId);

            if (opt.isPresent()) {
                product = opt.get();
            }

            CartProduct cartProduct = new CartProduct();
            cartProductService.save(cartProduct);

            cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setProduct(product);
            cartProduct.setQuantity(Long.valueOf(1));
            cartProductService.save(cartProduct);
        }

        customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);

            cart = cartService.findCartByCustomer(customer);
            Long numOfProductInCart = cartProductService.countCartProductByCart(cart);
            model.addAttribute("numOfProductInCart", numOfProductInCart);

        } else {
            model.addAttribute("checkLogin", false);
            model.addAttribute("numOfProductInCart", 0);
        }

        List<Product> productList = productService.getTop4NewProduct();
        model.addAttribute("products", productList);

        Product topSellProduct = productService.getTopSellProduct();
        model.addAttribute("topSellProduct", topSellProduct);

        List<Product> productBestList = productService.getTop4BestProduct();
        model.addAttribute("productsBest", productBestList);

        if (customer != null) {
            System.out.println(customer.getCustomerName());
        }

        return "redirect:/";
    }

    @PostMapping("/delete")
    public ModelAndView actionDeleteInCart(ModelMap model, @RequestParam("p_id") Long productId, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartService.findCartByCustomer(customer);

        Optional<Product> opt = productService.findById(productId);
        Product product = opt.get();

        CartProduct pc = cartProductService.findCartProductByCartAndProduct(cart, product);
        cartProductService.delete(pc);

        List<CartProduct> cartProducts = cartProductService.findCartProductByCart(cart);
        List<ProductInCartDto> productInCartDtoList = new ArrayList<>();

        Double totalPriceInCart = 0.0;

        for (CartProduct item : cartProducts) {

            opt = productService.findById(item.getProduct().getProductId());
            product = opt.get();

            ProductInCartDto dto = new ProductInCartDto();
            dto.setProductId(product.getProductId());
            dto.setProductImgLink(product.getProductAvatar());
            dto.setProductName(product.getProductName());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setTotalPrice(df.format(BigDecimal.valueOf(item.getQuantity() * product.getProductPrice())));
            dto.setQuantity(item.getQuantity());

            productInCartDtoList.add(dto);

            totalPriceInCart += item.getQuantity() * product.getProductPrice();
        }

        DecimalFormat df = new DecimalFormat("#,###.00");
        String format = df.format(totalPriceInCart);

        model.addAttribute("productInCarts", productInCartDtoList);
        model.addAttribute("totalPriceInCart", format);
        model.addAttribute("checkLogin", true);
        model.addAttribute("customer", customer);

        return new ModelAndView("cart", model);
    }

    @GetMapping("/update")
    public ModelAndView actionUpdateProductInCart(ModelMap model, @RequestParam("number") Long number, @RequestParam("p_id") Long productId, HttpSession session) {

        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = cartService.findCartByCustomer(customer);

        Optional<Product> opt = productService.findById(productId);
        Product product = opt.get();

        CartProduct pc = cartProductService.findCartProductByCartAndProduct(cart, product);
        pc.setQuantity(number);
        cartProductService.save(pc);

        List<CartProduct> cartProducts = cartProductService.findCartProductByCart(cart);
        List<ProductInCartDto> productInCartDtoList = new ArrayList<>();

        Double totalPriceInCart = 0.0;

        for (CartProduct item : cartProducts) {

            opt = productService.findById(item.getProduct().getProductId());
            product = opt.get();

            ProductInCartDto dto = new ProductInCartDto();
            dto.setProductId(product.getProductId());
            dto.setProductImgLink(product.getProductAvatar());
            dto.setProductName(product.getProductName());

            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setTotalPrice(df.format(BigDecimal.valueOf(item.getQuantity() * product.getProductPrice())));
            dto.setQuantity(item.getQuantity());

            productInCartDtoList.add(dto);

            totalPriceInCart += item.getQuantity() * product.getProductPrice();
        }

        DecimalFormat df = new DecimalFormat("#,###.00");
        String format = df.format(totalPriceInCart);

        model.addAttribute("productInCarts", productInCartDtoList);
        model.addAttribute("totalPriceInCart", format);
        model.addAttribute("checkLogin", true);
        model.addAttribute("customer", customer);

        return new ModelAndView("cart", model);
    }

}
