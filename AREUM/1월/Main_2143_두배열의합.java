package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2143_두배열의합 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int T = Integer.parseInt(in.readLine());
      
      int n = Integer.parseInt(in.readLine());
      st = new StringTokenizer(in.readLine());
      int A[] = new int[n];
      
      for(int i=0; i<n; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }
      
      int m = Integer.parseInt(in.readLine());
      st = new StringTokenizer(in.readLine());
      int B[] = new int[m];
      
      for(int i=0; i<m; i++) {
         B[i] = Integer.parseInt(st.nextToken());
      }
      
      int subA[] = makeSub(A, n);
      int subB[] = makeSub(B, m);
      
      Arrays.sort(subB);
      
      long res=0;
      
      for(int i=0; i<subA.length; i++) {
         int target = T-subA[i];
    	 int left = lower(target, subB);
         int right = upper(target, subB);
    	 
         if(left!=-1) res+=right-left+1;
      }
      
      System.out.println(res);
      
      in.close();
   }
   
   public static int lower(int target, int sub[]) {
	   int res = -1;
	   int left = 0;
       int right = sub.length-1;
       
       while(left<=right) {
      	 int mid = (left+right)/2;
      	 
      	 if(sub[mid]==target) {
      		 res = mid;
      		 right=mid-1;
      	 }else if(sub[mid]>target) {
      		 right = mid-1;
      	 }else {
      		 left = mid+1;
      	 }
       }
       
       return res;
   }
   
   public static int upper(int target, int sub[]) {
	   int res = -1;
	   int left = 0;
       int right = sub.length-1;
       
       while(left<=right) {
      	 int mid = (left+right)/2;
      	 
      	 if(sub[mid]==target) {
      		 res = mid;
      		 left=mid+1;
      	 }else if(sub[mid]>target) {
      		 right = mid-1;
      	 }else {
      		 left = mid+1;
      	 }
       }
       
       return res;
   }
   
   public static int[] makeSub(int array[], int N) {
      int sub[] = new int[N*(N+1)/2];
      
      int cnt=0;
      
      for(int i=0; i<N; i++) {
    	 int past=0;
         for(int j=i; j<N; j++) {
            sub[cnt] = past+array[j];
            past=sub[cnt++];
         }
      }
      
      return sub;
   }
}