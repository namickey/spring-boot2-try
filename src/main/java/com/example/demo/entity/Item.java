package com.example.demo.entity;

import lombok.Data;

/**
 * itemエンティティ
 */
@Data
public class Item {
    private Integer id;
    private String itemName;
    private Integer price;
}
