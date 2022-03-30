package com.example.webproject.data.models.db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDto implements Serializable {

    private Long adsId;
    private String linkImg;
    private String adsContents;

}
