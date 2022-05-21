package com.example.webproject.data.remotes.services.impl;

import com.example.webproject.data.models.db.entity.Cart;
import com.example.webproject.data.models.db.entity.CartProduct;
import com.example.webproject.data.models.db.entity.CartProductKey;
import com.example.webproject.data.models.db.entity.Product;
import com.example.webproject.data.remotes.repositories.CartProductRepository;
import com.example.webproject.data.remotes.services.CartProductService;
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
public class CartProductServiceImpl implements CartProductService {

    @Autowired
    CartProductRepository repository;

    @Override
    public List<CartProduct> findCartProductByCart(Cart cart) {
        return repository.findCartProductByCart(cart);
    }

    @Override
    public CartProduct findCartProductByCartAndProduct(Cart cart, Product product) {
        return repository.findCartProductByCartAndProduct(cart, product);
    }

    @Override
    public List<CartProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CartProduct> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public List<CartProduct> findAllById(Iterable<CartProductKey> cartProductKeys) {
        return repository.findAllById(cartProductKeys);
    }

    @Override
    public <S extends CartProduct> List<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends CartProduct> S saveAndFlush(S entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public <S extends CartProduct> List<S> saveAllAndFlush(Iterable<S> entities) {
        return repository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<CartProduct> entities) {
        repository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<CartProduct> entities) {
        repository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<CartProductKey> cartProductKeys) {
        repository.deleteAllByIdInBatch(cartProductKeys);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public CartProduct getOne(CartProductKey cartProductKey) {
        return repository.getOne(cartProductKey);
    }

    @Override
    public CartProduct getById(CartProductKey cartProductKey) {
        return repository.getById(cartProductKey);
    }

    @Override
    public <S extends CartProduct> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends CartProduct> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public Page<CartProduct> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public <S extends CartProduct> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CartProduct> findById(CartProductKey cartProductKey) {
        return repository.findById(cartProductKey);
    }

    @Override
    public boolean existsById(CartProductKey cartProductKey) {
        return repository.existsById(cartProductKey);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(CartProductKey cartProductKey) {
        repository.deleteById(cartProductKey);
    }

    @Override
    public void delete(CartProduct entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends CartProductKey> cartProductKeys) {
        repository.deleteAllById(cartProductKeys);
    }

    @Override
    public void deleteAll(Iterable<? extends CartProduct> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends CartProduct> Optional<S> findOne(Example<S> example) {
        return repository.findOne(example);
    }

    @Override
    public <S extends CartProduct> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public <S extends CartProduct> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends CartProduct> boolean exists(Example<S> example) {
        return repository.exists(example);
    }

    @Override
    public <S extends CartProduct, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return repository.findBy(example, queryFunction);
    }

    @Override
    public Long countCartProductByCart(Cart cart) {
        return repository.countCartProductByCart(cart);
    }

    @Override
    public void deleteCartProductByProductAndAndCart(Product product, Cart cart) {
        repository.deleteCartProductByProductAndAndCart(product, cart);
    }
}
