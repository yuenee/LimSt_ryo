package com.example.demo.week10.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import java.util.Collections;
@Service
public class NumeronService {
    /**
     * <pre>
     *【問題文】
     * 下記の内容をフィールド変数として宣言してください
     * ＊以下の問題はここで宣言したものを使用します
     * ・答えの数列(answerList)
     * ・入力数列(attackList)
     * ・ターン数(turn) ターン数の初期値は0
     * </pre>
     */
	private List<Integer> answerList = new ArrayList<>();
	private List<Integer> attackList = new ArrayList<>();
	private int turn = 0;
    /**
     * <pre>
     *【問題文】
     * initメソッドを呼び出す引数無しのコンストラクタを定義してください
     * </pre>
     */
    public NumeronService(){
    	init();
    }

    /**
     * <pre>
     *【問題文】
     *　initは、答えの数列(3桁)の値を格納したList型の値を返却するメソッドです。
     *　・答えの数列(3桁)の値を格納したList型の値を返却してください
     * ※返却に使用するList型は、先で定義したanswerListを用いてください
     * </pre>
     * @return answerList ランダム数値3桁が格納されるリスト(答えの数列)
     */
    public List<Integer> init() {
    	this.turn = 0;
    	this.answerList = new ArrayList<>();
    	Integer[] array = {1,2,3,4,5,6,7,8,9};
    	List<Integer> list = Arrays.asList(array);
    	Collections.shuffle(list);
       	answerList.add(list.get(1));
       	answerList.add(list.get(2));
       	answerList.add(list.get(3));
    	return answerList;
    }
	    
    

    /**
     * <pre>
     *【問題文】
     * getAttackResultは引数のanswerlist(答えの数列)内の数値とattackNumber(String型の入力数値)が持つ数値の
     * 合致判定をするメソッドです。
     * ・合致判定処理を記載してください。
     * ※合致判定は数値List型同士(answerlist, attackList)で行ってください
     * ※attackNumberは3桁のString型数字のため、int型に変換のうえ定義済みのattackListに1桁ずつ格納してください。
     *  また、合致判定は
     *  数値・場所共にあっている判定(getHitCountメソッドの呼び出し)
     *  数値のみあっている判定(getBlowCountメソッドの呼び出し)を行い、
     *  判定結果をInteger型List、attackResultに格納してください。
     *  attackResultの0番目の要素にはhitResultの結果
     *  attackResultの1番目の要素にはblowResultの結果
     * </pre>
     * @param answerList ランダム数値3桁が格納されるリスト(答えの数列)
     * @param attackNumber  入力したString型の数字が格納される(入力数字)
     * @return attackResult
     */
    public List<Integer> getAttackResult(List<Integer> answerList, String attackNumber){
    
        //attackListを初期化
    	 this.attackList = new ArrayList<>();

        // attackNumberを1桁区切りにして、String型ListのnumberListに格納
    	 List<String> numberList = new ArrayList<String>();
    	 String[] splitNumber = attackNumber.split("");
    	 Arrays.toString(splitNumber);
    	 numberList.add(splitNumber[0]);
    	 numberList.add(splitNumber[1]);
    	 numberList.add(splitNumber[2]);
        // String⇒intに変換のうえ、attackListに格納
    	 attackList.add(Integer.parseInt(numberList.get(0)));
    	 attackList.add(Integer.parseInt(numberList.get(1)));
    	 attackList.add(Integer.parseInt(numberList.get(2)));
        // hitResultにgetHitCount呼び出し結果を格納
    	 int hitResult = getHitCount(answerList, attackList);
        // blowResultにgetBlowCount呼び出し結果を格納
    	 int blowResult = getBlowCount(answerList, attackList);
        // attackResultに判定結果を格納
    	 List<Integer> attackResult = new ArrayList<Integer>();
    	 attackResult.add(hitResult);
    	 attackResult.add(blowResult);
    	 return attackResult;
    }

	/**
     * <pre>
     *【問題文】
     *　getHitCountは、引数のanswerlist(答えの数列)とattackList(入力数列)において、
     * 数値・場所共にあっている数字がいくつあるかを判定するメソッドです。
     * ・判定処理を記載してください。
     * ・判定結果(あっている数)をint型の変数hitCountを定義して格納してください。
     * </pre>
     * @param answerList 答えの数列
     * @param attackList 入力数列
     * @return hitCount 数値・場所共にあっている数
     */
    public int getHitCount(List<Integer> answerList, List<Integer> attackList){
    	int hitcount = 0;
    	for (int i = 0; i < answerList.size(); i++) {
    		if (answerList.get(i) == attackList.get(i)) {
        		hitcount++;
        	}
    	}
    	return hitcount;
    }

    /**
     * <pre>
     *【問題文】
     * getBlowCountは引数のanswerlist(答えの数列)とattackList(入力数列)において、
     * 場所は違うが、数値があっている数字がいくつあるかを判定するメソッドです。
     * ・判定処理を記載してください。
     * ・判定結果(あっている数)をint型の変数blowCountを定義して格納してください。
     * </pre>
     * @param answerList 答えの数列
     * @param attackList 入力数列
     * @return blowCount 数値のみあっている数
     */
    public int getBlowCount(List<Integer> answerList, List<Integer> attackList){
    	int blowCount = 0;
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (answerList.get(i) == attackList.get(j) && answerList.get(i) != attackList.get(i)){
    				blowCount++;
    			}
    		}
    	}
    	return blowCount;
    }

    /**
     * <pre>
     *【問題文】
     *　addturnは、アタック毎にターン数を経過させるメソッドです。
     * ・ターン数を経過させるメソッドを定義してください。
     * </pre>
     */
    public void addturn() {
    	this.turn += 1;
    }

    /**
     * <pre>
     * 【問題文】
     *  getAnswerListはフィールド変数で宣言したanswerListを返却するメソッドです。
     * </pre>
     * @return answerList 答えのリスト
     */
    public List<Integer> getAnswerList() {
    	return answerList;
    }

    /**
     * <pre>
     * 【問題文】
     *  getTurnはフィールド変数で宣言したturnを返却するメソッドです。
     *  </pre>
     *  @return turn ターン数
     */
    public int getTurn() {
    	return turn;
    }

    /**
     * <pre>
     *【問題文】
     * getRankは、引数のturn(経過ターン数)に応じて、称号を判定するメソッドです。
     * ・称号を判定する処理を記載してください。
     * ・判定結果はString型Listに格納して返却してください。
     *  rankの0番目の要素にはランクの結果
     *  rankの1番目の要素にはメッセージの結果
     * ※ターン数に応じた、ランク付け・メッセージは任意のモノを指定
     *  </pre>
     *  @param turn 経過ターン数
     *  @return rank　
     */
    public List<String> getRank(int turn) {
    	List<String> rank = new ArrayList<String>();
    	if (turn == 0) {
    		rank.add(0, "A");
    		rank.add(1, "You must be a freacking genius！");
    	} else if (turn == 1 || turn == 2 || turn == 3) {
    		rank.add(0, "B");
    		rank.add(1, "You are so awesome!");
    	} else if (turn == 4 || turn == 5 || turn == 6) {
    		rank.add(0, "C");
    		rank.add(1, "You are still great!");
    	} else if (turn == 7 || turn == 8 || turn == 9) {
    		rank.add(0, "D");
    		rank.add(1, "You could have done better!");
    	} else {
    		rank.add(0, "OK");
    		rank.add(1, "you got it right!");
    	}
        return rank;
    }
}
