import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_7662 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			int orders = Integer.parseInt(br.readLine());
			TreeMap<Integer,Integer> tmap = new TreeMap<>();
			
			for(int j=0;j<orders;j++) {
				String ss[] = br.readLine().split(" ");
				int num = Integer.parseInt(ss[1]);
				
				if(ss[0].equals("I")) // 삽입 연산
					tmap.put(num, tmap.getOrDefault(num,0)+1);
				else {// 삭제 연산
					if(tmap.isEmpty())
						continue;
					
					int myKey = (num == -1 ? tmap.firstKey() : tmap.lastKey());
					
					if(tmap.get(myKey) == 1)
						tmap.remove(myKey);
					else
						tmap.put(myKey,tmap.get(myKey)-1);
				}
			}
			
			if(tmap.isEmpty())
				sb.append("EMPTY\n");
			else 
				sb.append(tmap.lastKey()+" "+tmap.firstKey()+"\n");
		}
		
		System.out.println(sb);
	}
}
