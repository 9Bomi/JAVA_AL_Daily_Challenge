package com.pro.algo;
import java.util.*;

class Solution_카카오프렌즈컬러링북 {
    static int dr[]={-1,1,0,0};//상하좌우
    static int dc[]={0,0,-1,1};
    static boolean isVisited[][];
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        isVisited=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!isVisited[i][j]&&picture[i][j]!=0){
                    maxSizeOfOneArea = Math.max(bfs(i,j,picture[i][j],m,n, picture), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int bfs(int r, int c, int past, int m, int n, int[][] picture){

        int cnt=1;
        isVisited[r][c] =true;
        Queue<int[]> queue = new LinkedList<int[]>();
        
        queue.add(new int[]{r,c});
        while(!queue.isEmpty()){
            int [] temp = queue.poll();

            for(int i=0; i<4; i++){
                int tempR= temp[0]+dr[i];
                int tempC = temp[1]+dc[i];
                if(tempR>=0 && tempR<m && tempC>=0 && tempC<n){
                    if(!isVisited[tempR][tempC]&&picture[tempR][tempC]==past){
                        isVisited[tempR][tempC]=true;
                        queue.add(new int[]{tempR, tempC});
                        cnt++;
                    }
                }
             }
        }
        
        return cnt;
        
    } 
}