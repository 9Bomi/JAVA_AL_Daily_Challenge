import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
	static int N;
	static int K;
	static int MAX = 100000*2;
	static int ans = Integer.MAX_VALUE;
	static int mem[] = new int[MAX];
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void walkOrTimeWarp(int depth) {
		int size = queue.size();
		if(size ==0)
			return;
		
		for(int i=0;i<size;i++) {
			int cnt = queue.poll();
			
			if(depth > ans || cnt <0 || cnt>=MAX || depth>=mem[cnt])
				continue;
			if(cnt == K && depth<ans) 
				ans = depth;
			
			mem[cnt] = depth;
			
			queue.add(cnt*2);
			queue.add(cnt+1);
			queue.add(cnt-1);
		}
		
		walkOrTimeWarp(depth+1);

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		Arrays.fill(mem, Integer.MAX_VALUE);
		queue.add(N);
		walkOrTimeWarp(0);
		System.out.println(ans);
		
		sc.close();
	}

}
