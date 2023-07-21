package com.example.demo.regist;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Goods;

import lombok.RequiredArgsConstructor;

/*
 * 登録画面コントローラ
 * 
 * 画面遷移：表示⇒確認⇒登録⇒リダイレクト⇒完了
 */
@Controller
@RequiredArgsConstructor
public class RegistController {

    /** goods登録サービス */
    private final GoodsRegistService goodsRegistService;

    /*
     * 表示
     */
    @GetMapping("/regist/index")
    public String index(GoodsForm goodsForm) {
        // 登録画面を表示する
        return "regist/regist";
    }

    /*
     * 確認
     */
    @PostMapping("/regist/confirm")
    public String confirm(GoodsForm goodsForm) {
        // 確認画面を表示する
        return "regist/confirm";
    }

    /*
     * 登録
     */
    @PostMapping("/regist/regist")
    public String regist(GoodsForm goodsForm) {

        // 入力チェックは省略

        // Tips
        // GoodsFormからGoodsエンティティへデータをコピーする
        // 同じ名称のフィールドは自動的にコピーしてくれる。
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsForm, goods);

        // 登録サービス呼び出し。引数にgoodsエンティティを渡す。
        goodsRegistService.registGoods(goods);

        // リダイレクトして、GETのHTTPメソッドで、完了画面を表示する
        // 二重サブミット対策のPRGパターン（Post Redirect Get）
        return "redirect:/regist/complete";
    }

    /*
     * 登録完了
     */
    @GetMapping("/regist/complete")
    public String registComplete() {
        // 完了画面を表示する
        return "regist/complete";
    }
}
