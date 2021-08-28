import java.util.Scanner;

public class BOJ_16953 {
	static int B;
	static int ans = Integer.MAX_VALUE;
	
	public static void dfs(int cnt,int num) {
		if(num>B)
			return;
		
		if(num==B) {
			if(cnt<ans)
				ans = cnt;
			return;
		}
		
		dfs(cnt+1,num*2);
		dfs(cnt+1,num*10+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		B = sc.nextInt();
		
		dfs(1,A);
		
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);

	}

}
