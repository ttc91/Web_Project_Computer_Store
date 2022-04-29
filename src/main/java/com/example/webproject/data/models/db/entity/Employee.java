package com.example.webproject.data.models.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "name", length = 50, columnDefinition = "nvarchar(50) not null", nullable = false)
    private String employeeName;

    @Column(nullable = false)
    @Value("0")
    private Long isAdmin;

    @Column(length = 50, columnDefinition = "nvarchar(50) not null", nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date birthday;

}
