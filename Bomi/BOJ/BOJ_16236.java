import java.util.*;
import java.io.*;

public class BOJ_16236 {
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Point p) {
			if(this.x == p.x)
				return this.y- p.y;
			return this.x - p.x;
		}
	}
	
	static class Shark{
		int x;
		int y;
		int namCount=0;
		int size =2;
		
		Shark(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		void eatFish(Point p) {
			this.x = p.x;
			this.y = p.y;
			this.namCount +=1;
			
			if(this.namCount == this.size) {
				this.namCount=0;
				this.size+=1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char map[][] = new char[n+2][n+2];
		Shark baby = new Shark(0,0);
		int fishCount =0;
		int time =0;
		
		for(int i=1;i<=n;i++) {
			String s[] = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				char c = s[j-1].charAt(0);
				if(c == '9') 
					baby = new Shark(i,j);
				else if('1'<=c && c <='6')
					fishCount++;
				map[i][j] = c;
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		boolean isVisited[][]; 
		int dx[] = { -1,1,0,0,};
		int dy[] = { 0,0,-1,1};
		int depth;
		
		while(fishCount>0) {
			
			//자원 초기화
			pq.clear();
			queue.clear();
			isVisited = new boolean[n+2][n+2];
			depth =0;
			
			queue.add(new Point(baby.x,baby.y));
			isVisited[baby.x][baby.y] = true;
			
			do{
				depth++;
				int size = queue.size();
				
				for(int i=0;i<size;i++) {
					Point temp = queue.poll();
					for(int j=0;j<4;j++) {
						int nx = temp.x +dx[j];
						int ny = temp.y +dy[j];
						int fishSize = map[nx][ny] -'0';
						
						if(!isVisited[nx][ny]) {//일단 안 가본 곳이어야 함
							if(0<fishSize && fishSize < baby.size)//먹을 수 있는 물고기거나
								pq.add(new Point(nx,ny));
							else if(fishSize == 0 || fishSize == baby.size){//지나갈 수 있는 길이거나
								queue.add(new Point(nx,ny));
								isVisited[nx][ny] = true;
							}
						}
					}
				}
				
			}while(!queue.isEmpty() && pq.isEmpty());
			
			if(!pq.isEmpty()) {
				Point fishToEat = pq.poll();
				map[baby.x][baby.y] = '0';
				baby.eatFish(fishToEat);
				fishCount--;
				map[fishToEat.x][fishToEat.y] = '0';
				time+=depth;
			}
			else
				break;
		}
		
		System.out.println(time);
		br.close();
	}

}
