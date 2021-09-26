import java.util.*;

public class BOJ_12851 {//숨바꼭질2

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		if(N>=K)
			System.out.print(N-K+"\n1");
		else {
			int dp[] = new int[100001];
			Arrays.fill(dp, -1);
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(N);
			int time =0;
			int count =0;
			
			while(true) {
				int size = queue.size();
				
				for(int i=0;i<size;i++) {
					int num = queue.poll();
					if(num==K)
						count++;
					
					if(dp[num] == -1) 
						dp[num] = time;
						
					if(num-1>=0 && dp[num-1] == -1)
						queue.add(num-1);
					if(num+1<=100000 && dp[num+1] == -1)
						queue.add(num+1);
					if(num*2<=100000 && dp[num*2] == -1)
						queue.add(num*2);
					
				}
				
				if(dp[K] != -1 )
					break;
					
				time++;
			}
			System.out.println(dp[K]+"\n"+count);
		}
	}
}
