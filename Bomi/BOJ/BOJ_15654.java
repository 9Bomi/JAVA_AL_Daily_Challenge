import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int nums[];
	static int N;
	static int M;
	static boolean visited[];
	static int ans[];
	
	public static void dfs(int cnt) {
		if(cnt == M) {
			for(int num :ans)
				System.out.print(num+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) 
			if(!visited[i]) {
				ans[cnt] = nums[i];
				visited[i] = true;
				dfs(cnt+1);
				visited[i] = false;
			}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		ans = new int[M];
		
		nums = new int[N];
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		dfs(0);
		
		sc.close();

	}

}
