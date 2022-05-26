package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2533_사회망서비스 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Person[] list = new Person[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new Person(i);
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			list[left].friends.add(right);
			list[right].friends.add(left);
		}
		
		boolean[] isVisited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			if (isVisited[i]) {
				continue;
			}
			
			dfs(i, list, isVisited);
		}
		
		System.out.println(answer);
		
		in.close();
	}
	
	static boolean dfs(int index, Person[] list, boolean[] isVisited) {
		isVisited[index] = true;
		
		boolean hasChild = false;
		
		for (int friend : list[index].friends) {
			if (!isVisited[friend]) {
				if (dfs(friend, list, isVisited)) {
					hasChild = true;
				}
			}
		}
		
		if (hasChild) {
			answer++;
			return false;
		} else {
			return true;
		}
	}

	static class Person {
		int index;
		List<Integer> friends;
		
		Person(int index) {
			this.index = index;
			this.friends = new ArrayList<>();
		}
	}
}
