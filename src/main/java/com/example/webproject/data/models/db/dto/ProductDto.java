package com.example.webproject.data.models.db.dto;

import com.example.webproject.data.models.db.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private Long productId;
    private String productName;
    private String productContent;
    private double productPrice;
    private double productDiscount;
    private double productNewPrice;
    private Set<ImageDto> images;
    private Set<RateDto> rates;
    private Bill bill;

}
