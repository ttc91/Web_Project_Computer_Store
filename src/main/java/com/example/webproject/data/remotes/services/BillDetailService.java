package com.example.webproject.data.remotes.services;

import com.example.webproject.data.models.db.entity.BillDetail;
import com.example.webproject.data.models.db.entity.BillDetailKey;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BillDetailService {
    List<BillDetail> findAll();

    List<BillDetail> findAll(Sort sort);

    List<BillDetail> findAllById(Iterable<BillDetailKey> billDetailKeys);

    <S extends BillDetail> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends BillDetail> S saveAndFlush(S entity);

    <S extends BillDetail> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<BillDetail> entities);

    void deleteAllInBatch(Iterable<BillDetail> entities);

    void deleteAllByIdInBatch(Iterable<BillDetailKey> billDetailKeys);

    void deleteAllInBatch();

    @Deprecated
    BillDetail getOne(BillDetailKey billDetailKey);

    BillDetail getById(BillDetailKey billDetailKey);

    <S extends BillDetail> List<S> findAll(Example<S> example);

    <S extends BillDetail> List<S> findAll(Example<S> example, Sort sort);

    Page<BillDetail> findAll(Pageable pageable);

    <S extends BillDetail> S save(S entity);

    Optional<BillDetail> findById(BillDetailKey billDetailKey);

    boolean existsById(BillDetailKey billDetailKey);

    long count();

    void deleteById(BillDetailKey billDetailKey);

    void delete(BillDetail entity);

    void deleteAllById(Iterable<? extends BillDetailKey> billDetailKeys);

    void deleteAll(Iterable<? extends BillDetail> entities);

    void deleteAll();

    <S extends BillDetail> Optional<S> findOne(Example<S> example);

    <S extends BillDetail> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends BillDetail> long count(Example<S> example);

    <S extends BillDetail> boolean exists(Example<S> example);

    <S extends BillDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
