import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667 {
	static int N;
	static char map[][];
	static boolean isVisited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class Point{
		int x;
		int y;
		
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int bfs(Point p) {
		int count =1;
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(p);
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(!isVisited[nx][ny] && map[nx][ny]=='1') {
					count++;
					isVisited[nx][ny] = true;
					queue.add(new Point(nx,ny));
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N+2][N+2];
		isVisited = new boolean[N+2][N+2];
		
		for(int i=1;i<=N;i++) {
			String s = br.readLine();
			for(int j=1;j<=N;j++)
				map[i][j] = s.charAt(j-1);
		}
		
		int danjiN =0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++) 
				if(map[i][j]=='1' && !isVisited[i][j]) {
					danjiN++;
					isVisited[i][j] =true;
					pq.add(bfs(new Point(i,j)));
				}
			
		
		bw.write(danjiN+"\n");
		while(!pq.isEmpty()) 
			bw.write(pq.poll()+"\n");
		
		bw.close();
		br.close();
	}
}
