package com.algo.hackerrank;

import java.math.BigInteger;

public class Solution_ExtraLongFactorials {
	 public static void extraLongFactorials(int n) {
	        BigInteger res = new BigInteger("1");
	        
	        for(int i=2; i<=n; i++){
	            BigInteger temp = new BigInteger(i+"");
	            res = res.multiply(temp);
	        }
	        
	        System.out.println(res);
	    }
}
