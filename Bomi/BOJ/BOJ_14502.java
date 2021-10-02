import java.io.*;
import java.util.*;

public class BOJ_14502 {// 연구소
	static int N;
	static int M;
	static char map[][];
	static int zeroCount =0;
	static ArrayList<Point> zeroPointList = new ArrayList<>();
	static ArrayList<Point> virusPointList = new ArrayList<>();
	static Point CombinationArray[] = new Point[3]; // 벽을 세운 위치 좌표
	static int maxCount = Integer.MIN_VALUE;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
 	
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void playVirus() {
		// map에 1 칠하기
		for(Point p : CombinationArray) 
			map[p.x][p.y] = '1';
		
		// 바이러스 퍼뜨리기
		//1. 큐에 바이러스 위치 담기
		Queue<Point> queue = new LinkedList<Point>();
		for(Point p : virusPointList) 
			queue.add(p);
		
		boolean isVisited[][] = new boolean[N+2][M+2];
		int count = zeroCount-3;//벽 3개 세웠으니 빼준다
		//2. 바이러스 퍼뜨리기
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(map[nx][ny]=='0' && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true;
					count--;
					queue.add(new Point(nx,ny));
				}
			}
		}
		
		if(count>maxCount)
			maxCount = count;
		
		//map에 1 지우기
		for(Point p : CombinationArray) 
			map[p.x][p.y] = '0';
	}
	
	static void Combination(int cnt, int count) {
		if(count == 3) {
			playVirus();
			return;
		}
		
		for(int i=cnt;i<zeroCount;i++) {
			CombinationArray[count] = zeroPointList.get(i);
			Combination(cnt+1,count+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N+2][M+2];
		
		for(int i=1;i<=N;i++) {//map 받아오기
			String ss[] = br.readLine().split(" ");
			for(int j=1;j<=M;j++) {
				char c = ss[j-1].charAt(0);
				map[i][j] = c;
				
				if(c == '2') 
					virusPointList.add(new Point(i,j));
				else if(c == '0') 
					zeroPointList.add(new Point(i,j));
			}
		}
		
		zeroCount = zeroPointList.size();
		
		Combination(0,0);
		
		System.out.println(maxCount);
		
	}

}
