package com.example.webproject.data.remotes.repositories;

import com.example.webproject.data.models.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM tbl_product ORDER BY product_id DESC LIMIT 4", nativeQuery = true)
    List<Product> getTop4NewProduct();

    @Query(value = "SELECT * FROM tbl_product ORDER BY num_of_sell DESC LIMIT 1", nativeQuery = true)
    Product getTopSellProduct();

    @Query(value = "SELECT * FROM tbl_product ORDER BY num_of_sell DESC LIMIT 4", nativeQuery = true)
    List<Product> getTop4BestProduct();

    @Query(value = "SELECT * FROM tbl_product ORDER BY product_id DESC LIMIT 1", nativeQuery = true)
    Product getLastProduct();

    @Query(value = "SELECT * FROM tbl_product WHERE category_id = ?1", nativeQuery = true)
    List<Product> getProductByCategoryId(Long name);

    @Query(value = "SELECT * FROM tbl_product WHERE product_name LIKE %?1%", nativeQuery = true)
    List<Product> getProductByProductChar(String productChar);


}
