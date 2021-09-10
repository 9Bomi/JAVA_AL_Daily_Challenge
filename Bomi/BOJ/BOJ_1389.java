import java.io.*;
import java.util.*;

public class BOJ_1389 {
	
	static class People{
		int kbnum =0;
		int idx;
		
		People(int n){
			this.idx = n;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//사람의 수
		int M = Integer.parseInt(st.nextToken());	//간선의 수
		int INF = 100000;
		int kb[][] = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) 
			for(int j=1;j<=N;j++) 
				if(i!=j)
					kb[i][j] = INF;
		
		for(int i=0;i<M;i++) {
			String s[] = br.readLine().split(" ");
			int a= Integer.parseInt(s[0]);
			int b= Integer.parseInt(s[1]);
			
			kb[a][b] = 1;
			kb[b][a] = 1;
		}
		
		for(int k=1;k<=N;k++)
			for(int i=1;i<=N;i++)
				for(int j=1;j<=N;j++)
					if(kb[i][j]> kb[i][k] + kb[k][j])
						kb[i][j] = kb[i][k] + kb[k][j];
		
		ArrayList<People> al = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			People p = new People(i);
			
			for(int j=1;j<=N;j++)
				if(kb[i][j]!=INF)
					p.kbnum+=kb[i][j];
			
			al.add(p);
		}
		
		Collections.sort(al,(p1,p2)->{
			if(p1.kbnum == p2.kbnum)
				return p1.idx-p2.idx;
			return p1.kbnum-p2.kbnum;
		});
		
		People temp = al.get(0);
		
		System.out.println(temp.idx);
		
		br.close();

	}

}
