
//Give an algorithm for inserting an element into Binary Tree

public BTNode insertInBT(BTNode root,int data){
	
	if(root == null)
		return null;

	Queue<BTNode> q = new LinkedList<BTNode>();
	q.offer(root);

	while(!q.isEmpty()){
		BTNode tmp = q.poll();
		if(tmp!=null){
			if(tmp.getleft()!=null){
				q.offer(tmp.getleft());
			}
			else{
				tmp.left=new BTNode(data);
				return root;
			}
			if(tmp.getright()!=null)
				q.offer(tmp.getright());
			else{
				tmp.right = new BTNode(data);
				return root;
			}
		}
	}
	return root;
}