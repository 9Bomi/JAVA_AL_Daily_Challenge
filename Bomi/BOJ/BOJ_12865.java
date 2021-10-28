import java.util.*;
import java.io.*;

public class BOJ_12865 {//평범한 배낭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int weights[] = new int[N+1];
		int values[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][] = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(weights[i]>j) 
					dp[i][j] = dp[i-1][j];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]);
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
