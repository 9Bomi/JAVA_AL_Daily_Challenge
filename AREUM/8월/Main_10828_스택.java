package com.baek.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Stack stack = new Stack();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			switch(st.nextToken()) {
			case "push" :
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "top" :
				System.out.println(stack.top());
				break;
			case "size" :
				System.out.println(stack.size);
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "empty" :
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			}
		}
	}

	public static class Stack {
		static Node top;
		int size = 0;
		
		int data;
		Node link;
		
		
		public boolean isEmpty() {
			if (size==0) return true;
			else return false;
		}
		
		public void push(int data) {
			top = new Node(data, top);
			size++;
		}
		
		public int pop() {
			if(size==0) return -1;
			Node temp = top;
			top = top.link;
			temp.link=null;
			size--;
			return temp.data;
		}
		
		public int top() {
			if(size==0) return -1;
			else return top.data;
		}
		
	}
	
	public static class Node{
		int data;
		Node link;
		
		Node(int data, Node link){
			this.data=data;
			this.link=link;
		}

	}
}
