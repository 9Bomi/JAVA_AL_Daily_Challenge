import java.io.*;
import java.util.*;

public class BOJ_15666 {
	static int n;
	static int m;
	static int nums[];
	static Set<String> set = new HashSet<>();
	
	public static void dfs(int cnt, int before, String s) {
		if(cnt == m) {
			s.trim();
			if(!set.contains(s)) {
				set.add(s);
				System.out.println(s);
			}
			return;
		}
		
		for(int i=0;i<n;i++) 
			if(before != nums[i])
				dfs(cnt+1,nums[i],s+nums[i]+" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		nums = new int[n];

		String ss[] = br.readLine().split(" ");
		for(int i=0;i<n;i++)
			nums[i] = Integer.parseInt(ss[i]);
		
		Arrays.sort(nums);
		
		dfs(0,0,"");
	}

}
