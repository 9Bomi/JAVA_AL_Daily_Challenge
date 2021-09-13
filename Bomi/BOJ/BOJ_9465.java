import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9465 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			int map[][] = new int[2][n];
			
			for(int r=0;r<2;r++) {
				String s[] = br.readLine().split(" ");
				for(int c=0;c<n;c++)
					map[r][c] = Integer.parseInt(s[c]);
			}
			
			int dp[][] = new int[2][n+1];
			
			dp[0][0] = 0;
			dp[1][0] = 0;
			dp[0][1] = map[0][0];
			dp[1][1] = map[1][0];
			
			for(int d=2;d<= n; d++) {
				dp[0][d] = Math.max(dp[1][d-2], dp[1][d-1])+map[0][d-1];
				dp[1][d] = Math.max(dp[0][d-2], dp[0][d-1])+map[1][d-1];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
		
	}

}
