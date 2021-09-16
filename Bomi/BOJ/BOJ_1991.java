import java.util.Scanner;

class Node{
	Node lChild;
	Node rChild;
	char c;
	
	Node(char c){
		this.c = c;
	}
}

class Tree{
	Node root;
	
	public void Add(char Data, char lData, char rData) {
		if(root == null) {
			if(Data != '.')
				root = new Node(Data);
			if(lData != '.')
				root.lChild = new Node(lData);
			if(rData != '.')
				root.rChild = new Node(rData);
		}
		else 
			Search(root,Data,lData,rData);
	}
	
	public void Search(Node root,char Data,char lData, char rData) {
		if(root == null)
			return;
		
		if(root.c == Data) {
			if(lData != '.')
				root.lChild = new Node(lData);
			if(rData != '.')
				root.rChild = new Node(rData);
		}
		else {
			Search(root.lChild,Data,lData,rData);
			Search(root.rChild,Data,lData,rData);
		}
	}
	
	public void preOrder(Node root) {
		System.out.print(root.c);
		if(root.lChild!=null)
			preOrder(root.lChild);
		if(root.rChild!=null)
			preOrder(root.rChild);
	}
	
	public void inOrder(Node root) {
		if(root.lChild!=null)
			inOrder(root.lChild);
		System.out.print(root.c);
		if(root.rChild!=null)
			inOrder(root.rChild);
	}
	
	public void postOrder(Node root) {
		if(root.lChild!=null)
			postOrder(root.lChild);
		if(root.rChild!=null)
			postOrder(root.rChild);
		System.out.print(root.c);
	}
}

public class BOJ_1991  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Tree tree = new Tree();
		for(int i=0;i<N;i++) 
			tree.Add(sc.next().charAt(0), sc.next().charAt(0), sc.next().charAt(0));
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		
	}
}
