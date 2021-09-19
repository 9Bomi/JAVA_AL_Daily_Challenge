
import java.io.*;

class Node{
	int num;
	Node lChild;
	Node rChild;
	
	Node(int num){
		this.num = num;
	}
}

class Tree{
	static Node root;
	
	public static void insert(Node node) {
		if(root == null) {
			root = node;
			return;
		}
		
		Node temp = root;
		while(true) {
			
			if(temp.num>node.num){//left
				if(temp.lChild == null) {
					temp.lChild = node;
					return;
				}
				temp = temp.lChild;
			}
			
			if(temp.num<node.num) {//right
				if(temp.rChild == null) {
					temp.rChild = node;
					return;
				}
				temp = temp.rChild;
			}
		}
	}
	
	public static void postOrder(Node node){
		if(node.lChild!=null)
			postOrder(node.lChild);
		if(node.rChild!=null)
			postOrder(node.rChild);
		System.out.println(node.num);
	}
}


public class BOJ_5639 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		Tree tree = new Tree();
		while((s = br.readLine())!=null && !s.equals("")) {
			int num =Integer.parseInt(s);
			Tree.insert(new Node(num));
		}
		
		Tree.postOrder(tree.root);
	}

}
