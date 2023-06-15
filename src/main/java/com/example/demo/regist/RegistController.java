package com.example.demo.regist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * 登録画面コントローラ
 */
@Controller
public class RegistController {

    /*
     * 表示
     */
    @GetMapping("/regist/index")
    public String index() {
        return "regist/regist";
    }

    /*
     * 確認
     */
    @PostMapping("/regist/confirm")
    public String confirm() {
        return "regist/confirm";
    }

    /*
     * 登録
     */
    @PostMapping("/regist/regist")
    public String regist() {
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
