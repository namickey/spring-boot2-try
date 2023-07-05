package com.example.demo.regist;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Item;

import lombok.RequiredArgsConstructor;

/*
 * 登録画面コントローラ
 * 
 * 画面遷移：表示⇒確認⇒登録⇒リダイレクト⇒完了
 */
@Controller
@RequiredArgsConstructor
public class RegistController {

    /** item登録サービス */
    private final ItemRegistService itemRegistService;

    /*
     * 表示
     */
    @GetMapping("/regist/index")
    public String index(ItemForm itemForm) {
        // 登録画面を表示する
        return "regist/regist";
    }

    /*
     * 確認
     */
    @PostMapping("/regist/confirm")
    public String confirm(ItemForm itemForm) {
        // 確認画面を表示する
        return "regist/confirm";
    }

    /*
     * 登録
     */
    @PostMapping("/regist/regist")
    public String regist(ItemForm itemForm) {

        // 入力チェックは省略

        // Tips
        // ItemFormからItemエンティティへデータをコピーする
        // 同じ名称のフィールドは自動的にコピーしてくれる。
        Item item = new Item();
        BeanUtils.copyProperties(itemForm, item);

        // 登録サービス呼び出し。引数にitemエンティティを渡す。
        itemRegistService.registItem(item);

        // リダイレクトして、GETのHTTPメソッドで、完了画面を表示する
        // 二重サブミット対策のPRGパターン（Post Redirect Get）
        return "redirect:/regist/complete";
    }

    /*
     * 完了
     */
    @GetMapping("/regist/complete")
    public String complete() {
        // 完了画面を表示する
        return "regist/complete";
    }
}
