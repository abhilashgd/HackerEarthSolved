package Sorting;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
 
public class Luggage {
 
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
		
		int numOfTestCases = nextInt();
		
 
		for (int i = 0; i < numOfTestCases; i++) {
			sb = new StringBuilder();
			int numOfElem = nextInt();
			LinkedList ll = new LinkedList();
			for (int j = 0; j < numOfElem; j++)
				ll.add(nextInt());
			dos.write(ll.getMinCount(sb).toString().getBytes());
		}
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
	int val;
	Node next;
	Node previous;
	int count;
}
 
class LinkedList {
	Node root;
	Node last;
 
	public void add(int popularity) {
		if (root == null) {
			Node n = new Node();
			n.val = popularity;
			root = n;
			last = n;
		} else {
			Node n = new Node();
			n.val = popularity;
			last.next = n;
			n.previous = last;
			last = last.next;
		}
	}
	
 
	public StringBuilder getMinCount(StringBuilder sb) {
		
		if(root.next==null)
		{
			sb.append("0"+"\n");
			return sb;
		}else{
			Node currNode=root;
			while(currNode!=last){
				int count=0;
				Node tempNode=currNode.next;
				
				while(tempNode!=null){
					if(tempNode.val<currNode.val)
						count++;
					tempNode=tempNode.next;
				}
			currNode.count=count;	
			currNode=currNode.next;
			}
			while(root!=last){
				sb.append(root.count+" ");
				root=root.next;
			}
				
		}
		sb.append("0"+"\n");
	return sb;
	}
}
