import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
	static int N;
	static int M;
	static int map[][];
	static int ans = 0;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int ddx[][] = {{-1,-1,-1},{-1,0,1},{1,1,1},{-1,0,1}};
	static int ddy[][] = {{-1,0,1},{1,1,1},{-1,0,1},{-1,-1,-1}};
	static boolean visited[][];
	
	public static void dfs(int cnt, int sum,int x, int y) {
		if(cnt==4) {
			if(sum>ans) 
				ans = sum;
			return;
		}
		
		if(cnt==1) {//엿모양은 이걸로 판단해주기... 
			for(int i=0;i<4;i++) {
				int ssum = sum;
				for(int j=0;j<3;j++) {
					int nx = x+ddx[i][j];
					int ny = y+ddy[i][j];
					
					if(map[nx][ny]==0)
						break;
					
					ssum+=map[nx][ny];
					
					if(j==2 && ssum>ans) 
						ans = ssum;
				}	
			}
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(map[nx][ny]!=0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(cnt+1,sum+map[nx][ny],nx,ny);
				visited[nx][ny] = false;
			}
				
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N+2][M+2];
		StringTokenizer st;
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N+2][M+2];
		
		for(int i=1;i<=N;i++)
			for(int j=1;j<=M;j++) {
				visited[i][j] = true;
				dfs(1,map[i][j],i,j);
				visited[i][j] = false;
			}
		
		System.out.println(ans);
		
		br.close();

	}

}
