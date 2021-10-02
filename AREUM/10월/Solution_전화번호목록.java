package com.pro.algo;

import java.util.*;

class Solution_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], phone_book[i]);
        }
        
        
        for(String str : phone_book) {
            for(int i=1; i<str.length(); i++){
                if(answer && map.containsKey(str.substring(0, i))){
                    answer=false;
                }
            }
            if(!answer) break;
        }
        
        return answer;
    }
}