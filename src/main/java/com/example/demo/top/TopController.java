package com.example.demo.top;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;

/**
 * トップ画面コントローラ
 */
@Controller
public class TopController {

    @Autowired
    ItemFindService itemFindService;

    /**
     * トップ画面表示する。itemを全件表示する
     * @param model Model
     * @return top画面
     */
    @GetMapping("/")
    public String top(Model model) {
        List<Item> itemList = itemFindService.findItems();
        model.addAttribute("itemList", itemList);
        return "top/index";
    }
}
