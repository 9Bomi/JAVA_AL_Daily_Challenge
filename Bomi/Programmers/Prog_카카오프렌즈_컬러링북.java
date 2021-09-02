import java.util.*;

class Solution {
    
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean isVisited[][] = new boolean[m][n];
        Queue<Point> que= new LinkedList<>();
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(!isVisited[i][j] && picture[i][j]!=0){
                    numberOfArea++;
                    int count =0;
                    que.clear();
                    
                    count++;
                    isVisited[i][j] = true;
                    que.add(new Point(i,j));
                    
                    while(!que.isEmpty()){
                        Point temp = que.poll();
                        int x = temp.x;
                        int y = temp.y;
                        
                        for(int k=0;k<4;k++){
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            
                            if(0<=nx && nx<m && 0<=ny && ny<n && !isVisited[nx][ny] && picture[x][y]==picture[nx][ny]){
                                count++;
                                isVisited[nx][ny] = true;
                                que.add(new Point(nx,ny));
                            }
                        }
                    }
                    
                    if(count>maxSizeOfOneArea)
                        maxSizeOfOneArea = count;
                }
            }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}