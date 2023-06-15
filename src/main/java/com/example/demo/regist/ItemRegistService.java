package com.example.demo.regist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

@Service
public class ItemRegistService {
    
    @Autowired
    ItemMapper itemMapper;

    public void registItem(Item item) {
        itemMapper.regist(item);
    }
}
