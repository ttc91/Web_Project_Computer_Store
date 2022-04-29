package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAll(Sort sort);

    List<Product> findAllById(Iterable<Long> longs);

    <S extends Product> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Product> S saveAndFlush(S entity);

    <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Product> entities);

    void deleteAllInBatch(Iterable<Product> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Product getOne(Long aLong);

    Product getById(Long aLong);

    <S extends Product> List<S> findAll(Example<S> example);

    <S extends Product> List<S> findAll(Example<S> example, Sort sort);

    Page<Product> findAll(Pageable pageable);

    <S extends Product> S save(S entity);

    Optional<Product> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Product entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Product> entities);

    void deleteAll();

    <S extends Product> Optional<S> findOne(Example<S> example);

    <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Product> long count(Example<S> example);

    <S extends Product> boolean exists(Example<S> example);

    <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
