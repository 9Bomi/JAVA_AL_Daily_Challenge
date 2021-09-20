import java.util.Scanner;

public class BOJ_9251 {//LCS
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();

		int R = s1.length();
		int C = s2.length();
		int lcsMap[][] = new int[R+2][C+2];
	
		for(int i=1;i<=R;i++)
			for(int j=1;j<=C;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					lcsMap[i][j] = lcsMap[i-1][j-1]+1;
				else
					lcsMap[i][j] = Math.max(lcsMap[i][j-1], lcsMap[i-1][j]);
			}
		
		System.out.println(lcsMap[R][C]);
	}
}
