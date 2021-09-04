import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9019 {
	static class Number{
		StringBuilder numString = new StringBuilder();
		StringBuilder track = new StringBuilder();
		
		Number(int num, String s){
			String snum = String.format("%04d", num);
			numString.append(snum);
			
			track.append(s);
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
			
			Queue<Number> que = new LinkedList<>();
			que.add(new Number(A,""));
			String answer;
			while(true) {
				Number thisNumber = que.poll();
				int num = Integer.parseInt(thisNumber.numString.toString());
				String line = thisNumber.track.toString();
				if(num == B) {
					answer = thisNumber.track.toString();
					break;
				}
				
				//D
				que.add(new Number((num*2)%10000,line+"D"));
				
				//S
				if(num==0)
					que.add(new Number(9999,line+"S"));
				else
					que.add(new Number(num-1,line+"S"));
				
				//L
				String sn = thisNumber.numString.substring(1,4)+thisNumber.numString.substring(0,1);
				que.add(new Number(Integer.parseInt(sn),line+"L"));
				
				//R
				String snx = thisNumber.numString.substring(0,3)+thisNumber.numString.substring(3,4);
				que.add(new Number(Integer.parseInt(snx),line+"R"));
			}
			
			bw.write(answer+"\n");
			
		}
		
		br.close();
		bw.close();
	}

}
