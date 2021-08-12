import java.util.Scanner;
import java.math.BigInteger;

public class BOJ_10757 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		sc.close();
		
		BigInteger A = new BigInteger(s1);
		BigInteger B = new BigInteger(s2);
		
		A = A.add(B);
		
		System.out.println(A.toString());
	}
}
