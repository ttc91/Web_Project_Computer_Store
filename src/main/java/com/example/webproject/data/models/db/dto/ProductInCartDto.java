package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductInCartDto implements Serializable {

    private Long productId;
    private String productImgLink;
    private String productName;
    private Long quantity;
    private Double totalPrice;

}
