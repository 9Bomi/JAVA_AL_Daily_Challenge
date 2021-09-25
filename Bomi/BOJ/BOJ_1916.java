import java.io.*;
import java.util.*;

public class BOJ_1916 {// 최소비용 구하기
	
	static class Edge implements Comparable<Edge>{
		int dest;
		int cost;
		
		Edge(int d,int c){
			this.dest = d;
			this.cost = c;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost,o.cost);
		}
	}

	public static void main(String[] args) throws Exception {//최소비용 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;
		
		ArrayList<Edge> adj[] = new ArrayList[N+1];
		for(int i=1;i<=N;i++)
			adj[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Edge(to,price));
		}
		
		int dist[] = new int[N+1];
		Arrays.fill(dist, INF);
		boolean visited[] = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		dist[from] =0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(from,0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.dest])
				continue;
			else
				visited[edge.dest] = true;
			
			for(Edge e : adj[edge.dest]) 
				if(dist[e.dest] > dist[edge.dest]+e.cost) {
					dist[e.dest] = dist[edge.dest]+e.cost;
					pq.add(new Edge(e.dest,dist[e.dest]));
				}
		}
		
		System.out.println(dist[to]);
	}

}
