import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int nums[] = new int[N+1];
		
		s = br.readLine().split(" ");
		for(int i=1;i<=N;i++) 
			nums[i] = Integer.parseInt(s[i-1])+nums[i-1];
		
		for(int i=0;i<M;i++) {
			String ss[] = br.readLine().split(" ");
			
			int from = Integer.parseInt(ss[0])-1;
			int to = Integer.parseInt(ss[1]);
			int ans = nums[to]-nums[from];
			bw.write(ans+"\n");
		}
		
		br.close();
		bw.close();
	}

}
