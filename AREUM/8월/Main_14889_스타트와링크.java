package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 단계별 - 백트래킹
public class Main_14889_스타트와링크 {

	static int N;
	static int power[][];
	static int isSelected[];
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
	
		power = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isSelected=new int[N];
		isSelected[0] = 1;
		
		int cnt=0;
		while(cnt++<N/2-1) isSelected[N-cnt] = 1;
		
		res=Integer.MAX_VALUE;
		
		do {
			int teamA = 0;
			int teamB = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(isSelected[i]==1&&isSelected[j]==1) teamA+=power[i][j]+power[j][i];
					else if(isSelected[i]!=1&&isSelected[j]!=1) teamB+=power[i][j]+power[j][i];
				}
			}
			if(Math.abs(teamA-teamB)<res) res=Math.abs(teamA-teamB);

		} while(np(isSelected));
		
		System.out.println(res);
	}
	
	public static boolean np(int arr[]) {
		int n = arr.length;
		
		int i=n-1;
		while(i>0&&arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		
		int j=n-1;
		while(arr[i-1]>=arr[j]) --j;
		
		swap(arr, j, i-1);
		
		int k=n-1;
		while(k>i) swap(arr, k--, i++);
		
		return true;
	}
	
	public static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] =temp;
	}
}
