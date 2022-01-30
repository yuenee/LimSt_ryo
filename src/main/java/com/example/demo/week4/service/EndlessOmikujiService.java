package com.example.demo.week4.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class EndlessOmikujiService {
    /**
     * <pre>
     * 【問題文】
     * getResultはおみくじを引いた結果が"凶"になるまで繰り返しおみくじを引き続けるメソッドです。
     * ・ランダムなおみくじの結果を取得する処理を記載してください。
     * ・おみくじの結果が凶になるまで、繰り返しおみくじの結果を取得してください。
     * ・おみくじの結果は変数resultに格納して返却してください。 例.凶
     * なお、
     * </pre>
     *
     * @return result おみくじの結果
     */
    public String getResult() {
    	String[] fortuneTellling = {"大吉", "中吉", "小吉", "末吉", "凶"};
    	Random r = new Random();
    	while (true) {
    		String result = fortuneTellling[r.nextInt(5)];
    	    if (result.equals("凶")) {
    	        return result;
    	    }
     	}
    }

    /**
     * <pre>
     * 【問題文】
     * getResultCommentは引数のresult(おみくじの結果)に紐づいた、コメントを返すメソッドです。
     * ・無限おみくじの仕様に沿ったコメントを取得する記述をしてください。
     * ・コメントはresultCommentに格納して返却してください。 例.凶です、今あなたの後ろに・・・
     * ※なお、引数のresultはメソッドgetResultで取得した結果が格納されています。
     * </pre>
     *
     * @return resultComment 無限おみくじの仕様に沿ったコメント
     */
    public String getResultComment() {
    	return "凶ですね。残念でした。";
    }
}
