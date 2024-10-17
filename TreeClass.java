package treeexamplres;

public class TreeClass {
	private Node root;

	void create_Tree() {
		root = null;
	}

	void insert(Node r, Node n)// in bst manner //r is root , n is new node
	{
		if (root == null)
			root = n;
		else {
			if (n.data < r.data)// if less to left
			{
				if (r.left == null)// empty left
				{
					r.left = n;
					System.out.println(n.data + " inserted");
				} else
					insert(r.left, n);// recursion call
			} else// if equal or greater than to right
			{
				if (r.right == null)// empty left
				{
					r.right = n;
					System.out.println(n.data + " inserted");
				} else
					insert(r.right, n);// recursion call
			}

		}

	}

	void inorder(Node r) {
		if (r != null) {// LPR
			inorder(r.left);// L
			System.out.print(r.data + ",");// P
			inorder(r.right);// R }
		}
	}

	void preorder(Node r) {
		if (r != null) {// LRP
			preorder(r.left);// L
			preorder(r.right);// L
			System.out.print(r.data + ",");// P

		}
	}

	void postorder(Node r) {
		if (r != null) {// LRP

			postorder(r.left);// L

			System.out.print(r.data + ",");// P
			preorder(r.right);// L
		}
	}

	boolean search(int key) {
		if (root == null) {
			System.out.println("Empty Tree");

			return false;
		} else {
			Node r = root;
			while (r != null) {
				if (key == r.data)
					return true;
				else {
					if (key < r.data)
						r = r.left;
					else
						r = r.right;
				}
			}
			return false;

		}

	}
	  int depth(Node r)
	     {
	         if(r==null)
	             return 0;
	         else
	         {
	             int left=depth(r.left);
	             int right=depth(r.right);
	             return Math.max(left,right)+1;
	         }
	     }
	
	
	

	Node get_root() {
		return root;
	}

	public static void main(String args[]) {
		TreeClass obj = new TreeClass();
		obj.create_Tree();
		Node x = new Node(10);
		obj.insert(obj.get_root(), new Node(10));
		obj.insert(obj.get_root(), new Node(30));
		obj.insert(obj.get_root(), new Node(20));
		obj.insert(obj.get_root(), new Node(5));
		obj.insert(obj.get_root(), new Node(15));
		System.out.println("\nTree in inorder:");
		obj.inorder(obj.get_root());
		//System.out.println("\nTree in preorder:");
		//obj.preorder(obj.get_root());
	//	System.out.println("\nTree in postorder:");
		//obj.postorder(obj.get_root());
		
	     System.out.println("\nElement 200 in tree:"+obj.search(200));
	     System.out.println("\nDepth is:"+(obj.depth(obj.get_root())-1));
	}
}
