
public class BST <T extends Comparable>{

	private class BSTNode {
		public Comparable data;
		public BSTNode left;
		public BSTNode right;

		BSTNode (Comparable newdata){
			data = newdata;
		}
	}

	private BSTNode root; 
	
	//recursively
	public boolean find(Comparable value){
		return find (root,value);

	}

	private boolean find ( BSTNode node, Comparable value){
		if (node == null){
			return false;
		}

		if (node.data.compareTo(value)== 0){
			return true;
		}
		//else if (node.data.compareTo(value) > 0
		else if (node.data.compareTo(value) > 0){
			return find(node.left,value);
		}
		else{

			return find(node.right,value);
		}
	}

	public void insert (Comparable value){
		root = insert(root,value);
	}

	private BSTNode insert (BSTNode node, Comparable value){
			if (node == null){
				return new BSTNode(value);
			}
			if (node.data.compareTo(value) > 0){
				
				node.left = insert(node.left, value);
				return node; 

			}
			//else if (node.data.compareTo(value) < 0
			else{//(node.data.compareTo(value) == -1){
				node.right = insert(node.right,value);
				return node;
			}

	}

	//recursively 
	public void delete(Comparable value){

		root = delete(root,value);

	}

	private BSTNode delete  (BSTNode node, Comparable value){
		//basecase
		if (node==null)
		{
			return null;
		}
		//less than 
		if  (node.data.compareTo(value)<0){
			node.left = delete(node.left,value);
		}
		//greater than
		else if (node.data.compareTo(value) > 0){
			node.right = delete(node.right,value);
		}
		else{


			if (node.left == null){

				return node.right;
			}

			else if (node.right == null){
				return node.left; 
			}
			node.data = getSmallest(node.right);
			node.right = delete(node.right,value);
		} 
		return node;
	}

	

	public Comparable getSmallest (BSTNode node)
	{
		while (node.left != null){
			node = node.left; 
		}
		return node.data; 
	}
	
	public void print()
	{
		print(root);
	}

	public void print(BSTNode node){
		if (node!=null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}
}