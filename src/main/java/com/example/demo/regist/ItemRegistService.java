package com.example.demo.regist;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemMapper;

import lombok.RequiredArgsConstructor;

/**
 * item登録サービス
 * 
 * Tips アプリケーションレイヤーの考え方
 * サービスクラス内では、フォームクラスは使用しない。import禁止。
 * フォームクラスは必ず、Dtoクラスやエンティティクラスに移し替えてからサービスクラスに渡す。
 * サービスクラスに業務ロジックを実装する。
 */
@Service
@RequiredArgsConstructor
public class ItemRegistService {
    
    /** itemマッパー */
    private final ItemMapper itemMapper;

    /**
     * itemを登録する
     * @param item Item
     */
    public void registItem(Item item) {
        
        // Tips
        // Itemクラスにsetter,getterは実装していないが「item.getItemName()」のビルドができる。
        // Lombokの機能で「@Data」アノテーションをItemクラスに付けることでsetter,getterがclassファイルとして生成されている。
        System.out.println(item.getItemName());


        // 未実装
        // 業務処理を実装する。例：今回登録する内容とDBに登録済みの内容を比較して、結果によってエラーとする等。


        // DBへ登録する
        itemMapper.regist(item);
    }
}
