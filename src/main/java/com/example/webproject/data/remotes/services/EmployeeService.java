package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface EmployeeService {


    List<Employee> findAll();

    List<Employee> findAll(Sort sort);

    List<Employee> findAllById(Iterable<Long> longs);

    <S extends Employee> List<S> saveAll(Iterable<S> entities);

    Page<Employee> findAll(Pageable pageable);

    <S extends Employee> S save(S entity);

    Optional<Employee> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Employee entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Employee> entities);

    void deleteAll();

    <S extends Employee> Optional<S> findOne(Example<S> example);

    <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Employee> long count(Example<S> example);

    <S extends Employee> boolean exists(Example<S> example);

    <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
