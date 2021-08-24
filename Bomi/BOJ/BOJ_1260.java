import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean visited[];
	static StringBuilder sb;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void dfs(int cnt) {
		
		if(!visited[cnt]) {
			sb.append(cnt+" ");
			visited[cnt] = true;
			
			Collections.sort(graph.get(cnt));
			for(int i=0;i<graph.get(cnt).size();i++)
				dfs(graph.get(cnt).get(i));
		}
	}
	
	public static void bfs(int cnt) {
		
		int size = queue.size();
		
		if(size == 0 || cnt == N)
			return;
		
		for(int i=0;i<size;i++) {
			int num = queue.poll();
			
			if(!visited[num]) {
				sb.append(num+" ");
				visited[num] = true;
				
				Collections.sort(graph.get(num));
				for(int j=0;j<graph.get(num).size();j++)
					queue.add(graph.get(num).get(j));
			}
		}
		
		bfs(cnt+1);
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0;i<=N;i++)
			graph.add(new ArrayList<>());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		sb = new StringBuilder();
		visited = new boolean[N+1];
		dfs(start);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visited = new boolean[N+1];
		queue.add(start);
		bfs(0);
		System.out.println(sb);
		
		br.close();
	}

}
