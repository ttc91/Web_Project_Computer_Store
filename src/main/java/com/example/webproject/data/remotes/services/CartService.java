package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CartService {


    List<Cart> findAll();

    List<Cart> findAll(Sort sort);

    List<Cart> findAllById(Iterable<Long> longs);

    <S extends Cart> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Cart> S saveAndFlush(S entity);

    <S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Cart> entities);

    void deleteAllInBatch(Iterable<Cart> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Cart getOne(Long aLong);

    Cart getById(Long aLong);

    <S extends Cart> List<S> findAll(Example<S> example);

    <S extends Cart> List<S> findAll(Example<S> example, Sort sort);

    Page<Cart> findAll(Pageable pageable);

    <S extends Cart> S save(S entity);

    Optional<Cart> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Cart entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Cart> entities);

    void deleteAll();

    <S extends Cart> Optional<S> findOne(Example<S> example);

    <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Cart> long count(Example<S> example);

    <S extends Cart> boolean exists(Example<S> example);

    <S extends Cart, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Cart findCartByCustomer(Customer customer);
}
