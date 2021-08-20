import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1927 {
	static int minHeap[] = new int[200001];
	
	public static void swap(int a,int b) {
		int temp = minHeap[a];
		minHeap[a] = minHeap[b];
		minHeap[b] = temp;
	}
	 
	public static int returnMin(int i, int idx) {
		int baseNum = minHeap[i];

		if(i*2<idx && i*2+1<idx && minHeap[i*2]<baseNum && minHeap[i*2+1]<baseNum) {
			if(minHeap[i*2] < minHeap[i*2+1])
				return i*2;
			return i*2+1;
		}
		else if(i*2<idx && minHeap[i*2]<baseNum)
			return i*2;
		else if(i*2+1<idx && minHeap[i*2+1]<baseNum)
			return i*2+1;
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int idx =1;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {	
				bw.write(minHeap[1]+"\n");
				if(idx == 1)
					continue;
				minHeap[1] = minHeap[--idx];	
				minHeap[idx] = 0;	
				int base =1;
				
				while(base<idx) {//내려가면서 스왑
					int nextIdx = returnMin(base,idx);
					if(nextIdx == -1)
						break;
					else {
						swap(nextIdx,base);
						base = nextIdx;
					}
				}
			}
			else {	// 추가 연산
				int base = idx;
				minHeap[idx++] = num;
				
				while(base != 1) {
					int baseNum = minHeap[base];
					if(minHeap[base/2]>baseNum) {
						swap(base/2,base);
						base /= 2;
					}
					else
						break;
				}
			}
		}
		
		br.close();
		bw.close();

	}

}
