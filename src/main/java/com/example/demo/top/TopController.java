package com.example.demo.top;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Goods;

import lombok.RequiredArgsConstructor;

/**
 * トップ画面コントローラ
 */
@Controller
@RequiredArgsConstructor
public class TopController {

    /** goods検索サービス */
    private final GoodsFindService goodsFindService;

    /**
     * トップ画面表示する。goodsを全件表示する
     * @param model Model
     * @return top画面
     */
    @GetMapping("/")
    public String top(Model model) {
        // goods検索サービスから、全件取得する
        List<Goods> goodsList = goodsFindService.findGoodss();
        // 取得した結果を設定する
        model.addAttribute("goodsList", goodsList);
        // トップ画面を表示する
        return "top/index";
    }
}
