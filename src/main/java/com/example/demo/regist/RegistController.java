package com.example.demo.regist;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Item;

/*
 * 登録画面コントローラ
 */
@Controller
public class RegistController {

    @Autowired
    ItemRegistService itemRegistService;

    /*
     * 表示
     */
    @GetMapping("/regist/index")
    public String index(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        return "regist/regist";
    }

    /*
     * 確認
     */
    @PostMapping("/regist/confirm")
    public String confirm(@ModelAttribute ItemForm itemForm, BindingResult result) {
        return "regist/confirm";
    }

    /*
     * 登録
     */
    @PostMapping("/regist/regist")
    public String regist(@ModelAttribute ItemForm itemForm, BindingResult result) {

        // ItemFormからItemエンティティへデータコピー
        // 同じ名称のフィールドは自動的にコピーしてくれる。
        Item item = new Item();
        BeanUtils.copyProperties(itemForm, item);

        // 登録サービス呼び出し
        itemRegistService.registItem(item);

        return "redirect:/regist/complete";
    }

    /*
     * 完了
     */
    @GetMapping("/regist/complete")
    public String complete() {
        return "regist/complete";
    }
}
