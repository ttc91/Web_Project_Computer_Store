package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Serializable {

    private Long employeeId;
    private String employeeName;
    private Long isAdmin;
    private String userName;
    private String password;
    private Date birthday;

}
