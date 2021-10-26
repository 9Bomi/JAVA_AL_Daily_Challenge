package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1202_보석도둑 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		Gem gems[] = new Gem[N];
		int bags[] = new int[K];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			gems[i] = new Gem(M,V);
		}
		
		
		for(int i=0; i<K; i++) {
			bags[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(gems, (o1,o2)->o1.weight-o2.weight);
		Arrays.sort(bags);
		
		PriorityQueue<Gem> queue = new PriorityQueue<>((o1,o2)->o2.value-o1.value);
		
		
		long res = 0;
		int index = 0;
		
		for(int i=0; i<K; i++) {
			while(index<N&& bags[i]>=gems[index].weight)
				queue.add(gems[index++]);
			
			if(!queue.isEmpty()) res+=queue.poll().value;
		}
		
		System.out.println(res);
		
		in.close();
	}

	static class Gem{
		int weight;
		int value;
		
		Gem(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
	}
}
