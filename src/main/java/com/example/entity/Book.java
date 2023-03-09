package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : jinye
 * @date : 2023/3/1 13:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;

    private String type;

    private String name;

    private String description;

}
