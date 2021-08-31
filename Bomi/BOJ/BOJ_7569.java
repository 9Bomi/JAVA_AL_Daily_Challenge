import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569 {
	
	public static class Tomato{
		int x;
		int y;
		int h;
		
		Tomato(int h, int x, int y){
			this.h = h;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);	//열
		int N = Integer.parseInt(s[1]);	//행
		int H = Integer.parseInt(s[2]);	//높이 .. 가장 아래의 상자부터.
		
		char box[][][] = new char[H+2][N+2][M+2];//높이/행/열
		//boolean isVisited[][][] = new boolean[H+2][N+2][M+2];
		Queue<Tomato> que = new LinkedList<>();
		int tomatoN = 0;
		for(int i=1;i<=H;i++) 
			for(int j=1;j<=N;j++) {
				String ss[] = br.readLine().split(" ");
				for(int k=1;k<=M;k++) {
					char c = ss[k-1].charAt(0);
					box[i][j][k] = c;
					if(c== '1') 
						que.add(new Tomato(i,j,k));
					if(c== '0')//안익은 토마토 개수 세기
						tomatoN++;
				}
			}
		
		int dh[] = {-1,1,0,0,0,0};
		int dx[] = {0,0,-1,1,0,0};
		int dy[] = {0,0,0,0,-1,1};
		int days = 0;
		while(!que.isEmpty() && tomatoN>0) {
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				Tomato temp = que.poll();
				
				for(int j=0;j<6;j++) {
					int nh = temp.h+dh[j];
					int nx = temp.x+dx[j];
					int ny = temp.y+dy[j];
					
					if(box[nh][nx][ny]=='0') {
						que.add(new Tomato(nh,nx,ny));
						box[nh][nx][ny] = '1';
						tomatoN--;//익지 않은 토마토 수를 줄여줌
					}
				}
			}
			days++;
		}
		if(tomatoN != 0)
			days = -1;
		System.out.println(days);

	}

}
