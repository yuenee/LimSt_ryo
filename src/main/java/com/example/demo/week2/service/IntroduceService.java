package com.example.demo.week2.service;

import org.springframework.stereotype.Service;

@Service
public class IntroduceService {
    /**
     * <pre>
     * 【問題文】
     *  getNameはあなたの名前を返すメソッドです。
     *   ・変数nameを定義(あなたの名前を格納)して返却してください。
     * </pre>
     * @return name 自分の名前
     */
	public String getName() {
         String name = "Ryo Utsumiya";
         return name;
	}
	
    /**
     * <pre>
     * 【問題文】
     *  getCommentは自己紹介文を返すメソッドです。
     *   ・変数commentを定義(自己紹介文を格納)して返却してください。
     * </pre>
     * @return comment 自己紹介文
     */
	public String getComment() {
          String comment = "こんにちは、諒です。よろしくお願いいたします";
          return comment;
	}
}
