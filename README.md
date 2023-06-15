# spring-boot2-try

## やりたいこと

* Spring-Bootを使った効率的な開発をする
* MyBatisというORマッパーを使う
* javaとMySQLだけがインストールされたマシンで、アプリケーションを起動する
* 起動時に自動的にテーブルをcreateし、dataをインサートする
* setter,getterは作成しない。lombokが生成してくれる
* 起動までに必要な手順を最小化する
* 二重サブミット対策としてPRGパターンを使う
* アプリ起動中にソースコードを修正して保存するだけで、自動的にビルドと再起動が行われ、すぐに反映される

さいきょうの二重サブミット対策  
https://qiita.com/syobochim/items/120109315f671918f28d  

【Java】Lombokで冗長コードを削減しよう  
https://www.casleyconsulting.co.jp/blog/engineer/107/ 

## 前提環境

以下がインストール済みであること
* JDK 11
* MySQL 8
* git

## 使用するフレームワーク

* spring-boot2.7
* spring-boot-starter-web
* thymeleaf
* mybatis
* lombok
* 組み込みTomcat 9
* 組み込みMaven 3

## ディレクトリ階層

今回、起動するアプリケーションのディレクトリ階層
```
C:.
│  .gitignore
│  initializr.png
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

![spring initializr](app.png)

## 準備1 mysqlのデータベース作成

データベースのみ作成する。テーブルは作成しない。
```
コマンドプロンプトで実行
mysql -u root -p

create database mydb;

exit
```

## 準備2 githubからソースコードを取得

ソースコードをダウンロードする
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

## 開発する

vscodeなどの開発環境を使って機能追加しよう
* スタイルシートの追加
* 入力チェックの追加
* etc

## 公開する

* 自分のgithubアカウントを作って、ソースを公開しよう

## 参考　spring initializr

spring-bootの最小構成のデモアプリケーションを作成して、ダウンロードする  

https://start.spring.io/

https://spring.pleiades.io/quickstart

今回使用したライブラリの設定イメージ  
![spring initializr](initializr.png)

## 参考

以下が網羅的かつ実務的かつ実用的なspring-boot開発

Spring Frameworkを利用する実プロジェクトで活用できる設計・開発標準  
https://fintan.jp/page/5311/
