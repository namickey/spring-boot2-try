package com.example.demo.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Itemマッパー
 */
@Mapper
public interface ItemMapper {

    /**
     * itemを全件取得する
     * @return itemリスト
     */
    @Select("select * from item")
    List<Item> select();

    /**
     * itemをインサートする
     * @param item Item
     */
    @Insert("insert into item(id, item_name, price) values(#{id}, #{itemName}, #{price})")
    void regist(Item item);
}
