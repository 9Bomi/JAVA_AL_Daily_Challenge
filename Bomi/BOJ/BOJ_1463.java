import java.util.*;

public class BOJ_1463 {//1로 만들기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[1000001];
		
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=2;i<=n;i++) {
			if(i * 2<=n && (dp[i * 2] == 0 || dp[i * 2] > dp[i] +1))
				dp[i*2] = dp[i]+1;
			if (i * 3 <= n && (dp[i * 3] == 0 || dp[i * 3] > dp[i] +1))
				dp[i * 3] = dp[i] + 1;
			if (i + 1 <= n && (dp[i + 1] ==0 || dp[i + 1] > dp[i] + 1))
				dp[i + 1] = dp[i] + 1;
		}
		
		System.out.println(dp[n]);
	}

}
