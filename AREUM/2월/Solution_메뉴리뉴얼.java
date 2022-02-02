package com.pro.algo;

import java.util.*;

public class Solution_메뉴리뉴얼 {
    static ArrayList<String> list;
    static boolean[] alphas, nums;
    static boolean[][] freqs;
    static int[] selected = new int[11];
    static int[] maxes = new int[11];
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        list = new ArrayList<String>();
        map = new HashMap<>();
        
        nums = new boolean[11];
        alphas = new boolean[26];
        freqs = new boolean[orders.length][26];
        
        for (int i = 0 ; i < orders.length; i++) {
            for (int j = 0;  j < orders[i].length(); j++) {
                char temp = orders[i].charAt(j);
                
                alphas[temp - 'A'] = true;
                freqs[i][temp - 'A'] = true;
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            nums[course[i]] = true;
        }
        
        comb(0, 0);
        
        for (String key : map.keySet()) {
            if (map.get(key) == maxes[key.length()]) {
                list.add(key);
            }
        }
        
        Collections.sort(list);
        
        return list.toArray(new String[list.size()]);
    }
    
    public static void comb(int num, int start) {
        if (num >= 11) {
            return;
        }
        
        if (nums[num]) {
            String res = "";
            int success = 0;
            
            for (int i = 0; i < freqs.length; i++) {
                boolean contain = true;
                
                for (int j = 0; j < num; j++) {
                    if (!freqs[i][selected[j]]) {
                        contain = false;
                        break;
                    }
                }
                
                if (contain) {
                    success++;
                }
            }
            
            if (success >= 2 && maxes[num] <= success) {
                for (int i= 0; i < num; i++){
                    res += (char)(selected[i] + 'A');
                }
                
                map.put(res, success);
                maxes[num] = success;
                
            }
        }
        
        for (int i = start;  i < 26; i++) {
            if (alphas[i]) {
                selected[num] = i;
                comb(num+1, i+1);
            }
        }
    }
}