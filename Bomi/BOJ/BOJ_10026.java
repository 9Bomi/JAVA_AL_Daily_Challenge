import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static int N;
	static char map[][];
	static int dx[]= {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs() {
		int count =0;
		boolean isVisited[][] = new boolean[N+2][N+2];
		Queue<Point> que = new LinkedList<>();
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
				if(!isVisited[i][j]) {
					count++;
					isVisited[i][j] = true;
					que.add(new Point(i,j));
					while(!que.isEmpty()) {
						Point temp = que.poll();
						
						for(int k=0;k<4;k++) {
							int nx = temp.x+dx[k];
							int ny = temp.y+dy[k];
							
							if(map[temp.x][temp.y]==map[nx][ny] && !isVisited[nx][ny]) {
								isVisited[nx][ny] = true;
								que.add(new Point(nx,ny));
							}
						}
					}
				}
		
		
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map= new char[N+2][N+2];
		
		for(int i=1;i<=N;i++) {
			String s = br.readLine();
			for(int j=1;j<=N;j++) 
				map[i][j] = s.charAt(j-1);
		}
		
		int countNormal = bfs();
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=N;j++)
				if(map[i][j]=='G')
					map[i][j] = 'R';
		
		int countRG = bfs();
		
		System.out.println(countNormal + " " + countRG);
	}

}
