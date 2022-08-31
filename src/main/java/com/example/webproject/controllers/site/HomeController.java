package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.dto.ProductDto;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            model.addAttribute("checkLogin", true);
            model.addAttribute("customer", customer);

            Cart cart = cartService.findCartByCustomer(customer);
            Long numOfProductInCart = cartProductService.countCartProductByCart(cart);
            model.addAttribute("numOfProductInCart", numOfProductInCart);

        } else {
            model.addAttribute("checkLogin", false);
            model.addAttribute("numOfProductInCart", 0);
        }

        List<Product> productList = productService.getTop4NewProduct();

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

        Product topSellProduct = productService.getTopSellProduct();

        ProductDto productDto = new ProductDto();
        productDto.setProductId(topSellProduct.getProductId());
        productDto.setProductName(topSellProduct.getProductName());
        productDto.setProductContent(topSellProduct.getProductContent());

        DecimalFormat df = new DecimalFormat("#,###.00");
        productDto.setProductPriceFormat(df.format(BigDecimal.valueOf(topSellProduct.getProductPrice())));

        productDto.setProductAvatar(topSellProduct.getProductAvatar());
        productDto.setCategory(topSellProduct.getCategory());

        model.addAttribute("topSellProduct", productDto);

        List<Product> productBestList = productService.getTop4BestProduct();

        List<ProductDto> productDtoListBest = new ArrayList<>();
        for (Product product : productBestList) {
            ProductDto dto = new ProductDto();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setProductContent(product.getProductContent());

            dto.setProductPriceFormat(df.format(BigDecimal.valueOf(product.getProductPrice())));

            dto.setProductAvatar(product.getProductAvatar());
            dto.setCategory(product.getCategory());
            productDtoListBest.add(dto);
        }

        model.addAttribute("productsBest", productDtoListBest);


        return "index";
    }


}
