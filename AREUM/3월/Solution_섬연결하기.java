package com.pro.algo;

import java.util.PriorityQueue;

public class Solution_섬연결하기 {

	static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            
            queue.add(new Node(from, to, weight));
        }
        
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            
            if (union(temp.from, temp.to)) {
                answer += temp.weight;
            }
        }
        
        return answer;
    }
    
    public static int getParent(int num) {
        if (parents[num] == num) {
            return num;
        }
        
        return parents[num] = getParent(parents[num]);
    }
    
    public static boolean union(int a, int b) {
        int pA = getParent(a);
        int pB = getParent(b);
        
        if (pA == pB) {
            return false;
        }
        
        parents[pB] = pA;
        return true;
    }
    
    public static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;
        
        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
