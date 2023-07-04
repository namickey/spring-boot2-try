package com.example.demo.entity;

import lombok.Data;

/**
 * itemエンティティ
 * 
 * Tips
 * `@Data`がlombokのアノテーションで、setter,getterをclassファイルに対して自動生成してくれる。
 */
@Data
public class Item {
    private Integer id;
    private String itemName;
    private Integer price;
}
