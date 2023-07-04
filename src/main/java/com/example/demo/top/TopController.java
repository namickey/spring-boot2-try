package com.example.demo.top;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;

import lombok.RequiredArgsConstructor;

/**
 * トップ画面コントローラ
 */
@Controller
@RequiredArgsConstructor
public class TopController {

    /** item検索サービス */
    private final ItemFindService itemFindService;

    /**
     * トップ画面表示する。itemを全件表示する
     * @param model Model
     * @return top画面
     */
    @GetMapping("/")
    public String top(Model model) {
        // item検索サービスから、全件取得する
        List<Item> itemList = itemFindService.findItems();
        // 取得した結果を設定する
        model.addAttribute("itemList", itemList);
        // トップ画面を表示する
        return "top/index";
    }
}
