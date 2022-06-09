package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.CartProduct;
import com.example.webproject.data.models.db.entity.CartProductKey;
import com.example.webproject.data.models.db.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CartProductService {
    List<CartProduct> findCartProductByCart(Cart cart);

    CartProduct findCartProductByCartAndProduct(Cart cart, Product product);

    List<CartProduct> findAll();

    List<CartProduct> findAll(Sort sort);

    List<CartProduct> findAllById(Iterable<CartProductKey> cartProductKeys);

    <S extends CartProduct> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends CartProduct> S saveAndFlush(S entity);

    <S extends CartProduct> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<CartProduct> entities);

    void deleteAllInBatch(Iterable<CartProduct> entities);

    void deleteAllByIdInBatch(Iterable<CartProductKey> cartProductKeys);

    void deleteAllInBatch();

    @Deprecated
    CartProduct getOne(CartProductKey cartProductKey);

    CartProduct getById(CartProductKey cartProductKey);

    <S extends CartProduct> List<S> findAll(Example<S> example);

    <S extends CartProduct> List<S> findAll(Example<S> example, Sort sort);

    Page<CartProduct> findAll(Pageable pageable);

    <S extends CartProduct> S save(S entity);

    Optional<CartProduct> findById(CartProductKey cartProductKey);

    boolean existsById(CartProductKey cartProductKey);

    long count();

    void deleteById(CartProductKey cartProductKey);

    void delete(CartProduct entity);

    void deleteAllById(Iterable<? extends CartProductKey> cartProductKeys);

    void deleteAll(Iterable<? extends CartProduct> entities);

    void deleteAll();

    <S extends CartProduct> Optional<S> findOne(Example<S> example);

    <S extends CartProduct> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends CartProduct> long count(Example<S> example);

    <S extends CartProduct> boolean exists(Example<S> example);

    <S extends CartProduct, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Long countCartProductByCart(Cart cart);

    void deleteCartProductByProductAndAndCart(Product product, Cart cart);

    void deleteByProduct(Product product);
}
