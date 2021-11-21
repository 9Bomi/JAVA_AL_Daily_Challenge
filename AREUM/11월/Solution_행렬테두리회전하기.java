package com.pro.algo;

import java.util.*;

class Solution_행렬테두리회전하기 {
    static int dr[] = {0,1,0,-1};
    static int dc[] = {1,0,-1,0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int map[][] = new int[rows+1][columns+1];
        
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++) {
                map[i][j] =  ((i-1) * columns + j);
            }
        }
        
        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i][0],queries[i][1],queries[i][2],queries[i][3], map);
        }
        
        return answer;
    }
    
    public static int rotate(int sr, int sc, int er, int ec, int map[][]) {
        int min =  map[sr][sc];
        
        int dir=0;
        int past = min;
        
        int tempR = sr;
        int tempC = sc;
        
        while(true){
        	tempR += dr[dir];
        	tempC += dc[dir];
        	
            if(tempR>er||tempR<sr||tempC<sc||tempC>ec) {
            	if(dir==3) break;
            	tempR-=dr[dir];
            	tempC-=dc[dir];            	
            	dir++;
            	continue;
            }
            
            int temp = map[tempR][tempC];
            map[tempR][tempC]=past;
            past=temp;
            min=Math.min(temp, min);
            
        }
        
        return min;
    }
}