package com.example.demo.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Itemマッパー
 * MyBatisを使って、SQLを発行する
 */
@Mapper
public interface ItemMapper {

    /**
     * itemを全件取得する
     * @return itemリスト
     */
    @Select("select * from item") // SQLをXMLではなく、アノテーションで実装することもできる。
    List<Item> select();

    /**
     * itemをインサートする
     * @param item Item
     */
    @Insert("insert into item(id, item_name, price) values(#{id}, #{itemName}, #{price})") // SQLが長くなるならXMLでも実装可能
    void regist(Item item);
}
