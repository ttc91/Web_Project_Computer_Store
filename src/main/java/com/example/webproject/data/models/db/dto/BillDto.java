package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto implements Serializable {

    private Long billId;
    private Date dateOfPayment;
    private BigDecimal totalAmount;
    private CustomerDto customer;
    private Set<ProductDto> products;

}
