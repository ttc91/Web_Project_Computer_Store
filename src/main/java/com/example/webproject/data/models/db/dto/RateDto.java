package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto implements Serializable {

    private Long rateId;
    private Long avgStart;
    private String contentRate;
    private ProductDto product;

}
