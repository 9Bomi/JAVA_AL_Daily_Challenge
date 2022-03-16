package com.pro.algo;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Solution_단어변환 {

	public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            
            for (int j = 0; j < temp.length; j++) {
                char origin = temp[j];
                char change = 'a';
                
                while (change <= 'z') {
                    if (change == origin) {
                        change++;
                        continue;
                    }
                    
                    temp[j] = change;
                    
                    String str = new String(temp);
                    
                    if (map.containsKey(str)) {
                        map.get(str).add(words[i]);
                    } else {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(words[i]);
                        
                        map.put(str, list);
                    }
                        
                    change++;
                }
                
                temp[j] = origin;
            }
        }
                        
        answer = bfs(begin, target, map);
        
        return answer;
    }
                        
                        
    public static int bfs(String begin, String target, Map<String, ArrayList<String>> map) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        set.add(begin);
        queue.add(begin);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            
            for (int c = 0; c < cnt; c++) {
                String temp = queue.poll();
                
                if (temp.equals(target)) {
                    return level;
                }
                
                if (map.containsKey(temp)) {
                    for (String next : map.get(temp)) {
                        if (set.contains(next)) {
                            continue;
                        }
                        
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
            
            level++;
        }
        
        return 0;
    }
}
