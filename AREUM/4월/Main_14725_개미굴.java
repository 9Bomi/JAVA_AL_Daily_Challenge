package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_14725_개미굴 {
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Trie root = new Trie("");
		
		for (int i = 0; i < N; i++) {
			String[] caves = in.readLine().split(" ");
			
			int cnt = Integer.parseInt(caves[0]);
			Trie current = root;
			
			for (int j = 1;  j <= cnt; j++) {
				String value = caves[j];
				int index = -1;
				
				for (int k = 0; k < current.list.size(); k++) {
					if (current.list.get(k).value.equals(value)) {
						index = k;
						break;
					}
				}
				
				if (index == -1) {
					current.list.add(new Trie(value));
					current = current.list.get(current.list.size() - 1);
				} else {
					current = current.list.get(index);
				}
			}
		}
		
		find(root, -1);

		System.out.println(sb);
		
		in.close();
	}
	
	static void find(Trie trie, int index) {
		Collections.sort(trie.list, (o1, o2) -> o1.value.compareTo(o2.value));
	
		if (index != -1) {
			sb.append(String.join("", Collections.nCopies(index, "--"))).append(trie.value).append("\n");
		}
		
		for (Trie next : trie.list) {
			find(next, index + 1);
		}
	}
	
	static class Trie {
		String value;
		ArrayList<Trie> list;
		
		Trie(String value) {
			list = new ArrayList<>();
			this.value = value;
		}
	}
}
