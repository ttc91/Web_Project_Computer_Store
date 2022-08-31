package com.example.webproject.controllers.site;

import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.remotes.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping("/")
    public String navigateToRegisterPage() {
        return "register";
    }

    @PostMapping("/sign_up")
    @ResponseBody
    public ModelAndView signupCustomer(ModelMap model, @RequestParam("phone") String phone,
                                       @RequestParam("username") String username, @RequestParam("pwd_1") String pwd_1,
                                       @RequestParam("pwd_2") String pwd_2, @RequestParam("address") String address) {


        if (pwd_1.equals(pwd_2)) {
            Customer customer = new Customer();
            customer.setCustomerAddress(address);
            customer.setCustomerName(username);
            customer.setCustomerPhoneNumber(phone);

            String encode = encoder.encode(pwd_1);
            customer.setCustomerPassword(encode);

            customerService.save(customer);

            Boolean check = false;
            Boolean checkSignUp = true;

            model.addAttribute("check", check);
            model.addAttribute("checkSignUp", checkSignUp);

            return new ModelAndView("register", model);
        }

        Boolean check = true;
        Boolean checkSignUp = false;

        model.addAttribute("check", check);
        model.addAttribute("checkSignUp", checkSignUp);

        return new ModelAndView("register", model);
        //return "register";

    }

}
