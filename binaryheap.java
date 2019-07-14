
public class Heap{
	
	public int[] array;
	public int count;
	public int capacity;
	public int heap_type;
	public Heap(int capacity,int heap_type);
	public Parent(int i);
	public int leftchild(i);
	public int rightchild(i);
	public int getmaximum();


	public int parent(int i){
		if(i<0 || i>=this.count)
			return -1;
		return i-1/2;
	}

	public int leftchild(int i){
		int left = 2*i+1;
		if(left >= this.count)
			return -1;
		return left;
	}

	public int rightchild(int i){
		int right = 2*i+2;
		if(right>=this.count)
			return -1;
		return right;
	}

	public int getmaximum(){
		if(this.count == 0)
			return -1;
		return this.array[0];
	}

	public void percolateDown(int i){
		int l,r,max,temp;
		l= leftchild(i);
		r = rightchild(i);
		if(l!=-1 && this.array[l]>this.array[i])
			max = l;
		else
			max =i;
		if(r!=-1 && this.array[r]> this.array[max])
			max = r;
		if(max!=i){
			temp = this.array[i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
		}
		percolateDown(max);
	}

	int delete(){
		if(this.count==0)
			return -1;
		int data = this.array[0];
		this.array[0] = this.array[count-1];
		this.count--;
		percolateDown(0);
		return data;
	}
}