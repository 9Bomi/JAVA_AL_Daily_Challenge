package com.pro.algo;

import java.util.HashSet;

public class Solution_교점에별만들기 {
	public String[] solution(int[][] line) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        HashSet<Point> set = new HashSet<>();
        
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                Point temp = calc(i, j, line);
                if(temp==null) continue;
                
                System.out.println(temp.x+" "+temp.y);
                minX = Math.min(minX, temp.x);
                minY = Math.min(minY, temp.y);
                maxX = Math.max(maxX, temp.x);
                maxY = Math.max(maxY, temp.y);
                
                set.add(temp);
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        String res[] = new String[maxY-minY+1];
        int cnt=0;
        
        for(int i=maxY; i>=minY; i--){
            for(int j=minX; j<maxX+1; j++){
                Point temp = new Point(j,i);
                if(set.contains(temp)) sb.append("*");
                else sb.append(".");
            }
            
            res[cnt++]=sb.toString();
            sb.setLength(0);
        }
        
        return res;
    }
    
    static Point calc(int i, int j, int[][] line) {
        long a = line[i][0];
        long b = line[i][1];
        long e = line[i][2];
        long c = line[j][0];
        long d = line[j][1];
        long f = line[j][2];
        
        if(a*d-b*c==0 || (b*f-d*e)%(a*d-b*c)!=0 || (c*e-a*f)%(a*d-b*c)!=0) return null;
        
        long x = (b*f-d*e)/(a*d-b*c);
        long y = (c*e-a*f)/(a*d-b*c);
        
        return new Point((int)x, (int)y);
    }
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        
        public boolean equals(Object p){
            if (this == p)
                return true;
            if (!(p instanceof Point))
                return false;
            
            Point point = (Point) p;
            return this.x == point.x && this.y ==point.y;
        }
        
        public int hashCode(){
            return this.x*1000+ this.y*1000;
        }
    }
}
