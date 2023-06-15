package com.example.demo.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

@Service
public class ItemFindService {
    
    @Autowired
    private ItemMapper itemMapper;

    public List<Item> findItems() {
        return itemMapper.select();
    }
}
