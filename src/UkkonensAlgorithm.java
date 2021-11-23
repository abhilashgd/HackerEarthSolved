import java.util.*;

public class UkkonensAlgorithm {
  public static int stacktrack;
	public char TERMINATORS_RANGE = '\ud800';
	public static int count=0;
	public static void dfsd(Node c){
		if (c.isLeaf()){
			//System.out.println("\nbasecase");
			//count++;
			return;
		}
		Node a;
		System.out.println(c.sons.keySet());
		
		Iterator it = c.sons.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry)it.next();
			a = (Node)pairs.getValue();
			for(int i=0;i<stacktrack;i++)System.out.print("\t");
			System.out.println(stacktrack+" br>>>>>>> ="+count+"= "+pairs.getKey() + " = " + a.edgeStart + " : " + a.edgeEnd );
			stacktrack++;
			count++;
			dfsd(c.sons.get(pairs.getKey()));
		
			stacktrack--;
			for(int i=0;i<stacktrack;i++)System.out.print("\t");
			System.out.println(stacktrack+" bt<<<<<<< ="+count+"= "+pairs.getKey() + " = " + a.edgeStart + " : " + a.edgeEnd );
		}
	}
					
	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		*/
		
		String s = "abbab";
		SuffixTree t1 = new SuffixTree(s);
		System.out.println(t1.nofnodes());
		SuffixTree t2 = new SuffixTree(new String[]{"aab","aac"});
		System.out.println(t2.nofnodes());

		SuffixTree t3 = new SuffixTree();
		t3.addString("aab");
		t3.addString("aac");
		System.out.println(t3.nofnodes());
		dfsd(t3.root);
		System.out.println(count);		
	}
}


/*
 Ukkonen's algorithm for linear time construction of suffix trees.
*/

class Node {
	Node parent, suffixLink;
	int edgeStart, edgeEnd, parentDepth;
	// The edge that reaches this node contains the substring s[edgeStart, edgeEnd]
	TreeMap<Character, Node> sons;

	public Node(){
		parent = suffixLink = null;
		edgeStart = edgeEnd = parentDepth = 0;
		sons = new TreeMap<Character, Node>();
	}

	// Returns true if there is a path starting at root having length position + 1 that ends
	// in the edge that reaches this node.
	public boolean inEdge(int position){
		return parentDepth <= position && position < depth();
	}

	public int edgeLength(){
		return edgeEnd - edgeStart;
	}

	public int depth(){
		return parentDepth + edgeLength();
	}

	void link(Node son, int start, int end, String s){
		// Links the current node with the son. The edge will have substring s[start, end)
		son.parent = this;
		son.parentDepth = this.depth();
		son.edgeStart = start;
		son.edgeEnd = end;
		sons.put(s.charAt(start),son);
	}

	public boolean isLeaf(){
		return sons.size() == 0;
	}
};

class SuffixTree {
	ArrayList<Node> nodes;
	Node root, needSuffix;
	int currentNode;
	int length;
	char TERMINATORS_RANGE = '\ud800';
	int termi=0;
	String generalized;

	public SuffixTree(String str) {
		nodes = new ArrayList<Node>();
		currentNode = 0;
		str = str + (char)TERMINATORS_RANGE;
		length = str.length();
		root = newNode();
		build(root, str);
	}

	public SuffixTree(String[] stra) {
		nodes = new ArrayList<Node>();
		currentNode = 0;
		root = newNode();
		
		StringBuilder sb = new StringBuilder();
    for (int i = 0; i < stra.length; i++) {
        sb.append(stra[i]);
        sb.append((char)(TERMINATORS_RANGE + i));
    }
    generalized = sb.toString();
		length = generalized.length();
    build(root, generalized);	
	}

	public SuffixTree() {
		nodes = new ArrayList<Node>();
		currentNode = 0;
		root = newNode();
	}
	
	void addString(String str){
		str = str+ (char)(TERMINATORS_RANGE + termi);
		termi++;
		length = str.length();
		build(root, str);
	}	
	
	int nofnodes() {
		return currentNode;
	}
	
	Node newNode(){
		nodes.add(currentNode,new Node());
		currentNode++;
		return new Node();
	}

	Node walkDown(Node c, int j, int i, String str) {
		int k = j + c.depth();
		if (i - j + 1 > 0){
			while (!c.inEdge(i - j)){
				c = c.sons.get(str.charAt(k));
				k += c.edgeLength();
			}
		}
		return c;
	}

	void addSuffixLink(Node current){
		if (needSuffix != null){
			needSuffix.suffixLink = current;
		}
		needSuffix = null;
	}

	void build(Node root, String s) {
		
		Node c = newNode();
		needSuffix = null;
		root.link(c, 0, length, s);

		// Indicates if at the beginning of the phase we need to follow the suffix link of the current node 
		//and then walk down the tree using the skip and count trick.
		boolean needWalk = true;

		for (int i=0, j=1; i<length-1; ++i){
			char nc = s.charAt(i+1);
			while (j <= i + 1){
				if (needWalk){
					if (c.suffixLink == null && c.parent != null) c = c.parent;
					c = (c.suffixLink == null ? root : c.suffixLink);
					c = walkDown(c, j, i, s);
				}

				needWalk = true;
				// Here c == the highest node below s[j...i] and we will add char s[i+1]
				int m = i - j + 1; // Length of the string s[j..i].
				if (m == c.depth()){
					// String s[j...i] ends exactly at node c (explicit node).
					addSuffixLink(c);
					if (c.sons.containsKey(nc)){
						c = c.sons.get(nc);
						needWalk = false;
						break;
					}else{
						Node leaf = newNode();
						c.link(leaf, i+1, length, s);
					}
				}else{
					// String s[j...i] ends at some place in the edge that reaches node c.
					int where = c.edgeStart + m - c.parentDepth;
					// The next character in the path after string s[j...i] is s[where]
					if (s.charAt(where) == nc){ //Either rule 3 or rule 1
						addSuffixLink(c);
						if (!c.isLeaf() || j != c.edgeStart - c.parentDepth){
							// Rule 3
							needWalk = false;
							break;
						}
					}else{
						Node split = newNode();
						c.parent.link(split, c.edgeStart, where, s);
						split.link(c, where, c.edgeEnd, s);
						split.link(newNode(), i+1, length, s);
      
						addSuffixLink(split);
      
						if (split.depth() == 1){
							//The suffix link is the root because we remove the only character and end with an empty string.
							split.suffixLink = root;
						}else{
							needSuffix = split;
						}
						c = split;
					}
				}
				j++;
			}
		}
	}
}