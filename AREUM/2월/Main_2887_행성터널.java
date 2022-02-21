package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Point[] points = new Point[N];
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		int[] parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(x, y, z, i);
			parents[i] = i;
		}
		
		Arrays.sort(points, (o1, o2) -> o1.x - o2.x);
		for (int i = 0; i < N - 1; i++) {
			queue.add(new Node(points[i].index, points[i + 1].index, points[i + 1].x - points[i].x));
		}
		
		Arrays.sort(points, (o1, o2) -> o1.y - o2.y);
		for (int i = 0; i < N - 1; i++) {
			queue.add(new Node(points[i].index, points[i + 1].index, points[i + 1].y - points[i].y));
		}
		
		Arrays.sort(points, (o1, o2) -> o1.z - o2.z);
		for (int i = 0; i < N - 1; i++) {
			queue.add(new Node(points[i].index, points[i + 1].index, points[i + 1].z - points[i].z));
		}
		
		int answer = 0;
		
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if (union(temp.from, temp.to, parents)) {
				answer += temp.cost;
			}
		}
		
		System.out.println(answer);
		
		in.close();
	}
	
	public static int getParent(int num, int[] parents) {
		if (num == parents[num]) {
			return num;
		}
		
		return parents[num] = getParent(parents[num], parents);
	}
	
	public static boolean union(int a, int b, int[] parents) {
		int pA = getParent(a, parents);
		int pB = getParent(b, parents);
	
		if (pA == pB) {
			return false;
		}
		
		parents[pA] = pB;
		
		return true;
	}
	
	public static class Node {
		int from;
		int to;
		int cost;
		
		Node (int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static class Point {
		int x;
		int y;
		int z;
		int index;
		
		Point(int x, int y, int z, int index) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.index = index;
		}
	}
}
