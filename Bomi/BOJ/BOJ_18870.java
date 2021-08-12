import java.io.*;
import java.util.*;

public class BOJ_18870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int arrTemp[] = arr.clone();
		Arrays.sort(arrTemp);
		Map<Integer,Integer> hmap = new HashMap<>();

		for(int i=0,count=0;i<N;i++)
			if(!hmap.containsKey(arrTemp[i]))
				hmap.put(arrTemp[i], count++);
		
		for(int i=0;i<N;i++)
			bw.write(hmap.get(arr[i])+" ");
		
		bw.close();
		br.close();
	}
}
