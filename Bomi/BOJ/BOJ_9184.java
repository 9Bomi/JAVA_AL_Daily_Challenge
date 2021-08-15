import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9184 {
	static int arr[][][] = new int[21][21][21];
	
	public static int w(int a, int b, int c) {
		
		if(0<=a && a<21 && 0<=b && b<21 && 0<=c && c<21 && arr[a][b][c] !=0)
			return arr[a][b][c];
		
		if(a<=0 || b<=0 || c<=0)
			return arr[0][0][0] =  1;
		if(a>20 || b>20 || c>20)
			return arr[20][20][20] = w(20,20,20);
		if(a<b && b<c)
			return arr[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		
		return arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			if(a==-1 && b==-1 && c==-1) 
				break;
			
			int ans = w(a,b,c);
			System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,ans);
		}
		
		br.close();
	}
}
