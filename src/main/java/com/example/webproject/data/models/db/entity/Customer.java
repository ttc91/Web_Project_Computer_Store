package com.example.webproject.data.models.db.entity;

import com.example.webproject.data.models.db.entity.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(length = 50, columnDefinition = "nvarchar(50) not null")
    private String customerName;

    @Column(length = 200)
    private String customerAddress;

    @Column(length = 50, columnDefinition = "nvarchar(250) not null")
    private String customerPassword;

    @Column(length = 10, unique = true)
    private String customerPhoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Bill> bill;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<BillDetail> billDetails;

}
