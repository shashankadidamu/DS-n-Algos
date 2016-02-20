
//Algorithm for finding the size of binary tree with and without recursion

public int size(BTNode root){
	
	int leftcount = (root.left == null ? 0 : size(root.left));
	int rightcount = (root.right == null ? 0 : size(root.right));
	return 1+leftcount+rightcount;
}

public int sizeWithoutRecursion(BTNode root){
	
	int count =0;
	if(root ==null)
		return count;

	Queue<BTNode> q = new LinkedList<BTNode>();
	q.offer(root);

	while(!q.isEmpty()){
		BTNode tmp = q.poll();
		count++;
		if(tmp.getleft()!=null)
			q.offer(q.getleft());
		if(tmp.getright()!=null)
			q.offer(q.getright());

	}
	return count;
}