package com.example.webproject.data.models.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_rate")
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateId;

    private Long avgStart;

    @Column(length = 200, columnDefinition = "nvarchar(200)")
    private String contentRate;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;

}
