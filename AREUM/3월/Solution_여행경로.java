package com.pro.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution_여행경로 {
	static int N;
    static String[] answer;
    static boolean[] isVisited;
    static Map<String, Integer> indexMap;
    static ArrayList<Vertex>[] list;
    
    public String[] solution(String[][] tickets) {
        indexMap = new HashMap<>();
        list = new ArrayList[10000];
        N = tickets.length + 1;
        answer = new String[N];
        isVisited = new boolean[N - 1];
        
        for (int i = 0; i < 10000; i++) {
            list[i] = new ArrayList<Vertex>();
        }
        
        int cnt = 0;
        
        for (int i = 0; i < tickets.length; i++) {
            indexMap.put(tickets[i][0], indexMap.getOrDefault(tickets[i][0], cnt++));
            list[indexMap.get(tickets[i][0])].add(new Vertex(tickets[i][1], i));
        }
        
        for (int i = 0; i < 10000; i++) {
            Collections.sort(list[i], (o1, o2) -> o1.to.compareTo(o2.to));
        }
        
        dfs("ICN", 0);
        
        return answer;
    }
    
    public static boolean dfs(String from, int cnt) {
        if (cnt == N - 1) {
            answer[cnt] = from;
            return true;
        }
        
        boolean success = false;
        
        if (indexMap.containsKey(from)) {
            int index = indexMap.get(from);
            
            for (int i = 0;  i < list[index].size(); i++) {
                if (isVisited[list[index].get(i).index]) {
                    continue;
                }
                
                isVisited[list[index].get(i).index] = true;
                if (dfs(list[index].get(i).to, cnt + 1)) {
                    answer[cnt] = from;
                    success = true;
                    break;
                }
                isVisited[list[index].get(i).index] = false;
            }
        }
        
        return success;
    }
    
    static class Vertex {
        String to;
        int index;
        
        Vertex(String to, int index) {
            this.to = to;
            this.index = index;
        }
    }
}
