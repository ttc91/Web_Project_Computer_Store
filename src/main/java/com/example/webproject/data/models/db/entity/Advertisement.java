package com.example.webproject.data.models.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_advertisement")
public class Advertisement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adsId;

    @Column(nullable = false)
    private String linkImg;

    @Column(name = "content", length = 500, columnDefinition = "nvarchar(500) not null")
    private String adsContent;
}
