package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPassword;
    private String customerPhoneNumber;
    private Set<BillDto> bill;

}
