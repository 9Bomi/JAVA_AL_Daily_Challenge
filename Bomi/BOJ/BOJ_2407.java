import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		BigInteger upper=new BigInteger("1");
		BigInteger down=new BigInteger("1");
		for(int i=n;i>m;i--)
			upper = upper.multiply(new BigInteger(i+""));
		for(int i=n-m;i>0;i--)
			down = down.multiply(new BigInteger(i+""));
		
		System.out.println(upper.divide(down));

	}

}
