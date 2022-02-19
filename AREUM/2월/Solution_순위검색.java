package com.pro.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution_순위검색 {
public int[] solution(String[] info, String[] query) {
        
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
        
            comb(infos, map);
        }
        
        for (ArrayList<Integer> list : map.values()) {
            list.sort(Comparator.naturalOrder());
        }
        
        int[] answer = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            
            int point = Integer.parseInt(q[1]);
            
            ArrayList<Integer> list = map.get(q[0]);
            
            if (list == null) {
                continue;
            }
            
            int res = binarySearch(point, list);
            
            if (res == -1) {
                answer[i] = 0;
            } else {
                answer[i] = list.size() - res;
            }
        }
        
        return answer;
    }
    
    static void comb(String[] infos, Map<String, ArrayList<Integer>> map) {
        for (int j = 0; j < 16; j++) {
            String temp = "";

            for (int k = 0; k < 4; k++) {
                if ((j & (1 << k)) != 0) {
                    temp += infos[k];
                } else {
                    temp += "-";
                }
            }

            if (map.containsKey(temp)) {
                map.get(temp).add(Integer.parseInt(infos[4]));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(infos[4]));
                map.put(temp, list);
            }
        }
    }
    
    static int binarySearch(int point, ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        int res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= point) {
                res = mid;
                right = mid - 1;
            } else {
               left = mid + 1;
            }
        }
        
        return res;
    }
}
