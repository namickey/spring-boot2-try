package com.example.demo.regist;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Goods;
import com.example.demo.entity.GoodsMapper;

import lombok.RequiredArgsConstructor;

/**
 * goods登録サービス
 * 
 * Tips アプリケーションレイヤーの考え方
 * サービスクラス内では、フォームクラスは使用しない。import禁止。
 * フォームクラスは必ず、Dtoクラスやエンティティクラスに移し替えてからサービスクラスに渡す。
 * サービスクラスに業務ロジックを実装する。
 */
@Service
@RequiredArgsConstructor
public class GoodsRegistService {
    
    /** goodsマッパー */
    private final GoodsMapper goodsMapper;

    /**
     * goodsを登録する
     * @param goods Goods
     */
    public void registGoods(Goods goods) {
        
        // Tips
        // Goodsクラスにsetter,getterは実装していないが「goods.getGoodsName()」のビルドができる。
        // Lombokの機能で「@Data」アノテーションをGoodsクラスに付けることでsetter,getterがclassファイルとして生成されている。
        System.out.println(goods.getGoodsName());


        // 未実装
        // 業務処理を実装する。例：今回登録する内容とDBに登録済みの内容を比較して、結果によってエラーとする等。


        // DBへ登録する
        goodsMapper.regist(goods);
    }
}
