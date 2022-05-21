package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.Bill;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BillService {
    @Query(value = "SELECT * FROM tbl_bill WHERE customer_id = ?1 ORDER BY bill_id ASC LIMIT 1", nativeQuery = true)
    Bill findNewBillIdByCustomerId(Long customerId);

    List<Bill> findAll();

    List<Bill> findAll(Sort sort);

    List<Bill> findAllById(Iterable<Long> longs);

    <S extends Bill> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Bill> S saveAndFlush(S entity);

    <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Bill> entities);

    void deleteAllInBatch(Iterable<Bill> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Bill getOne(Long aLong);

    Bill getById(Long aLong);

    <S extends Bill> List<S> findAll(Example<S> example);

    <S extends Bill> List<S> findAll(Example<S> example, Sort sort);

    Page<Bill> findAll(Pageable pageable);

    <S extends Bill> S save(S entity);

    Optional<Bill> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Bill entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Bill> entities);

    void deleteAll();

    <S extends Bill> Optional<S> findOne(Example<S> example);

    <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Bill> long count(Example<S> example);

    <S extends Bill> boolean exists(Example<S> example);

    <S extends Bill, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
