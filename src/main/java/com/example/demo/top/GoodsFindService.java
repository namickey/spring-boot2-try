package com.example.demo.top;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsMapper;

import lombok.RequiredArgsConstructor;

/**
 * goods検索サービス
 */
@Service
@RequiredArgsConstructor
public class GoodsFindService {
    
    /** goodsマッパー */
    private final GoodsMapper goodsMapper;

    /**
     * goodsを全件取得する
     * @return goodsリスト
     */
    public List<Goods> findGoodss() {
        // 全件取得する
        return goodsMapper.select();
    }
}
