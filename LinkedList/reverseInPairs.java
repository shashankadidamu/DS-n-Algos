//Reverse LinkedList in Pairs

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

	public void reversepairs(){
		Node temphead =head;
		Node prev=null;
		Node temp=null;
		System.out.println(head.data);
		while(temphead!=null && temphead.next!=null){
			if(temphead==head){
				head=temphead.next;
			}
			temp=temphead.next;
			temphead.next=temphead.next.next;
			temp.next=temphead;
			if(prev!=null){
				prev.next=temp;
			}
			prev=temphead;
			temphead=temphead.next;

		}
	}
}

class reverseInPairs{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.printlist();
		l1.reversepairs();
		l1.printlist();
		
	}
}