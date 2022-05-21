package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.CartProduct;
import com.example.webproject.data.models.db.entity.CartProductKey;
import com.example.webproject.data.models.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, CartProductKey> {

    public List<CartProduct> findCartProductByCart(Cart cart);
    public CartProduct findCartProductByCartAndProduct(Cart cart, Product product);
    public Long countCartProductByCart(Cart cart);
    public void deleteCartProductByProductAndAndCart(Product product, Cart cart);
}
