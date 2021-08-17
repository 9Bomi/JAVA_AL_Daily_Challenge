import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15657 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int ans[];
	static int nums[];
	
	public static void dfs(int idx, int cnt) throws IOException {
		
		if(cnt == M) {
			for(int i=0;i<M;i++)
				bw.write(ans[i]+" ");
			
			bw.write("\n");
			
			return;
		}
		
		for(int i=idx;i<N;i++) {
			ans[cnt] = nums[i];
			dfs(i,cnt+1);
		}		
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		ans = new int[M];
		
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		
		dfs(0,0);
		
		bw.close();
		sc.close();
	}

}
