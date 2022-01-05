package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임 {

   static int points[];
   
   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
            
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      points = new int[N];
      
      for(int i=1; i<N; i++) {
         points[i] = i;
      }
      
      for(int i=1; i<=M; i++) {
         st = new StringTokenizer(in.readLine());
         
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
      
         if(!union(a,b)) {
            System.out.println(i);
            return;
         }
      }
      
      System.out.println(0);
      
      in.close();
   }
   
   public static int find(int num) {
      if(points[num]==num) return num;
      
      return points[num] = find(points[num]);
   }

   public static boolean union(int a, int b) {
      int parentA = find(a);
      int parentB = find(b);
      
      if(parentA == parentB) return false;
      
      points[parentA] = parentB;
      return true;
   }
}