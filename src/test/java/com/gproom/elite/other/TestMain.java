package com.gproom.elite.other;

import org.springframework.util.Base64Utils;

/**
 * @author weixueshan
 * @data 2018/3/23 17:17
 * @desc
 */
public class TestMain {

    public static void main(String[] args) {
        String aim = "N2UxNmEzZTQyYzNmNTYwMjM2NTEwYzAwODdlMjQwMGE=";

        String hah = new String(Base64Utils.decodeFromString(aim));
        System.out.println(hah);
        System.out.println(new String(Base64Utils.decodeFromString("N2UxNmEzZTQyYzNmNTYwMjM2NTEwYzAwODdlMjQwMGE=")));


        System.out.println("===========");

        String aim2 = "hahahaha";

        String r1 = Base64Utils.encodeToString(aim2.getBytes());
        System.out.println(r1);
        System.out.println(haha(r1));


    }

    public static String haha(String str){
        return new String(Base64Utils.decodeFromString(str));
    }
}
