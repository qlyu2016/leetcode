	
	public void singleRotateLeft(TreeNode root){
		TreeNode l = root.left;
		TreeNode ll = l.left;
		l.left = ll.right;
		ll.right = l;
		root.left = ll;
	}
	
	public void singleRotateRight(TreeNode root){
		TreeNode r = root.right;
		TreeNode rr = r.right;
		r.right = rr.left;
		rr.left = r;
		root.right = rr;
	}
	
	public void doubleRotateLR(TreeNode root){
		TreeNode l = root.left;
		TreeNode ll = l.left;
		TreeNode llr = ll.right;
		ll.right = llr.left;
		llr.left = ll;
		l.left = llr;
		llr.left = ll;
		singleRotateLeft(root);
	}
	
	public void doubleRotateRL(TreeNode root){
		TreeNode r = root.right;
		TreeNode rr = r.right;
		TreeNode rrl = rr.left;
		rr.left = rrl.right;
		rrl.right = rr;
		r.right = rrl;
		rrl.right = rr;
		singleRotateRight(root);
	}