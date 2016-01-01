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
		end.next=head;

	}
	public void printlist(int m){
		Node temp=head;
		int i=0;
		while(i<m-1){
			i++;
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		System.out.print("null"+"\n");
	}
	public int length(){
		int count=0;
		Node temp=head;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}

	public void josephcircle(int n,int m){
		Node temphead=head;
		Node prev=null;
		//int i=0;
		Node temp;
		while(n>m-1){

			for(int j=1;j<m;j++){
				prev=temphead;
				temphead=temphead.next;

			}
			if(temphead==head){
				head=head.next;
			}
			prev.next=temphead.next;
			temphead=temphead.next;
			n=n-1;


		}

	}

}

class findLeader{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		
		l1.josephcircle(5,2);
		//LinkedList l2=l1.newReorder();
		l1.printlist(2);
		//LinkedList l3= l1.reorder();
		//l3.printlist();
	}
}

