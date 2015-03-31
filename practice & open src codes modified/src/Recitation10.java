import java.util.HashMap;
import java.util.Map;


public class Recitation10 {
	private Node myRoot;
	public class Node{
		private String info;
		private boolean isWord;
		private Map<Character, Node> children;
		private Node parent;
		public Node(char c, Node p){  // info and parent
			info = ""+c;
			isWord = false;
			children = new HashMap<Character, Node>();
			parent = p;    
		}
	}

	public int countWords(Node n){
		int count= 0;
		if (n == null)
			return 0;
		
		if (n.isWord){
			return 1;
		}
		for (Node node: n.children.values()){
			count+= countWords(node);
		}
		return count;
	}
	public Node copy(){
		Node oldRoot = myRoot;
		Node newRoot = new Node(myRoot.info.charAt(0), null);
		copyTrie(oldRoot, newRoot);
		return newRoot;
	}
	private void copyTrie(Node oldRoot, Node newRoot) {
		if (oldRoot == null) {
			return;
		}

		for (Node n: oldRoot.children.values()){
			Node copy = new Node(n.info.charAt(0), newRoot);
			copy.isWord = n.isWord;
			copyTrie(n, copy);
		}

	}
	/*
	 * node method()
	 *   oldroot = myroot;
	 *   newrOOT = new Node (oldroot value, null)l
	 *   return methodhelper(oldroot, newroot)
	 *  }
	 *  
	 *  void methodHelper(oldParent, newparent){
	 *    base cases
	 *    
	 *    for each children of oldparent
	 *    node n = new Node(children value, newparent)
	 *    methodhelper(helper, n)
	 *    end for
	 *    
	 *    end 
	 *  }
	 * 
	 */
}
