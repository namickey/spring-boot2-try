package com.example.demo.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;

@Controller
public class TopController {

    @Autowired
    ItemFindService itemFindService;

    @GetMapping("/")
    public String top(Model model) {
        List<Item> itemList = itemFindService.findItems();
        model.addAttribute("itemList", itemList);
        return "top/index";
    }
}
