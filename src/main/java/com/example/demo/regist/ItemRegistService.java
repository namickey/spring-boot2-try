package com.example.demo.regist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

/**
 * item登録サービス
 */
@Service
public class ItemRegistService {
    
    @Autowired
    ItemMapper itemMapper;

    /**
     * itemを登録する
     * @param item Item
     */
    public void registItem(Item item) {
        itemMapper.regist(item);
    }
}
