import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int price[][] = new int[n][3];
		int dp[][] = new int[n][3];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) 
				price[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = price[0][0];
		dp[0][1] = price[0][1];
		dp[0][2] = price[0][2];
		
		for(int i=1;i<n;i++) {
			dp[i][0] = price[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = price[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = price[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}

}
