import java.util.*;

public class BOJ_13549 {//숨바꼭질3
	static class Point{
		int num;
		int time;
		
		Point(int num,int time){
			this.num = num;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		sc.close();
		
		if(N>=K)
			System.out.println(N-K);
		else {
			int move[] = new int[100001];
			Arrays.fill(move, -1);
			
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(N,0));
			
			while(!queue.isEmpty() && move[K]==-1) {
				Point p = queue.poll();

				//*2처리
				for(int j=p.num;j<=100000;j*=2)
					if(move[j]==-1) {
						move[j] = p.time;
						queue.add(new Point(j,p.time));
					}
					else 
						break;
				
				if(p.num+1<=100000 && move[p.num+1]==-1)
					queue.add(new Point(p.num+1,p.time+1));
				if(p.num-1>=0 && move[p.num-1]==-1)
					queue.add(new Point(p.num-1,p.time+1));
			}
			
			System.out.println(move[K]);
		}
		
	}

}
