package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findCustomerByCustomerPhoneNumberAndCustomerPassword(Long phone, String pwd);

    public Customer findCustomerByCustomerPhoneNumber(String phone);

}
