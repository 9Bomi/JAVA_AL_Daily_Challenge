import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2606 {
	static int N;
	static ArrayList<ArrayList<Integer>> computers = new ArrayList<>();
	static boolean isVisited[];
	static int ans;
	
	public static void dfs(int n) {
		
		for(int i=0;i<computers.get(n).size();i++) {
			int num= computers.get(n).get(i);
			
			if(!isVisited[num]) {
				ans++;
				isVisited[num] = true;
				dfs(num);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		isVisited = new boolean[N];
		for(int i=0;i<N;i++)
			computers.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0])-1;
			int b = Integer.parseInt(s[1])-1;
			computers.get(a).add(b);
			computers.get(b).add(a);
		}
		
		dfs(0);
		
		System.out.println(ans-1);
		
	}

}
