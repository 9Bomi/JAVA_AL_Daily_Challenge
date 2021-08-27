import java.util.Scanner;

public class BOJ_5525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//Pn에서의 n
		int M = sc.nextInt();	//s의 길이
		String s = sc.next();	
		sc.close();
		
		int ans =0;
		int count =0;	//Pn의 n이 얼마인지.. 
		int idx =0;
		while(idx<M) {
			if(s.charAt(idx) == 'I') //I를 만나면 확인 시작
				while(idx<M-2 && s.substring(idx+1, idx+3).equals("OI")) {//다음 2개가 OI인지 확인
					count++;
					idx+=2;
				}
				
			if(count!=0) {
				if(count >= N) 
					ans += count-N+1;
				count=0;	//count 초기화
			}
			
			idx++;
		}
		
		System.out.println(ans);

	}

}
