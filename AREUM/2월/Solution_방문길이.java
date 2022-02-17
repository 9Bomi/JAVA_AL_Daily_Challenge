package com.pro.algo;

import java.util.HashSet;
import java.util.Set;

public class Solution_방문길이 {
	static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        Set<Point> set = new HashSet<>();
        
        int r = 0;
        int c = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char temp = dirs.charAt(i);
            
            int tempR = r + dr[getDir(temp)];
            int tempC = c + dc[getDir(temp)];
            
            if (tempR >= -5 && tempR <= 5 && tempC >= -5 && tempC <= 5) {
                set.add(getPoint(temp, r, c));
                r = tempR;
                c = tempC;
            }
        }
        
        return set.size();
    }
    
    static int getDir(char dir) {
        switch (dir) {
            case 'U' :
                return 0;
            case 'D' :
                return 1;
            case 'R' :
                return 2;
            case 'L' :
                return 3;
        }
        
        return -1;
    }
    
    static Point getPoint(char dir, int r, int c) {
        switch (dir) {
            case 'U' :
                return new Point(r + 0.5, c);
            case 'D' :
                return new Point(r - 0.5, c);
            case 'R' :
                return new Point(r, c + 0.5);
            case 'L' :
                return new Point(r, c - 0.5);
        }
        
        return null;
    }
    
    static class Point {
        double r;
        double c;
        
        Point (double r, double c) {
            this.r = r;
            this.c = c;
        }
        
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point temp = (Point) o ;
                if (r == temp.r && c == temp.c) {
                    return true;
                }
            }
            
            return false;
        }
        
        public int hashCode() {
            return (int)(this.r * 1000 + this.c * 1000.0);
        }
    }
}
