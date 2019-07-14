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
	public void insertAtEnd(int d){
		Node newnode= new Node(d);

		if(head==null){
			head=newnode;
			end=head;
		}
		end.next=newnode;
		end=newnode;

	}

	public void insertAtBeginning(int d){
		Node newnode =new Node(d);

		if(head==null){
			head=newnode;
			end=head;
		}

		newnode.next=head;
		head=newnode;
	}
	public void printlist(){
		Node temp=head;

		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null"+"\n");
	}

	public LinkedList reOrdering(int k){
		LinkedList llnew = new LinkedList();
		llnew.insertAtBeginning(k);

		Node temphead= head;
		while(temphead!=null){
			if(temphead.data<k)
				llnew.insertAtBeginning(temphead.data);
			else
				llnew.insertAtEnd(temphead.data);
			temphead=temphead.next;
		}
		return llnew;
	}
}

class partition{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insertAtBeginning(2);
		l1.insertAtEnd(9);
		l1.insertAtEnd(7);
		l1.insertAtEnd(2);
		l1.insertAtEnd(3);
		l1.printlist();
		LinkedList newlist = l1.reOrdering(4);	
		newlist.printlist();
	}
}