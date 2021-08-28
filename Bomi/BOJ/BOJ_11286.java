import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_11286 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(100000,(Integer n1,Integer n2)->{
			if((Math.abs(n1)-Math.abs(n2))==0)
					return n1-n2;
			return Math.abs(n1)-Math.abs(n2);
		});
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty())
					bw.write("0\n");
				else 
					bw.write(pq.poll()+"\n");
			}
			else
				pq.add(num);
		}
		
		bw.close();
		br.close();
	}

}
