//Given a list L1->L2->...->L(n-1)->L(n), reorder it to: L1->L(n)->L2->L(n-1)->.. 

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

//Basic stack implementation
class stack{
	Node top;
	
	void push(int d){
		//hm.put(d,d);
		Node temp=new Node(d);
		temp.next=top;
		top=temp;
	}

	int pop(){
		int temp=0;
		if(top!=null){
			temp=top.data;
			top=top.next;
		}
		return temp;
	}

	int peek(){
		return top.data;
	}
}

//LinkedList 
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

	//Finding length of Linkedlist
	public int length(){
		int count=0;
		Node temp=head;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}


	public int getKth(int k){
			
		Node p1 = head;
		Node p2 = head;

		for(int i=0;i<k-1;i++){
			if(p2==null)
				return 0;
			else 
				p2 = p2.next;
		}

		while(p2.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p1.data;

	}
	public LinkedList reorder(){
		int len= 0;
		len= length();

		LinkedList newlist =new LinkedList();
		Node temphead=head;
		for(int i=1;i<=len/2;i++){
			int temp= getKth(i);
			newlist.insert(temphead.data);
			newlist.insert(temp);
			temphead=temphead.next;
		}
		if(len%2!=0)
			newlist.insert(temphead.data);
		return newlist;
	} 


	public Node getNodes(int len){
		Node temp=head;
		for(int i=1;i<len;i++){
			temp=temp.next;
		}
		return temp.next;
	}

	//Reordering using Stack
	public LinkedList newReorder(){
		int len=0;
		len=length();
		stack tempStack =new stack();
		LinkedList newlist=new LinkedList();
		Node temphead=head;
		Node temp= getNodes(len/2);
		while(temp!=null){
			tempStack.push(temp.data);
			temp=temp.next;
		}
		for(int i=1;i<=len/2;i++){
			newlist.insert(temphead.data);
			newlist.insert(tempStack.pop());
			temphead=temphead.next;
		}
		if(len%2!=0)
			newlist.insert(temphead.data);

		return newlist;
	}
}

class patternReorder{
	public static void main(String[] args){
		LinkedList l1= new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(5);
		l1.printlist();
		LinkedList l2=l1.newReorder();
		l2.printlist();
		LinkedList l3= l1.reorder();
		l3.printlist();
	}
}


/*output:
1->2->3->4->5->null
1->5->2->4->3->null
1->5->2->4->3->null
*/