//Given a list, Rotate the list to the right by K places.

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

	public void rotateByK(int k){
		Node temphead= head;
		Node currenthead=head;
		Node tempend=null;
		for(int i=0;i<k-1;i++){
			if(temphead!=null)
				temphead=temphead.next;
		}
		while(temphead.next!=null){
			temphead=temphead.next;
			tempend=currenthead;
			currenthead=currenthead.next;

		}
		temphead.next=head;
		head=currenthead;
		tempend.next=null;
		end=tempend;

	}
	public void printlist(){
		Node temp=head;

		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null"+"\n");
	}
}

class rotate{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		//l1.insert(5);
		l1.printlist();
		l1.rotateByK(2);
		l1.printlist();
	}
}