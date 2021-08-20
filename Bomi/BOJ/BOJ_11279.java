import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11279 {
	static int maxHeap[] = new int[200001];
	
	public static void swap(int a,int b) {
		int temp = maxHeap[a];
		maxHeap[a] = maxHeap[b];
		maxHeap[b] = temp;
	}
	
	public static int returnMax(int i) {
		int baseNum = maxHeap[i];
		if(maxHeap[i*2]>baseNum && maxHeap[i*2+1]>baseNum) {
			if(maxHeap[i*2] > maxHeap[i*2+1])
				return i*2;
			return i*2+1;
		}
		else if(maxHeap[i*2]>baseNum)
			return i*2;
		else if(maxHeap[i*2+1]>baseNum)
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
			
			if(num == 0) {	//가장 큰 값 출력 후 제거
				bw.write(maxHeap[1]+"\n");//가장 큰 값 출력
				if(idx == 1)//아무것도 없는 경우
					continue;
				maxHeap[1] = maxHeap[--idx];	// 루트에 말단값 삽입
				maxHeap[idx] = 0;	//말단 노드 삭제 후 인덱스 변경
				int base =1;
				
				while(base<idx) {//내려가면서 스왑
					int nextIdx = returnMax(base);
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
				maxHeap[idx++] = num;
				
				while(base != 1) {
					int baseNum = maxHeap[base];
					if(maxHeap[base/2]<baseNum) {
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
