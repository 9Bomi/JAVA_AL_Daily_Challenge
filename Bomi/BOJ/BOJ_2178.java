import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
	static class Point{
		int x;
		int y;
		
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		char map[][] = new char[N+2][M+2];
		boolean isVisited[][] = new boolean[N+2][M+2];
		for(int i=1;i<=N;i++) {
			String ss = br.readLine();
			for(int j=1;j<=M;j++)
				map[i][j]=ss.charAt(j-1);
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(1,1));
		isVisited[1][1] = true;
		int depth = 0;
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		boolean isArrived = false;
		
		while(!isArrived) {
			depth++;
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				Point temp = queue.poll();
				if(temp.x == N && temp.y == M) {
					isArrived = true;
					break;
				}
				
				for(int j=0;j<4;j++) {
					int nx = temp.x+dx[j];
					int ny = temp.y+dy[j];
					
					if(map[nx][ny]=='1' && !isVisited[nx][ny]) {
						isVisited[nx][ny] = true;
						queue.add(new Point(nx,ny));
					}
				}
			}
		}
		
		System.out.println(depth);
	}
}
