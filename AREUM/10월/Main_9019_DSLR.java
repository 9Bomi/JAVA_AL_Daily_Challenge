package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019_DSLR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs(A,B));
			
		}
		
		in.close();
	}
	
	public static String bfs(int A, int B) {
		boolean isVisited[] = new boolean[10000];
		Queue<Result> queue = new LinkedList<>();
		queue.add(new Result(A, ""));
		isVisited[A] = true;
	
		while(!queue.isEmpty()) {
			Result temp = queue.poll();
			
			if(temp.num==B) return temp.res;
			
			int resN = operD(temp.num);
			if(!isVisited[resN]) {
				queue.add(new Result(resN, temp.res+"D"));
				isVisited[resN] = true;
			}
			resN = operS(temp.num);
			if(!isVisited[resN]) {
				queue.add(new Result(resN, temp.res+"S"));
				isVisited[resN] = true;
			}
			resN = operL(temp.num);
			if(!isVisited[resN]) {
				queue.add(new Result(resN, temp.res+"L"));
				isVisited[resN] = true;
			}
			resN = operR(temp.num);
			if(!isVisited[resN]) {
				queue.add(new Result(resN, temp.res+"R"));
				isVisited[resN] = true;
			}
		}
		
		return  "";
	}

	public static int operD(int n) {
		return (n*2)%10000;
	}
	
	public static int operS(int n) {
		return n==0?9999:n-1;
	}
	
	public static int operL(int n) {
		return n%1000*10+(n/1000);
	}
	
	public static int operR(int n) {
		return n%10*1000+(n/10);
	}
	
	static class Result{
		int num;
		String res;
		
		Result(int num, String res){
			this.num=num;
			this.res=res;
		}
	}
}
