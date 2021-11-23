package SinglyLinkedList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
 
public class DeleteFriend {
 
	static int BUFFER_SIZE = 1 << 16;
	static int byteReads = 0;
	static int bufferPoint = 0;
	static byte[] buffer;
	static DataInputStream din;
	static DataOutputStream dos;
	static StringBuilder sb;
 
	public static void main(String[] args) throws IOException {
		din = new DataInputStream(System.in);
		dos = new DataOutputStream(System.out);
		buffer = new byte[BUFFER_SIZE];
		// num of test cases
		int numOfTestCases = nextInt();
		sb = new StringBuilder();
 
		for (int i = 0; i < numOfTestCases; i++) {
			int numOfFrds = nextInt();
			int numOfDeletedFrds = nextInt();
			LinkedList ll = new LinkedList();
			for (int j = 0; j < numOfFrds; j++) {
				numOfDeletedFrds = ll.add_delete(nextInt(), numOfDeletedFrds);
			}
			
			if(numOfDeletedFrds > 0){
				ll.deleteLastK(numOfDeletedFrds);
			}
			
 
			ll.print(sb);
			sb.append("\n");
		}
 
		dos.write(sb.toString().getBytes());
	}
 
	static void fillBuffer() throws IOException {
		byteReads = din.read(buffer, bufferPoint = 0, BUFFER_SIZE);
		if (byteReads == -1)
			buffer[0] = -1;
	}
 
	static byte read() throws IOException {
		if (bufferPoint == byteReads)
			fillBuffer();
 
		return buffer[bufferPoint++];
	}
 
	static int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
 
		if (neg)
			return -ret;
		else
			return ret;
	}
 
}
 
class Node {
	int popularity;
	Node next;
	Node previous;
}
 
class LinkedList {
	Node root;
	Node last;
 
	public void add(int popularity) {
		if (root == null) {
			Node n = new Node();
			n.popularity = popularity;
			root = n;
			last = n;
		} else {
			Node n = new Node();
			n.popularity = popularity;
			last.next = n;
			n.previous = last;
			last = last.next;
		}
	}
	
 
	public int add_delete(int popularity, int k) {
		if (root == null) {
			Node n = new Node();
			n.popularity = popularity;
			root = n;
			last = n;
		} else {
			Node currNode = last;
			boolean flag = false;
			if (k >0 && currNode.popularity < popularity) {
				while (k >0 && currNode.popularity < popularity) {
					if (currNode.previous == null) {
						flag = true;
						break;
					} else {
						Node temp = currNode;
						currNode = currNode.previous;
						currNode.next = null;
						temp.previous = null;
						k--;
					}
				}
 
				if (flag) {
					Node n = new Node();
					n.popularity = popularity;
					currNode = n;
					last = currNode;
					root = currNode;
					k--;
				} else {
					Node n = new Node();
					n.popularity = popularity;
					currNode.next = n;
					n.previous = currNode;
					currNode = currNode.next;
					last=currNode;
				}
 
			} else {
				Node n = new Node();
				n.popularity = popularity;
				currNode.next = n;
				n.previous = currNode;
				currNode = currNode.next;
				last = last.next;
			}
 
		}
 
		return k;
	}
	
	public void deleteLastK(int numOfDelFrds){
		while(numOfDelFrds > 0){
			Node temp = last;
			last = last.previous;
			last.next=null;
			temp.previous=null;
			numOfDelFrds--;
		}
	}
 
	public StringBuilder print(StringBuilder sb) {
		Node temp = root;
 
		while (temp != null) {
			sb.append(temp.popularity + " ");
			temp = temp.next;
		}
 
		return sb;
	}
}
