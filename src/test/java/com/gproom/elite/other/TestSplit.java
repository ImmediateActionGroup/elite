package com.gproom.elite.other;

/**
 * @author weixueshan
 * @data 2018/3/26 17:47
 * @desc
 */
public class TestSplit {

    public static void main(String[] args) {
        String str = "jjj   jjj";
        String [] items = str.split(" ");
        String result = str.replaceAll(" +", " ");
        System.out.println(items.length);
    }
}
