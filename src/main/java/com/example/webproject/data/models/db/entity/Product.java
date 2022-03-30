package com.example.webproject.data.models.db.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    @Length(min = 5)
    private String productName;

    @NotEmpty
    private String productContent;

    @NotEmpty
    private double productPrice;

    @Value("0.0")
    private double productDiscount;

    private double productNewPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Rate> rates;

    @ManyToOne
    @JoinColumn(name = "billId")
    private Bill bill;

}
