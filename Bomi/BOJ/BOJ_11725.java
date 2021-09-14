import java.io.*;
import java.util.*;

public class BOJ_11725 {//트리의 부모 찾기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
		for(int i=0;i<n+1;i++)
			grp.add(new ArrayList<>());
		
		for(int i=0;i<n-1;i++) {
			String s[] = br.readLine().split(" ");
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			grp.get(a).add(b);
			grp.get(b).add(a);
		}
		
		int parentNum[] = new int[n+1];
		boolean isVisited[] = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		isVisited[1] = true;
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				int num = queue.poll();
				
				for(int j=0;j<grp.get(num).size();j++) {
					int child = grp.get(num).get(j);
					
					if(!isVisited[child]) {
						isVisited[child] = true;
						queue.add(child);
						parentNum[child] = num;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=2;i<=n;i++) 
			sb.append(parentNum[i]+"\n");
		System.out.println(sb);
	}

}
