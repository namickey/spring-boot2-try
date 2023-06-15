package com.example.demo.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

/**
 * item検索サービス
 */
@Service
public class ItemFindService {
    
    @Autowired
    private ItemMapper itemMapper;

    /**
     * itemを全件取得する
     * @return itemリスト
     */
    public List<Item> findItems() {
        return itemMapper.select();
    }
}
