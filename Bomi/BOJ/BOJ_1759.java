import java.io.*;
import java.util.*;

public class BOJ_1759 {//암호 만들기
	static int L;
	static int C;
	static String chars[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean visited[];
	static String aiueo = "aiueo";
	static void dfs(int cnt,int len, int count) throws IOException {
		if(cnt == C) {
			if(len == L && 0<count && count <= L-2) {
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<C;i++)
					if(visited[i])
						sb.append(chars[i]);
				
				bw.append(sb+"\n");
			}
			return;
		}
		
		visited[cnt] = true;
		if(aiueo.contains(chars[cnt]))//모음이면
			dfs(cnt+1,len+1,count+1);
		else
			dfs(cnt+1,len+1,count);
		visited[cnt] = false;
		
		dfs(cnt+1,len,count);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		chars = br.readLine().split(" ");
		visited = new boolean[C];
		Arrays.sort(chars);
		
		dfs(0,0,0);
		
		bw.close();
		br.close();
	}

}
