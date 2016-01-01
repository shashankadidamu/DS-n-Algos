//Merge two Sorted Linkedlists into third list in sorted order 

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

	
}

class mergeSortedLists{

	public static LinkedList sortedMerge(Node l1,Node l2){
		Node temphead1 = l1;
		Node temphead2 = l2;
		LinkedList result = new LinkedList();
		while(temphead1!=null && temphead2!=null){
			if(temphead1.data<=temphead2.data){
				result.insert(temphead1.data);
				temphead1=temphead1.next;
			}
			else{
				result.insert(temphead2.data);
				temphead2=temphead2.next;
			}
		}
		if(temphead1!=null || temphead2!=null ){
			while(temphead1!=null){
			result.insert(temphead1.data);
			temphead1=temphead1.next;
			}
			while(temphead2!=null){
				result.insert(temphead2.data);
				temphead2=temphead2.next;
			}
		}
		return result;
	}

	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList resultlist= new LinkedList();
		l1.insert(1);
		l1.insert(3);
		l1.insert(6);
		l2.insert(4);
		l2.insert(5);
		l1.printlist();
		l2.printlist();
		resultlist= sortedMerge(l1.head,l2.head);
		resultlist.printlist();
		
	}
}