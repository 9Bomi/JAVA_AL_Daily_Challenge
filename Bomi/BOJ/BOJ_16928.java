import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16928 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		boolean isVisited[] = new boolean[101];
		int isMove[] = new int[101];
		
		for(int i=0;i<N+M;i++) {
			String ss[] = br.readLine().split(" ");
			isMove[Integer.parseInt(ss[0])] = Integer.parseInt(ss[1]);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		isVisited[1]=true;
		queue.add(1);
		int depth=0;
		boolean isArrived = false;
		
		while(!isArrived) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				int num = queue.poll();
				
				if(num==100) {
					isArrived = true;
					break;
				}
				
				while(isMove[num]!=0) {
					num = isMove[num];
					isVisited[num] = true;
				}
					
				for(int j=1;j<=6;j++)
					if(num+j<=100 && !isVisited[num+j]) {
						isVisited[num] = true;
						queue.add(num+j);
					}
						
			}
			depth++;
		}
		
		System.out.println(depth-1);
		
	}

}
