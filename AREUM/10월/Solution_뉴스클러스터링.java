package com.pro.algo;
import java.util.*;

class Solution_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        int and = 0;
        int or = 0;
        
        for(int i=1; i<str1.length(); i++) {
            String temp = str1.substring(i-1,i+1);
            if(temp.matches("^[a-zA-Z]*$")) {
                list.add(temp);
                or++;
            }
        }
        
        for(int i=1; i<str2.length(); i++) {
            String temp = str2.substring(i-1,i+1);
            if(temp.matches("^[a-zA-Z]*$")) {
                int idx = list.indexOf(temp);
                if(idx!=-1) {
                    list.remove(idx);
                    and++;
                } else or++;
            }
           
        }
        
        if(and==0 && or==0) answer = 1*65536;
        else answer = (int)((double)and/or*65536);
        return answer;
    }
}