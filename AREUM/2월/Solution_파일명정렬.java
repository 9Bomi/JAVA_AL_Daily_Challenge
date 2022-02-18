package com.pro.algo;

import java.util.PriorityQueue;

public class Solution_파일명정렬 {
	public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        PriorityQueue<File> queue = new PriorityQueue<>();
        
        for (int i = 0; i < files.length; i++) {
            int startNum = -1;
            int endNum = -1;
            
            for (int j = 0; j < files[i].length(); j++) {
                if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
                    if (startNum == -1) {
                        startNum = j;
                    } else {
                        endNum = j;
                    }
                } else if (startNum != -1) {
                    break;
                }
            }
            
            if (endNum == -1) {
                endNum = startNum;
            }
            
            queue.add(new File(files[i].substring(0, startNum).toUpperCase(), 
                               Integer.parseInt(files[i].substring(startNum, endNum+1)), i));
        }
        
        int num = 0;
        
        while (!queue.isEmpty()) {
            answer[num++] = files[queue.poll().index];
        }
        
        return answer;
    }
    
    static class File implements Comparable<File> {
        String head;
        int number;
        int index;
        
        File (String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }
        
        @Override
        public int compareTo(File f) {
            if (this.head.compareTo(f.head) == 0) {
                if (this.number == f.number) {
                    return this.index - f.index;
                } else {
                    return this.number - f.number;
                }
            } else {
                return this.head.compareTo(f.head);
            }
        }
    }
}
