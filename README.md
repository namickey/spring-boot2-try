# spring-boot2-try

Spring-Bootで効率的なアプリケーション開発

## やりたいこと

* Spring-Bootを使った効率的な開発をする、起動までに必要な手順を最小化する
* javaだけがインストールされたマシンで、アプリケーションを起動する
* 起動時に自動でテーブルをcreateし、dataをインサートしてから、アプリケーションが起動する
* MyBatisというORマッパーを使う
* setter,getterは作成しない。lombokが生成してくれる
* 二重サブミット対策としてPRGパターンを使う
* Mavenを使ったライブラリ管理（自動でjarをダウンロードして、クラスパスを通してくれる）
* spring-boot-devtoolsで、アプリ起動中にソースコードを修正して保存するだけで、自動的にビルドと再起動が行われ、すぐに反映される

さいきょうの二重サブミット対策  
https://qiita.com/syobochim/items/120109315f671918f28d  

【Java】Lombokで冗長コードを削減しよう  
https://www.casleyconsulting.co.jp/blog/engineer/107/ 

## Spring-Bootとは

- 設定ファイルレス  
  あらかじめ様々な設定が設定済みとなっているため、自分で設定ファイルを書く量が少ない。  
  
- 簡単起動  
  組み込みTomcatを使用するため、Tomcatのインストールが不要。  

- 短所としては、ライフサイクルが比較的短い  
  https://spring.pleiades.io/projects/spring-boot#support

## 前提環境

以下がインストール済みであること
* JDK 11
* git

## 使用するフレームワーク

* spring-boot2.7
* spring-boot-starter-web
* spring-boot-devtools
* thymeleaf
* mybatis
* h2
* lombok
* 組み込みTomcat 9
* 組み込みMaven 3

## ディレクトリ階層

今回、起動するアプリケーションのディレクトリ階層
```
C:.
│  .gitignore
│  mvnw
│  mvnw.cmd
│  pom.xml
│  README.md
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─example
│  │  │          └─demo
│  │  │              │  DemoApplication.java
│  │  │              │  
│  │  │              ├─entity
│  │  │              │      Item.java
│  │  │              │      ItemMapper.java
│  │  │              │      
│  │  │              ├─regist
│  │  │              │      ItemForm.java
│  │  │              │      ItemRegistService.java
│  │  │              │      RegistController.java
│  │  │              │      
│  │  │              └─top
│  │  │                      ItemFindService.java
│  │  │                      TopController.java
│  │  │                      
│  │  └─resources
│  │      │  application.properties
│  │      │  data-all.sql
│  │      │  schema-all.sql
│  │      │  
│  │      ├─static
│  │      └─templates
│  │          ├─regist
│  │          │      complete.html
│  │          │      confirm.html
│  │          │      regist.html
│  │          │      
│  │          └─top
│  │                  index.html
```

## アプリケーションの構造

![アプリケーションの構造](app.png)

* Formクラスは画面層で使用するクラス
* データベース層ではFormクラスは使用しない。しっかりレイヤーを分ける。
* Entityクラスはデータベース層で使用するクラス
* 画面層ではEntityクラスは使用しないが、表示用には使用しても良い。Formという役割でEntityを使うことはダメ。
* コントローラ⇒サービス⇒マッパーのレイヤーを守って実装する。
* コントローラ⇒マッパーというようなメソッド呼び出しはダメ。しっかりレイヤーを守る。

## 準備 githubからソースコードを取得

gitを使ってソースコードをダウンロードする
```
コマンドプロンプトで実行
git clone https://github.com/namickey/spring-boot2-try.git
cd spring-boot2-try
```

## 実行 spring-boot:run

起動する
```
コマンドプロンプトで実行
mvnw.cmd spring-boot:run

「mvn」や「mvnw.cmd」はmavenのコマンドで、pom.xmlに記載されたライブラリ管理（自動的にクラスパス追加）
初回はライブラリのダウンロードに多少時間がかかった後に、起動する
```

## ブラウザアクセス
http://localhost:8080/

* TOP画面でitem一覧を表示する  
* 登録画面でitemを登録する  

## 停止
```
コマンドプロンプトで実行
Ctrl + C
```

## やってみよう 

* 実装と挙動を確認しよう
* 全てを2回写経しよう
* 未実装機能をつくってみよう

## 開発しよう

* 統合開発環境（vscode、eclipse、intelliJ）を使って機能追加しよう  
  * vscode：おススメ、最新、軽量  
  * eclipse：古き重き友人  
  * intelliJ：おススメだが、`spring-boot-devtools`の自動デプロイ機能と相性が悪い。intelliJは入力する度にファイル保存されてしまうから。  
* 入力チェックの追加
* エラーハンドリングの追加
* 検索画面の追加
* 削除画面の追加
* スタイルシートの追加
* javascriptの追加
* etc

## 次に業務アプリケーション開発を学ぼう
https://github.com/namickey/spring-boot2-train


## 公開しよう

* 自分のgithubアカウントを作って、ソースを公開しよう

## 参考　spring initializr

spring-bootの最小構成のデモアプリケーションを作成して、ダウンロード  

https://start.spring.io/

https://spring.pleiades.io/quickstart

今回使用したライブラリの設定イメージ  
![spring initializr](initializr.png)

以下のような構成のアプリケーションが生成されて、ダウンロードできすぐに開発を開始できる。
```
C:.
│  .gitignore
│  mvnw
│  mvnw.cmd
│  pom.xml
│  README.md
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─example
│  │  │          └─demo
│  │  │              │  DemoApplication.java
│  │  │                      
│  │  └─resources
│  │      │  application.properties
│  │      │  
│  │      ├─static
│  │      └─templates
```

## 参考

以下のリンクに、網羅的かつ実務的かつ実用的なspring-boot開発について公開情報あり。

Spring Frameworkを利用する実プロジェクトで活用できる設計・開発標準  
https://fintan.jp/page/5311/
