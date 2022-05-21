package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    public Cart findCartByCustomer(Customer customer);


}
