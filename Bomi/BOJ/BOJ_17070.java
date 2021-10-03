import java.io.*;

public class BOJ_17070 { // 파이프 옮기기 1
	static int N;
	static char map[][];
	static int ans;
	static int dx[] = {0,1,1};
	static int dy[] = {1,1,0};
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	// state
	// -1 : 가로
	// 0 : 대각선
	// 1 : 세로
	static void dfs(int state, Point before, Point now) {
		if(now.x == N && now.y == N) {
			ans++;
			return;
		}
		
		if(state == 0){//대각선인 경우
			int count =0;
			
			if(map[now.x][now.y+1]=='0') {
				dfs(-1,now, new Point(now.x,now.y+1));
				count++;
			}
			
			if(map[now.x+1][now.y]=='0') {
				dfs(1,now, new Point(now.x+1,now.y));
				count++;
			}
			
			if(count == 2 && map[now.x+1][now.y+1]== '0')
				dfs(0,now,new Point(now.x+1,now.y+1));
		}
		else if(state == -1 && map[now.x][now.y+1]=='0') {//가로
			dfs(-1,now, new Point(now.x,now.y+1));
			
			if(map[now.x+1][now.y]=='0' && map[now.x+1][now.y+1]=='0')
				dfs(0,now,new Point(now.x+1,now.y+1));
		}
		else if(state == 1 && map[now.x+1][now.y]=='0') {//세로
			dfs(1,now, new Point(now.x+1,now.y));
			
			if(map[now.x][now.y+1]=='0' && map[now.x+1][now.y+1]=='0')
				dfs(0,now,new Point(now.x+1,now.y+1));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N+2][N+2];
		
		for(int i=1;i<=N;i++) {
			String s[] = br.readLine().split(" ");
			for(int j=1;j<=N;j++)
				map[i][j] = s[j-1].charAt(0);
		}
		
		dfs(-1,new Point(1,1),new Point(1,2));
		
		System.out.println(ans);

	}

}
