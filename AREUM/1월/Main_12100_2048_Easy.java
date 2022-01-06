package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048_Easy {
   
   static final int UP=0, DOWN=1, RIGHT=2, LEFT=3;
   static int N, res=0;
   static int dr[] = {-1,1,0,0};
   static int dc[] = {0,0,-1,1};

   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      N = Integer.parseInt(in.readLine());
      
      int map[][] = new int[N][N];
      
      for(int i=0; i<N; i++) {
         st = new StringTokenizer(in.readLine());
      
         for(int j=0; j<N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            res = Math.max(map[i][j], res);
         }
      }


      comb(0, map);
      
      System.out.println(res);
      
      in.close();
   }
   
   public static void print(int map[][]) {
	   for(int i=0; i<N; i++) {
	         for(int j=0; j<N; j++) {
	            System.out.print(map[i][j]+" ");
	         }
	         System.out.println();
	      }
   }
   
   public static void comb(int cnt, int map[][]) {
      if(cnt==5) {
         for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               res = Math.max(res, map[i][j]);
            }
         }
         return;
      }
      
      for(int i=0; i<4; i++) {
         switch(i) {
            case UP: 
               comb(cnt+1, moveUp(map));
               break;
            case DOWN:
               comb(cnt+1, moveDown(map));
               break;
            case RIGHT:
               comb(cnt+1, moveRight(map));
               break;
            case LEFT:
               comb(cnt+1, moveLeft(map));
               break;
         }
      }
   }
   
   public static int[][] moveUp(int map[][]) {
      int output[][] = new int[N][N];
      for(int i=0; i<N; i++) {
         int current = 0;
         int past =0;
         for(int j=0; j<N; j++) {
            if(map[j][i]!=0) {
            	if(past==0) {
            		past= map[j][i];
            	} else if(map[j][i]==past) {
                  output[current++][i] = past*2;
                  past=0;
               } else {
            	   output[current++][i] = past;
            	   past= map[j][i];
               }
            }
         }
         
         if(past!=0) {
        	 output[current++][i] = past;
         }
      }
      
      return output;
   }
   
   public static int[][] moveDown(int map[][]) {
      int output[][] = new int[N][N];
      for(int i=0; i<N; i++) {
         int current = N-1;
         int past = 0;
         for(int j=N-1; j>=0; j--) {
        	 if(map[j][i]!=0) {
             	if(past==0) {
             		past= map[j][i];
             	} else if(map[j][i]==past) {
                   output[current--][i] = past*2;
                   past=0;
                } else {
             	   output[current--][i] = past;
             	   past= map[j][i];
                }
             }
         }
         
         if(past!=0) {
        	 output[current--][i] = past;
         }
      }
      
      return output;
   }
   
   public static int[][] moveRight(int map[][]) {
      int output[][] = new int[N][N];
      for(int i=0; i<N; i++) {
         int current = N-1;
         int past =0;
         for(int j=N-1; j>=0; j--) {
        	 if(map[i][j]!=0) {
              	if(past==0) {
              		past= map[i][j];
              	} else if(map[i][j]==past) {
              		output[i][current--] = past*2;
                    past=0;
                 } else {
                	 output[i][current--] = past;
              	   past= map[i][j];
                 }
              }
         }
         
         if(past!=0) {
        	 output[i][current--] = past;
         }
      }
      
      return output;
   }
   
   public static int[][] moveLeft(int map[][]) {
      int output[][] = new int[N][N];
      for(int i=0; i<N; i++) {
         int current = 0;
         int past = 0;
         for(int j=0; j<N; j++) {
        	 if(map[i][j]!=0) {
        	 if(past==0) {
           		past= map[i][j];
           	} else if(map[i][j]==past) {
           		output[i][current++] = past*2;
                 past=0;
              } else {
             	 output[i][current++] = past;
           	   	past= map[i][j];
              }
         }
         }
         
	     if(past!=0) {
	     	 output[i][current++] = past;
	     }
      }
      
      return output;
   }

}