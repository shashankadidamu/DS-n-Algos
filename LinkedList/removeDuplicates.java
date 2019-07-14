//Given a unordered linkedlist , how do you remove duplicates in it?
import java.util.*;

class Node{
	int data;
	Node next;

	public Node(int d){
		data =d;
		next=null;
	}

	public Node(){
		next=null;
	}
}

class LinkedList{
	Node head=null;
	Node end=null;
	public void insert(int d){
		Node newnode= new Node(d);

		if(head==null){
			head=newnode;
			end=head;
		}
		end.next=newnode;
		end=newnode;

	}
	public void printlist(){
		Node temp=head;

		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null"+"\n");
	}

	//remove duplicates method(brute force: Time: O(n*n), Space: O(1))
	public void removeDup(){
		
		Node duphead=head;
		while(duphead!=null){
			Node temphead = duphead.next;
			int tempdata=duphead.data;
			Node temp=duphead;
			while(temphead!=null){
				if(temphead.data==tempdata)
					temp.next=temphead.next;
				else
					temp=temphead;
				temphead=temphead.next;
			}
			duphead=duphead.next;
		}
		
	}

	//Method 2: Using hashtable. (Complexity: Time: O(n), Space: O(n))

	public void removeDupMethod2(){
		Map<Integer,Boolean> dupMap =new HashMap<Integer,Boolean>();
		Node temphead=head;
		dupMap.put(head.data,true);
		Node tempnext;
		while(temphead.next!=null){
			tempnext=temphead.next;
			if(dupMap.get(tempnext.data)!=null){
				temphead.next=tempnext.next;
			}
			else{
				dupMap.put(tempnext.data,true);
				temphead=temphead.next;
			}
		}
	}

}

class removeDuplicates{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(2);
		l1.insert(9);
		l1.insert(7);
		l1.insert(2);
		l1.insert(3);
		l1.insert(5);
		l1.insert(7);
		l1.insert(3);
		l1.insert(9);
		l1.insert(5);
		l1.insert(1);
		System.out.println("Initial List");
		l1.printlist();
		l1.removeDup();
		System.out.println("Modified List");
		l1.printlist();

		LinkedList l2= new LinkedList();
		l2.insert(2);
		l2.insert(2);
		l2.insert(2);
		l2.insert(2);
		System.out.println("Initial List");
		l2.printlist();
		l2.removeDupMethod2();
		System.out.println("Modified List");
		l2.printlist();
	}
}