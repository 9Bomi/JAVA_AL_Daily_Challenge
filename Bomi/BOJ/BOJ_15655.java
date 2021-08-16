import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15655 {
	static int N;
	static int M;
	static int nums[];
	static boolean visited[];
	
	public static void dfs(int idx,int cnt) {
		if(idx == N ) {
			if(cnt == M) {
				for(int i=0;i<N;i++)
					if(visited[i])
						System.out.print(nums[i]+" ");
				
				System.out.println();
			}
			return;
		}
		
		visited[idx] = true;
		dfs(idx+1,cnt+1);
		visited[idx] = false;
		dfs(idx+1,cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N];
		
		for(int i=0;i<N;i++) 
			nums[i] = sc.nextInt();
		
		Arrays.sort(nums);
		visited = new boolean[N];
		
		dfs(0,0);
		
		sc.close();
		
	}
}
