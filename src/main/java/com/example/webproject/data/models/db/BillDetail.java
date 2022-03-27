package com.example.webproject.data.models.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_bill_detail")
public class BillDetail {

    @Id
    private Long billDetailId;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToOne
    @Column(name = "billId", nullable = false)
    private Bill bill;
}
