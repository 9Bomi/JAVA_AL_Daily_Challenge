import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11724 {
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> graph;
	static int ans;
	
	static void dfs(int cnt) {
		
		if(!visited[cnt]) {
			ans++;
			visited[cnt] = true;
		}
		
		for(int i=0;i<graph.get(cnt).size();i++) {
				int num = graph.get(cnt).get(i);
				if(!visited[num]) {
					visited[num] = true;
					dfs(num);
				}
			}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		graph = new ArrayList<>();
		
		for(int i=0;i<=N;i++) 
			graph.add(new ArrayList<>());
		
		for(int i=1;i<=M;i++) {
			String ss[] = br.readLine().split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[N+1];
		
		for(int i=1;i<=N;i++)
			dfs(i);
		
		System.out.println(ans);

	}

}
