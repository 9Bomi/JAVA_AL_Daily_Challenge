package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_7432_디스크트리 {
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Trie root = new Trie("");
		
		for (int i = 0; i < N; i++) {
			String[] dirs = in.readLine().split("\\\\");
			
			Trie current = root;
			
			for (String value : dirs) {
				boolean success = false;
				for (Trie next : current.list) {
					if (next.value.equals(value)) {
						current = next;
						success = true;
						break;
					}
				}
				
				if (!success) {
					Trie trie = new Trie(value);
					current.list.add(trie);
					current = trie;
				}
			}
		}
		
		print(root, 0);
		
		System.out.println(sb);
		
		in.close();
	}
	
	static void print(Trie trie, int depth) {
		if (depth != 0) {			
			sb.append(String.join("", Collections.nCopies(depth - 1, " "))).append(trie.value + "\n");
		}
		
		Collections.sort(trie.list, (o1, o2) -> o1.value.compareTo(o2.value));
		
		for (Trie next : trie.list) {
			print(next, depth + 1);
		}
	}

	static class Trie {
		String value;
		ArrayList<Trie> list;
	
		Trie(String value) {
			this.value = value;
			list = new ArrayList<>();
		}
	}
}
