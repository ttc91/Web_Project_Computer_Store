package com.example.webproject.data.models.db.dto;

import com.example.webproject.data.models.db.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private Long productId;
    private String productName;
    private String productContent;
    private String productPriceFormat;
    private String productAvatar;
    private Long numOfSell;
    private double productDiscount;
    private double productNewPrice;
    private Category category;

}
