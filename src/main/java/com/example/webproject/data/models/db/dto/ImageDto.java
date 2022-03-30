package com.example.webproject.data.models.db.dto;

import com.example.webproject.data.models.db.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageDto implements Serializable {

    private Long imageId;
    private String imageLink;
    private ProductDto product;

}
