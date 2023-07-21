package com.example.demo.entity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Goodsマッパー
 * MyBatisを使って、SQLを発行する
 */
@Mapper
public interface GoodsMapper {

    /**
     * goodsを全件取得する
     * @return goodsリスト
     */
    @Select("select * from goods") // SQLをXMLではなく、アノテーションで実装することもできる。
    List<Goods> select();

    /**
     * goodsをインサートする
     * @param comoddity Goods
     */
    @Insert("insert into goods(id, goods_name, price) values(#{id}, #{goodsName}, #{price})") // SQLが長くなるならXMLでも実装可能
    void regist(Goods goods);

}
