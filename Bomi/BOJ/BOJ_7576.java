import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	
	static class Tomato{
		int x;
		int y;
		
		Tomato(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(sb.nextToken());//열의 개수
		int N = Integer.parseInt(sb.nextToken());//행의 개수
		char map[][] = new char[N+2][M+2];
		int ttoNotDone = 0;

		Queue<Tomato> queue = new LinkedList<>();
		int ans =0;
		
		for(int i=1;i<=N;i++) {
			sb = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				char c = sb.nextToken().charAt(0);
				map[i][j] = c;
				if(c == '1') 
					queue.add(new Tomato(i,j));
				else if(c == '0')
					ttoNotDone++;
			}
		}
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};

		while(ttoNotDone>0 && !queue.isEmpty()) {
			int size = queue.size();
			for(int k=0;k<size;k++) {
				Tomato tom = queue.poll();
				
				for(int i=0;i<4;i++) {
					int nx = tom.x + dx[i];
					int ny = tom.y + dy[i];
					
					if(map[nx][ny] =='0') {
						queue.add(new Tomato(nx,ny));
						map[nx][ny] = '1';
						ttoNotDone--;
					}
				}
			}
			ans++;
		}
		
		if(ttoNotDone >0) //토마토가 모두 익지 못하는 상황 
			ans =-1;
		
		System.out.println(ans);
	}

}
