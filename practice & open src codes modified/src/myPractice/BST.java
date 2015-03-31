package myPractice;
public class BST {

	TreeNode root = null;



	public class TreeNode {

		public int myValue;

		public TreeNode myLeft; // holds smaller tree nodes

		public TreeNode myRight; // holds larger tree nodes



		public TreeNode(int val) {

			myValue = val;

		}

	}



	public void add(int newValue) {

		if (root == null)

			root = new TreeNode(newValue);

		else

			add(newValue, root);

	}



	public void add(int newValue, TreeNode current) {

		if (newValue < current.myValue) {

			if (current.myLeft == null) {

				current.myLeft = new TreeNode(newValue);

			} else {

				add(newValue, current.myLeft);

			}

		} else {

			// newValue >= myValue

			if (current.myRight == null) {

				current.myRight = new TreeNode(newValue);

			} else {

				add(newValue, current.myRight);

			}

		}

	}



	public String toString() {

		return toString(root, "")+"\n";

	}



	public String toString(TreeNode current, String level) {

		String leftString = "null";

		String rightString = "null";



		if (current.myLeft != null)

			leftString = toString(current.myLeft, level + "   ");

		if (current.myRight != null)

			rightString = toString(current.myRight, level + "   ");



		return current.myValue + "\n" + level + "L: " + leftString + "\n"

+ level + "R: " + rightString;

	}



	public int computeHeight() {

		return computeHeight(root);

	}



	private int computeHeight(TreeNode current) {

		if (current == null)

			return 0;

		int lResult = computeHeight(current.myLeft);

		int rResult = computeHeight(current.myRight);

		if (lResult > rResult) {

			return lResult + 1;

		} else {

			return rResult + 1;

		}

	}



	public int countNodes() {

		return countNodes(root);

	}



	public int countNodes(TreeNode current) {

		if (current == null) {

			return 0;

		}

		int lCount = countNodes(current.myLeft);

		int rCount = countNodes(current.myRight);



		// your code here

		return 1 + lCount + rCount;

	}



	public boolean containsNode(int value) {

		return containsNode(value, root);

	}



	private boolean containsNode(int value, TreeNode current) {

		// your code goes here

		// hint: base case...if the node is null, it does not contain the value

		if (current == null)

			return false;

		if (current.myValue == value)

			return true;

		boolean lBool = containsNode(value, current.myLeft);

		boolean rBool = containsNode(value, current.myRight);

		return lBool || rBool;

	}



	public int findMax() {

		return findMax(root);

	}



	private int findMax(TreeNode current) {

		// assuming all nodes have values greater than -1000

		int max = -1000;

		if (current == null)

			return max;

		int lMax = findMax(current.myLeft);

		int rMax = findMax(current.myRight);

		return Math.max(current.myValue, Math.max(lMax, rMax));

	}



	public int numLeaves() {

		return numLeaves(root);

	}


	private int numLeaves(TreeNode current) {

		if ((current.myLeft == null) && (current.myRight == null)){

			return 1;

		}

		return numLeaves(current.myLeft) + numLeaves(current.myRight);

	}



	public int levelCount(int target) {

		return levelCount(root, target);

	}



	/**

	 * Returns number of nodes at specified level in t, where level >= 0.

	 * 

	 * @param level

	 *            specifies the level, >= 0

	 * @param t

	 *            is the tree whose level-count is determined

	 * @return number of nodes at given level in t

	 */

	public int levelCount(TreeNode t, int level) {



		if (level == 0){

			return 1;

		}

		return levelCount(t.myLeft, level-1) + levelCount(t.myRight, level-1);



	}



	public boolean hasPathSum(int target) {

		return hasPathSum(root, target);

	}



	/**

	 * Return true if and only if t has a root-to-leaf path that sums to target.

	 * 

	 * @param t

	 *            is a binary tree

	 * @param target

	 *            is the value whose sum is searched for on some root-to-leaf

	 *            path

	 * @return true if and only if t has a root-to-leaf path summing to target

	 */

	private boolean hasPathSum(TreeNode current, int target) {

		if (current == null && target!= 0){

			return false;

		}



		if (target == 0){

			return true;

		}

		else{

			return hasPathSum(current.myLeft, target- current.myValue) || hasPathSum(current.myRight, target- current.myValue);





		}



	}







	public int findK(int k) {

		return findK(root, k);

	}



	/**

	 * Return the value in the kth node of the tree.

	 * Assume that we never give you a k greater than the number of nodes.

	 * 

	 * @param current

	 *            is a binary tree

	 * @param k

	 *            is the index of the node that we want to get the value from

	 * @return the integer value from the kth node.

	 */

	private int findK(TreeNode current, int k) {

		StringBuffer s = new StringBuffer();

		helper(current, s);

		return Integer.parseInt(s.substring(k-1, k));







	}

	private void helper(TreeNode current, StringBuffer sb){

		if (current == null){

			return;

		}

		helper(current.myLeft, sb);

		sb.append(current.myValue);



		helper(current.myRight, sb);

	}





	public static void main(String[] args) {

		BST bst = new BST();

		int[] data = { 6, 8, 2, 4, 1, 7, 5, 3, 9 };

		for (int i : data)

			bst.add(i);

		System.out.print(bst.toString());

		System.out.printf("Number of leaves: %d\n", bst.numLeaves()); // 5

		System.out

		.printf("Number of nodes on level 2: %d\n", bst.levelCount(2)); // 4

		System.out.println("Has path sum 17: " + bst.hasPathSum(17));// true

		System.out.println("Has path sum 10: " + bst.hasPathSum(10));// false

		System.out.printf("The value in node 5 is: %d\n", bst.findK(5)); // 5



	}

}