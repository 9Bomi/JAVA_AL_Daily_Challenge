import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11403 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		char map[][] = new char[n+2][n+2];
		
		for(int i=1;i<=n;i++) {
			String s[] = br.readLine().split(" ");
			for(int j=1;j<=n;j++)
				map[i][j] = s[j-1].charAt(0);
		}
		
		int ans[][] = new int[n+2][n+2];
		Queue<Integer> que = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			boolean isVisited[] = new boolean[n+1];
			for(int j=1;j<=n;j++)
				if(map[i][j] == '1')
					que.add(j);

			while(!que.isEmpty()) {
				int size = que.size();
				
				for(int j=0;j<size;j++) {
					int num = que.poll();
					if(!isVisited[num]) {
						isVisited[num] = true;
						ans[i][num] = 1;
						for(int k=1;k<=n;k++)
							if(map[num][k] == '1')
								que.add(k);
					}
				}
			}
	
			que.clear();
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				bw.write(ans[i][j]+" ");
			bw.write("\n");
		}
		bw.close();
		br.close();
	}

}
