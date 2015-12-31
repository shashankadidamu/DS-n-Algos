class Node{
	int data;
	Node next;

	public Node(int d){
		data =d;
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

	public void evenodd(){
		LinkedList odd=new LinkedList();
		Node temp=null;
		Node temphead=this.head;
		while(temphead!=null){
			if(temphead.data%2==0)
				temp=temphead;
			else{
				odd.insert(temphead.data);
				if(temp==null)
					head=head.next;
				else
					temp.next=temphead.next;
			}
			temphead=temphead.next;

		}
		temp.next=odd.head;
	}
}

class evenandOdd{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
		l1.insert(7);
		l1.insert(8);
		l1.insert(9);
		l1.insert(10);
		l1.printlist();
		//System.out.println("	"+l1.head.data+"	"+l1.end.data);
		l1.evenodd();
		//System.out.println("	"+l1.head.data+"	"+l1.end.data);
		l1.printlist();

	}
}