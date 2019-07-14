//Algorithm for finding maximum element in binary tree


import java.util.*;

 class BTNode{
	
	public int data;
	public BTNode left,right;

	public BTNode(int data){
		this.data = data;
		left =null;
		right = null;
	}

	public int getData(){
		return data;
	}

	public void setData(int data){
		this.data = data;

	}

	public BTNode getleft(){
		return left;
	}

	public void setLeft(BTNode left){
		this.left=left;
	}

	public BTNode getright(){
		return right;
	}

	public void setRight(BTNode right){
		this.right = right;
	}

}

class bt{
	BTNode root;

	public bt(){
		root=null;
	}
	
	public void insert(int data)
     {
         root = insert(root, data);
     }
     
     /* Function to insert data recursively */
     private BTNode insert(BTNode node, int data)
     {
         if (node == null)
             node = new BTNode(data);
         else
         {
             if (data <= node.data)
                node.left = insert(node.left, data);
             else
                node.right = insert(node.right, data);
         }
         return node;
     }

     public void inordertraversalrec(BTNode root){
     	
     	if(root!=null){
     		inordertraversalrec(root.left);
     		System.out.print(root.data+"	");
     		inordertraversalrec(root.right);
     	}

     }
    
	public int maxInBTwithRecursion(){
		int a = maxInBTsupport(root);
		return a;
	}

	public int maxInBTwithoutRecursion(){
		int b = maxInBTwithoutRecursionSupport(root);
		return b;
	}

/* function to find maximum element in Binary tree with Recursion*/

	public int maxInBTsupport(BTNode root){
	int max = Integer.MIN_VALUE;
	if(root!=null){
		int leftmax = maxInBTsupport(root.left);
		int rightmax = maxInBTsupport(root.right);
		if(leftmax > rightmax){
			max = leftmax;
		}
		else
			max = rightmax;
		if(root.data> max)
			max = root.data;
	}
		return max;
	}

// function to find maximum element in Binary Tree without recursion //

	public int maxInBTwithoutRecursionSupport(BTNode root){
		int max = Integer.MIN_VALUE;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.offer(root);
		while(!q.isEmpty()){
			BTNode temp = q.poll();
			if(temp.data> max){
				max = temp.data;
			}
			if(temp!=null){
				if(temp.getleft()!=null)
					q.offer(temp.left);
				if(temp.getright()!=null)
					q.offer(temp.right);
			}
		}
		return max;

	}

	
}


public class BTMax{
	
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
			bt1.inordertraversalrec(bt1.root);
		System.out.println("\n"+"Max in BT without Recursion: "+bt1.maxInBTwithoutRecursion());
		System.out.println("\n"+"Max in BT with Recursion : "+bt1.maxInBTwithRecursion());
	}
}