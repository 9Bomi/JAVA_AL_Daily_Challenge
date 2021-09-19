import java.io.*;
import java.util.*;

public class BOJ_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		
		int map[][] = new int[n+2][n+2];
		int sumMap[][] = new int[n+2][n+2];
		StringTokenizer st;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			int sum =0;
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum+=map[i][j];
				sumMap[i][j] = sum;
			}
		}
		
		for(int i=0;i<m;i++) {
			String ss[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(ss[0]);
			int y1 = Integer.parseInt(ss[1]);
			int x2 = Integer.parseInt(ss[2]);
			int y2 = Integer.parseInt(ss[3]);
			int sum =0;
			for(int a=Math.min(x1, x2);a<=Math.max(x1,x2);a++)
					sum +=(sumMap[a][Math.max(y1, y2)]-sumMap[a][Math.min(y1, y2)-1]);
			
			bw.write(sum+"\n");
		}
		br.close();
		bw.close();
	}

}
