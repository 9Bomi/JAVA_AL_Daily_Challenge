import java.io.*;
import java.util.*;

public class BOJ_15663 {
	static int n;
	static int m;
	static int nums[];
	static Set<String> set = new HashSet<>();
	static boolean visited[];
	
	public static void dfs(int cnt,int count,String s) {
		if(cnt == n) {
			if(count == m) {
				if(!set.contains(s)) {
					set.add(s);
					System.out.println(s);
				}
			}
			return;
		}
		
		for(int i=0;i<n;i++) 
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1,count+1,s+nums[i]+" ");
				visited[i] = false;
			}
		
		dfs(cnt+1,count,s);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		nums = new int[n];
		visited = new boolean[n];
		String ss[] = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			nums[i] = Integer.parseInt(ss[i]);
		
		Arrays.sort(nums);
		
		dfs(0,0,"");
	}

}
