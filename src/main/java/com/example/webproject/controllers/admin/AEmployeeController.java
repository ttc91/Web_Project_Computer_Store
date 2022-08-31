package com.example.webproject.controllers.admin;

import com.example.webproject.data.models.db.entity.Employee;
import com.example.webproject.data.remotes.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("admin/employee")
public class AEmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        service.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


}
