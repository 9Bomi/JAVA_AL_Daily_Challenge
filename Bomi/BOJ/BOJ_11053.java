import java.util.*;
import java.io.*;
//가장 긴 증가하는 부분 순열

public class BOJ_11053 {
	static int N;
	static int seq[];
	static int dp[];

	static int LIS(int num) {
		
		if(dp[num] == 0) {
			dp[num] = 1;
			
			for(int i=num-1;i>=0;i--) 
				if(seq[i]<seq[num]) 
					dp[num] = Math.max(dp[num],LIS(i)+1);
		}
		
		return dp[num];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) 
			seq[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++)
			LIS(i);
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
	}

}
