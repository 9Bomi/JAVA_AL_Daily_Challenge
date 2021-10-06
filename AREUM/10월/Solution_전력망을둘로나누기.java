package com.pro.algo;

class Solution_전력망을둘로나누기 {
    static int tops[];
    
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        tops = new int[n+1]; 

        
        for(int i=0; i<wires.length; i++) {
            for(int j=1; j<=n; j++){
                tops[j] = j;
            }
            
            for(int j=0; j<wires.length; j++) {
                if(i==j) continue;
                
                
                union(wires[j][0], wires[j][1]);
            }
            
            int first= getParent(1);
            int one=1;
            int two=0;
            
            for(int j=2; j<=n; j++){
                if(getParent(j)==first) one++;
                else two++;
            }

            if(Math.abs(one-two)<min) {
                min= Math.abs(one-two);
            }
        }
        
        return min;
    }
    
    public static int getParent(int a){
        if(tops[a]==a) return a;
        
        return tops[a] = getParent(tops[a]);
    }
    
    public static boolean union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);
        
        if(parentA==parentB) return false;
        
        tops[parentB]= parentA;
        return true;
    }
}