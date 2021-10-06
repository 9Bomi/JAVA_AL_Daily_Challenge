package com.pro.algo;

import java.util.LinkedList;
import java.util.Queue;

class Solution_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Document> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            queue.add(new Document(priorities[i],i));
        }
        
        while(true){
            Document doc = queue.poll();
            
            boolean available = true;
            int cnt= queue.size();
            for(int i=0; i<cnt; i++){
                Document temp = queue.poll();
                if(temp.priority>doc.priority) available = false;
                queue.add(temp);
            }
            
            if(available) {
                answer++;
                if(doc.index==location) break;
            } else{
                queue.add(doc);
            }
        }
        
        return answer;
    }
    
    static class Document{
        int priority;
        int index;
        Document(int priority, int index) {
            this.priority=priority;
            this.index=index;
        }
    }
}