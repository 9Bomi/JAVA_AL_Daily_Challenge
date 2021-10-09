package com.baek.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		Tree tree = new Tree();
		
		StringTokenizer st;;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());

			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.insert(data, left, right);
		}
		
		StringBuilder sb= new StringBuilder("");
		tree.front(tree.root, sb);
		sb.append("\n");
		tree.middle(tree.root, sb);
		sb.append("\n");
		tree.end(tree.root, sb);

		System.out.println(sb);
		
		in.close();
	}
	
	static class Node{
		char data;
		Node left;
		Node right;
		
		Node(char data){
			this.data = data;
		}
	}

	static class Tree{
		Node root;
		
		public void insert(char data, char left, char right) {
			if(root == null) {
				root = new Node(data);
				if(left!='.') root.left = new Node(left);
				if(right!='.') root.right = new Node(right);
			} else {
				search(root, data, left, right);
			}
		}
		
		public void search(Node root, char data, char left, char right) {
			if(root==null) {
				return;
			}
			if(root.data == data) {
				if(left!='.') root.left = new Node(left);
				if(right!='.') root.right = new Node(right);
			}else {
				search(root.left, data, left, right);
				search(root.right, data, left, right);
			}
		}
		
		public void front(Node root, StringBuilder sb) {
			sb.append(root.data);
			if(root.left!=null) front(root.left, sb);
			if(root.right!=null) front(root.right, sb);
			
		}
		
		public void middle(Node root, StringBuilder sb) {
			if(root.left!=null) middle(root.left, sb);
			sb.append(root.data);
			if(root.right!=null) middle(root.right, sb);
			
		}
		
		public void end(Node root, StringBuilder sb) {
			if(root.left!=null) end(root.left, sb);
			if(root.right!=null) end(root.right, sb);
			sb.append(root.data);
			
		}
	}
}
