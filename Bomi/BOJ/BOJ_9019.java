import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9019 {
	static class Number{
		int num;
		String track;
		
		Number(int num, String s){
			this.num = num;
			this.track=s;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String s[] = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			
			boolean isVisited[] = new boolean[10000];
			Queue<Number> que = new LinkedList<>();
			isVisited[A] = true;
			que.add(new Number(A,""));
			
			while(true) {
				Number thisNumber = que.poll();
				int num = thisNumber.num;
				String line = thisNumber.track;
				if(num == B) {
					bw.write(thisNumber.track+"\n");
					break;
				}
				
				//D
				int dnum = (num*2)%10000;
				if(!isVisited[dnum]) {
					isVisited[dnum] = true;
					que.add(new Number(dnum,line+"D"));
				}
				
				//S
				int snum = num==0 ? 9999 : num-1;
				if(!isVisited[snum]) {
					isVisited[snum] = true;
					que.add(new Number(snum,line+"S"));
				}
				
				//L
				int lnum = num%1000*10+num/1000;
				if(!isVisited[lnum]) {
					isVisited[lnum] = true;
					que.add(new Number(lnum,line+"L"));
				}
				
				//R
				int rnum = num%10*1000+num/10;
				if(!isVisited[rnum]) {
					isVisited[rnum] = true;
					que.add(new Number(rnum,line+"R"));
				}
			}
						
		}
		
		br.close();
		bw.close();
	}

}
