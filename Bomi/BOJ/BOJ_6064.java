import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6064 {
	
	public static int gcd(int a, int b) {
	    while(b > 0) {
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			int M = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]);
			int y = Integer.parseInt(s[3]);
			int gcd = gcd(M,N);
			int lcm = M*N/gcd;
			
			int sy =1;
			int idx =0;
			int count =0;
			boolean isValid = false;
			while(true){
				count = x+M*idx;
				if(count>lcm)
					break;
				sy = (count-1)%N+1;
				if(sy == y) {
					isValid = true;
					break;
				}
				idx++;
			}
			
			if(isValid)
				bw.write(count+"\n");
			else
				bw.write(-1+"\n");
		}
		
		br.close();
		bw.close();
	}

}
