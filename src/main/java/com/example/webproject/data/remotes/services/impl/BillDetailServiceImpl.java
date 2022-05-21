package com.example.webproject.data.remotes.services.impl;

import com.example.webproject.data.models.db.entity.BillDetail;
import com.example.webproject.data.models.db.entity.BillDetailKey;
import com.example.webproject.data.remotes.repositories.BillDetailRepository;
import com.example.webproject.data.remotes.services.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    BillDetailRepository repository;

    @Override
    public List<BillDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public List<BillDetail> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<BillDetail> findAllById(Iterable<BillDetailKey> billDetailKeys) {
        return repository.findAllById(billDetailKeys);
    }

    @Override
    public <S extends BillDetail> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends BillDetail> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public <S extends BillDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<BillDetail> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<BillDetail> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<BillDetailKey> billDetailKeys) {
        repository.deleteAllByIdInBatch(billDetailKeys);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public BillDetail getOne(BillDetailKey billDetailKey) {
        return repository.getOne(billDetailKey);
    }

    @Override
    public BillDetail getById(BillDetailKey billDetailKey) {
        return repository.getById(billDetailKey);
    }

    @Override
    public <S extends BillDetail> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends BillDetail> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public Page<BillDetail> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public <S extends BillDetail> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<BillDetail> findById(BillDetailKey billDetailKey) {
        return repository.findById(billDetailKey);
    }

    @Override
    public boolean existsById(BillDetailKey billDetailKey) {
        return repository.existsById(billDetailKey);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(BillDetailKey billDetailKey) {
        repository.deleteById(billDetailKey);
    }

    @Override
    public void delete(BillDetail entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends BillDetailKey> billDetailKeys) {
        repository.deleteAllById(billDetailKeys);
    }

    @Override
    public void deleteAll(Iterable<? extends BillDetail> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends BillDetail> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public <S extends BillDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public <S extends BillDetail> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends BillDetail> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public <S extends BillDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }
}
