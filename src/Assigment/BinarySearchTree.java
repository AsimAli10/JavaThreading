package Assigment;
//this implementation is taken from https://www.programiz.com/dsa/binary-search-tree
public class BinarySearchTree {
	 class Node {
		    String key;
		    Node left, right;

		    public Node(String item) {
		      key = item;
		      left = right = null;
		    }
		  }

		  Node root;

		  BinarySearchTree() {
		    root = null;
		  }

		  void insert(String key) {
		    root = insertKey(root, key);
		  }

		  // Insert key in the tree
		  Node insertKey(Node root, String key) {
		    // Return a new node if the tree is empty
		    if (root == null) {
		      root = new Node(key);
		      return root;
		    }

		    // Traverse to the right place and insert the node
		    if (key.compareTo(root.key)<0)
		      root.left = insertKey(root.left, key);
		    else if (key.compareTo(root.key)>0)
		      root.right = insertKey(root.right, key);

		    return root;
		  }
		  void inorder() {
			    inorderRec(root);
			  }

		
			  void inorderRec(Node root) {
			    if (root != null) {
			      inorderRec(root.left);
			      System.out.print(root.key+ " ");
			      inorderRec(root.right);
			    }
			  }
}
