package com.example.webproject.data.remotes.services.impl;

import com.example.webproject.data.models.db.entity.Bill;
import com.example.webproject.data.remotes.repositories.BillRepository;
import com.example.webproject.data.remotes.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository repository;

    @Override
    @Query(value = "SELECT * FROM tbl_bill WHERE customer_id = ?1 ORDER BY bill_id ASC LIMIT 1", nativeQuery = true)
    public Bill findNewBillIdByCustomerId(Long customerId) {
        return repository.findNewBillIdByCustomerId(customerId);
    }

    @Override
    public List<Bill> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Bill> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<Bill> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    @Override
    public <S extends Bill> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends Bill> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Bill> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Bill> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        repository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Bill getOne(Long aLong) {
        return repository.getOne(aLong);
    }

    @Override
    public Bill getById(Long aLong) {
        return repository.getById(aLong);
    }

    @Override
    public <S extends Bill> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends Bill> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public <S extends Bill> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Bill> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return repository.existsById(aLong);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public void delete(Bill entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Bill> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends Bill> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public <S extends Bill> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends Bill> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public <S extends Bill, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }
}
