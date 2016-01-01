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


	public Node modularNode(int k){
		int i=1;
		Node temphead=head;
		Node modNode = null;
		while(temphead!=null){
			if(i%k==0){
					modNode=temphead;
			}
			temphead=temphead.next;
			i++;
		}
		return modNode;
	}
}

class findModularNode{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
		l1.printlist();
		Node temp= l1.modularNode(3);
		System.out.println(temp.data);
	}
}
