package com.algo.hackerrank;

public class Solution_Encryption {
	public static String encryption(String s) {
        s = s.replace(" ", "");
        
        int L = s.length();
        
        int x = (int)Math.floor(Math.sqrt(L));
        int y = (int)Math.ceil(Math.sqrt(L));
        if(x*y<L) x++;
        
        char[][] res = new char[x][y];
        
        int cnt=0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(cnt==L) break;
                res[i][j] = s.charAt(cnt++);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                sb.append(res[j][i]=='\u0000'?"":res[j][i]);
            }
            sb.append(" ");
        }

        return sb.toString();
    }
}
