package com.example.demo.week3.service;

import org.springframework.stereotype.Service;

@Service
public class SazaeService {
    /**
     * <pre>
     * 【問題文】
     * jankenは、引数の myHand(自分の手) とopponentHand(相手の手)を使用して、
     * じゃんけんの勝敗を取得するメソッドです。 
     * ・じゃんけんの勝敗(win,lose,drawの何れか)を取得する処理を記載してください。
     * ・じゃんけんの勝敗は変数resultに格納して返却してください。
     * 例：
     * myHand = "goo", opponentHand = "choki"
     * return "win"
     * </pre>
     *
     * @param myHand 自分の手 goo,choki,per のいずれかの文字列
     * @param opponentHand 相手の手 goo,choki,per のいずれかの文字列
     * @return result win,lose,draw のいずれかの文字列
     * @throws IllegalArgumentException myHand または opponentHand が goo,choki,per のいずれかでない場合
     */
    public String janken(String myHand, String opponentHand) {
    	String result;
    	if (myHand.equals("choki") && opponentHand.equals("per")) {
    		result = "win";
    		return result;
        } else if (myHand.equals("goo") && opponentHand.equals("choki")) {
        	result = "win";
        	return result;
        } else if (myHand.equals("per") && opponentHand.equals("goo")) {
        	result = "win";
        	return result;
        } else if (myHand.equals("choki") && opponentHand.equals("choki")) {
        	result = "draw";
        	return result;
        } else if (myHand.equals("goo") && opponentHand.equals("goo")) {
        	result = "draw";
        	return result;
        } else if (myHand.equals("per") && opponentHand.equals("per")) {
        	result = "draw";
        	return result;
        } else if (myHand.equals("choki") && opponentHand.equals("goo")) {
        	result = "lose";
        	return result;
        } else if (myHand.contentEquals("goo") && opponentHand.equals("per")) {
        	result = "lose";
        	return result;
        } else { 
        	result = "lose";
        	return result;
        }
    }
}
    	
