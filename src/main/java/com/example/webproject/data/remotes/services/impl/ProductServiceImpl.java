package com.example.webproject.data.remotes.services.impl;

import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.repositories.ProductRepository;
import com.example.webproject.data.remotes.services.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<Product> findAllById(Iterable<Long> longs) {
        return repository.findAllById(longs);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Product> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {
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
    public Product getOne(Long aLong) {
        return repository.getOne(aLong);
    }

    @Override
    public Product getById(Long aLong) {
        return repository.getById(aLong);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
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
    public void delete(Product entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }

    @Override
    @Query(value = "SELECT * FROM tbl_product ORDER BY product_id DESC LIMIT 4", nativeQuery = true)
    public List<Product> getTop4NewProduct() {
        return repository.getTop4NewProduct();
    }

    @Override
    @Query(value = "SELECT * FROM tbl_product ORDER BY num_of_sell DESC LIMIT 1", nativeQuery = true)
    public Product getTopSellProduct() {
        return repository.getTopSellProduct();
    }

    @Override
    @Query(value = "SELECT * FROM tbl_product ORDER BY num_of_sell DESC LIMIT 4", nativeQuery = true)
    public List<Product> getTop4BestProduct() {
        return repository.getTop4BestProduct();
    }

    @Override
    @Query(value = "SELECT * FROM tbl_product ORDER BY product_id DESC LIMIT 1", nativeQuery = true)
    public Product getLastProduct() {
        return repository.getLastProduct();
    }

    @Override
    @Query(value = "SELECT * FROM tbl_product WHERE category_id = ?1", nativeQuery = true)
    public List<Product> getProductByCategoryId(Long name) {
        return repository.getProductByCategoryId(name);
    }
}
