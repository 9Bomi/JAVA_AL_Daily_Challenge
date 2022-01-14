package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_14867_물통 {
   
   static int a,b,c,d;

   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(in.readLine());
      
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      
      System.out.println(bfs());
      
      in.close();
   }

   static int bfs() {
      Queue<Bottles> queue = new LinkedList<>();
      Set<Integer> set[] = new HashSet[a+1];

      for(int i=0; i<a+1; i++) {
         set[i] = new HashSet<Integer>();
      }
      
      queue.add(new Bottles(0,0));
      set[0].add(0);
      
      int level = 0;
      
      while(!queue.isEmpty()) {
         int cnt = queue.size();
         
         for(int i=0; i<cnt; i++) {
            Bottles temp = queue.poll();

            if(temp.A==c&&temp.B==d) return level;
            
            //fill A
            pour(a, temp.B, queue, set);
            
            //fill B
            pour(temp.A,b, queue, set);
            
            //empty A
            pour(0, temp.B, queue, set);

            //empty B
            pour(temp.A, 0, queue, set);

            //move from A to B
            if(temp.A<=b-temp.B) {      
               pour(0,temp.A+temp.B, queue, set);
            } else {
               pour(temp.A-(b-temp.B), b, queue, set);
            }

            //move from B to A
            if(temp.B<=a-temp.A) {      
               pour(temp.A+temp.B, 0, queue, set);
            } else {
               pour(a, temp.B-(a-temp.A), queue, set);
            }
         }
         
         level++;
      }
      
      return -1;
   }
   
   static void pour(int A, int B, Queue<Bottles> queue, Set<Integer> set[]) {
      if(!set[A].contains(B)) {
         queue.add(new Bottles(A,B));
         set[A].add(B);
      }
   }
   
   static class Bottles{
      int A;
      int B;
      
      Bottles(int A, int B){
         this.A = A;
         this.B = B;
      }
   }
}