package com.example.demo.entity;

import lombok.Data;

/**
 * goodsエンティティ
 * 
 * Tips
 * `@Data`がlombokのアノテーションで、setter,getterをclassファイルに対して自動生成してくれる。
 */
@Data
public class Goods {
    private Integer id;
    private String goodsName;
    private Integer price;
}
