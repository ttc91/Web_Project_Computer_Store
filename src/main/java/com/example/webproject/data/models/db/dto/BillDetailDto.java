package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetailDto implements Serializable {

    private Long billDetailId;
    private Long quantity;
    private BigDecimal price;
    private BillDto bill;

}
