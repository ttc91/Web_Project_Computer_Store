package com.example.webproject.security;

import com.example.webproject.data.models.db.entity.Customer;
import com.example.webproject.data.remotes.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Customer customer = customerService.findCustomerByCustomerPhoneNumber(username);

        User.UserBuilder builder = null;

        if (customer != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(customer.getCustomerPhoneNumber());
            builder.password(customer.getCustomerPassword());

            builder.roles("USER");

        } else {
            throw new UsernameNotFoundException("User not found !");
        }


        return builder.build();
    }
}
