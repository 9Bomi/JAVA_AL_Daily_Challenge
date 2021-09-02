import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1107 {
	static int num;
	static int size;
	static ArrayList<Integer> buttons = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	
	static void dfs(int cnt,String n) {
		if(cnt>0 && cnt >= size-1) {
			int sum = Integer.parseInt(n);
			int ans = (sum+"").length()+Math.abs(num-sum);
			if(ans<answer)
				answer = ans;
			
			if(cnt==size+1)
				return;
		}
		
		for(int i=0;i<buttons.size();i++) 
			dfs(cnt+1,n+buttons.get(i));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		size = (num+"").length();
		int n = Integer.parseInt(br.readLine());
		boolean broken[] = new boolean[10];
		
		if(n!=0) {
			String s[] = br.readLine().split(" ");
			
			for(int i=0;i<s.length;i++)
				broken[s[i].charAt(0)-'0'] = true;	
		}
		
		for(int i=0;i<10;i++)
			if(!broken[i])
				buttons.add(i);
		
		answer = Math.abs(num-100);
		
		if(answer!=0)
			dfs(0,"");
		
		System.out.println(answer);

	}

}
