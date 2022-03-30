package com.example.webproject.data.models.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartProductKey implements Serializable {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id", columnDefinition = "int default 1")
    private Long productId;

}
