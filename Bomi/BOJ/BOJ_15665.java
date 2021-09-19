import java.io.*;
import java.util.*;

public class BOJ_15665 {
	static int n;
	static int m;
	static int nums[];
	static Set<String> set = new HashSet<>();
	
	public static void dfs(int cnt,String s) {
		if(cnt == m) {
			if(!set.contains(s)) {
				set.add(s);
				System.out.println(s);
			}
			return;
		}
		
		for(int i=0;i<nums.length;i++) 
			dfs(cnt+1,s+nums[i]+" ");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		
		
		String ss[] = br.readLine().split(" ");
		HashSet<String> hashset = new HashSet<>(Arrays.asList(ss));
		ss = hashset.toArray(new String[0]);
		nums = new int[ss.length];
		for(int i=0;i<ss.length;i++)
			nums[i] = Integer.parseInt(ss[i]);
		
		Arrays.sort(nums);
		
		dfs(0,"");
	}
}