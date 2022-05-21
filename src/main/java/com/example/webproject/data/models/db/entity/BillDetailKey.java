package com.example.webproject.data.models.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class BillDetailKey implements Serializable {

    @JoinColumn(name = "bill_id")
    private Long billId;

    @JoinColumn(name = "product_id")
    private Long productId;

}
