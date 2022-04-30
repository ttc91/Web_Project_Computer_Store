package com.example.webproject.data.models.db.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @Length(max = 1000)
    private String productContent;

    @NotNull
    private double productPrice;

    private Long numOfSell;

    @NotEmpty
    private String productAvatar;

    @Value("0.0")
    private double productDiscount;

    private double productNewPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Rate> rates;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<CartProduct> cartProducts;

}
