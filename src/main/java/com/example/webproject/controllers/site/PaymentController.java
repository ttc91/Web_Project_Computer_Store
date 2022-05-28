package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.dto.ProductInCartDto;
import com.example.webproject.data.models.db.entity.*;
import com.example.webproject.data.remotes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    CartService cartService;

    @Autowired
    BillService billService;

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    ProductService productService;

    @PostMapping ("/")
    public String actionPayment(Model model, HttpSession session){

        Customer customer = (Customer)session.getAttribute("customer");
        Cart cart = cartService.findCartByCustomer(customer);
        List<CartProduct> cartProductList = cartProductService.findCartProductByCart(cart);
        List<ProductInCartDto> productInCartDtoList = new ArrayList<>();

        Double totalPriceInCart = 0.0;

        for(CartProduct item : cartProductList){

            Optional<Product> opt = productService.findById(item.getProduct().getProductId());
            Product product = opt.get();

            ProductInCartDto dto = new ProductInCartDto();
            dto.setProductId(product.getProductId());
            dto.setProductImgLink(product.getProductAvatar());
            dto.setProductName(product.getProductName());
            DecimalFormat df = new DecimalFormat("#,###.00");
            dto.setTotalPrice(df.format(BigDecimal.valueOf(item.getQuantity() * product.getProductPrice())));
            dto.setTotalPriceDouble(item.getQuantity() * product.getProductPrice());
            dto.setQuantity(item.getQuantity());

            productInCartDtoList.add(dto);
            cartProductService.delete(item);

            totalPriceInCart += item.getQuantity() * product.getProductPrice();
        }


        Date date = new Date();
        date.getTime();

        Bill bill = new Bill();
        bill.setCustomer(customer);
        bill.setDateOfPayment(date);
        bill.setTotalAmount(BigDecimal.valueOf(totalPriceInCart));

        billService.save(bill);

        bill = billService.findNewBillIdByCustomerId(customer.getCustomerId());
        BillDetailKey key = new BillDetailKey();
        for(ProductInCartDto item : productInCartDtoList){

            BillDetail detail = new BillDetail();

            key.setProductId(item.getProductId());
            key.setBillId(bill.getBillId());

            detail.setId(key);
            detail.setCustomer(customer);
            detail.setQuantity(item.getQuantity());

            detail.setPrice(BigDecimal.valueOf(item.getTotalPriceDouble()));
            detail.setBill(bill);

            Optional<Product> opt = productService.findById(item.getProductId());
            Product product = opt.get();

            detail.setProduct(product);

            billDetailService.save(detail);

        }

        List<Product> productList = productService.getTop4NewProduct();
        model.addAttribute("products", productList);

        Product topSellProduct = productService.getTopSellProduct();
        model.addAttribute("topSellProduct", topSellProduct);

        List<Product> productBestList = productService.getTop4BestProduct();
        model.addAttribute("productsBest", productBestList);

        model.addAttribute("checkLogin", true);
        model.addAttribute("customer", customer);

        return "redirect:/";
    }

}
