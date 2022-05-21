package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CustomerService {
    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    List<Customer> findAllById(Iterable<Long> longs);

    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Customer> S saveAndFlush(S entity);

    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Customer> entities);

    void deleteAllInBatch(Iterable<Customer> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Customer getOne(Long aLong);

    Customer getById(Long aLong);

    <S extends Customer> List<S> findAll(Example<S> example);

    <S extends Customer> List<S> findAll(Example<S> example, Sort sort);

    Page<Customer> findAll(Pageable pageable);

    <S extends Customer> S save(S entity);

    Optional<Customer> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Customer entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Customer> entities);

    void deleteAll();

    <S extends Customer> Optional<S> findOne(Example<S> example);

    <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Customer> long count(Example<S> example);

    <S extends Customer> boolean exists(Example<S> example);

    <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    Customer findCustomerByCustomerPhoneNumberAndCustomerPassword(Long phone, String pwd);

    Customer findCustomerByCustomerPhoneNumber(String phone);
}
