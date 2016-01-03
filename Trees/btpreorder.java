
import java.util.*;
class Node{
	int data;
	Node left;
	Node right;

	public Node(int d){
		data=d;
		left=null;
		right=null;
	}

	public Node(){
		left=null;
		right=null;
	}
}

class bt{
	Node root;

	public bt(){
		root=null;
	}
	
	public void insert(int data)
     {
         root = insert(root, data);
     }
     
     /* Function to insert data recursively */
     private Node insert(Node node, int data)
     {
         if (node == null)
             node = new Node(data);
         else
         {
             if (data <= node.data)
                node.left = insert(node.left, data);
             else
                node.right = insert(node.right, data);
         }
         return node;
     }

    public void preordertraversal(){
		if(root==null){
			return;
		}
		Stack<Node> s= new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()){
			Node temp = s.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				s.push(temp.right);
			if(temp.left!=null)
				s.push(temp.left);
		}
		System.out.println("");
	}

	public void inodertraversal(){
		Stack<Node> s = new Stack<Node>();
		Node currentnode= root;
		boolean done = false;
		while(!done){
			if(currentnode!=null){
				s.push(currentnode);
				currentnode=currentnode.left;
			}
			else{
				if(s.isEmpty())
					done=true;
				else{
					currentnode =s.pop();
					System.out.print(currentnode.data+"	");
					currentnode=currentnode.right;
				}
			}
		}
		System.out.println("");
	}
}




class btpreorder{
	public static void main(String[] args){
		bt bt1 = new bt();
		bt1.insert(5);
		bt1.insert(2);
		bt1.insert(8);
		bt1.insert(9);
		bt1.insert(13);
		bt1.insert(6);
		bt1.insert(10);
		bt1.insert(15);
		//bt1.insert(3);
		//System.out.println(bt1.isbalanced());
		bt1.preordertraversal();
		bt1.inodertraversal();
	}
}

