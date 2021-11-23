package Sorting;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class SortByStrLen {
	 
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintWriter pw = new PrintWriter(System.out);
 
    public static void main(String[] args) throws Exception {
        LinkedList<String> ll = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
       while(N-->0){
        String[] arr = br.readLine().split(" ");
        ll.insertAtEnd(arr[0]);
        
 
        LinkedList.Node<String> currentNode;
       }
 
        pw.flush();
    }
    private static class LinkedList<T> {
    	 private Node<T> root;
         private Node<T> last;
         private static PrintWriter printWriter = new PrintWriter(System.out);
         
    	public static class Node<T> {
            private T data;
            private Node<T> next;
            private Node<T> previous;
 
            public Node(T data, Node<T> next, Node<T> previous) {
                this.data = data;
                this.next = next;
                this.previous = previous;
            }
        }
 
         public Node<T> getroot() {
            return this.root;
        }
 
        public Node insertAtEnd (T data) {
            Node<T> node = createNode(data);
            if (this.root == null) {
                this.root = node;
                this.last = node;
            } else {
                node.previous = this.last;
                this.last.next = node;
                this.last =  this.last.next;
            }
            return node;
        }
 
        public Node insertAfter (Node node, T data) {
            if (this.root == null) throw new IllegalStateException("DataStructures.LinkedList is empty.");
            if (node == null) throw new IllegalArgumentException("Given node is null.");
            Node<T> newNode = createNode(data);
            if (node == this.last) { // it is a last node.
                newNode.previous = node;
                node.next = newNode;
                this.last = newNode;
            } else {
                Node nextNode = node.next;
                newNode.previous = node;
                newNode.next = nextNode;
 
                nextNode.previous = newNode;
                node.next = newNode;
            }
            return newNode;
        }
 
 
        public Node insertBefore (Node node, T data) {
            if (this.root == null) throw new IllegalStateException("DataStructures.LinkedList is empty.");
            if (node == null) throw new IllegalArgumentException("Given node is null.");
            Node<T> newNode = createNode(data);
            if (node == this.root) {
                this.root.previous = newNode;
                newNode.next = this.root;
                this.root = newNode;
            } else {
                Node previousNode = node.previous;
                newNode.next = node;
                newNode.previous = previousNode;
 
                node.previous = newNode;
                previousNode.next = newNode;
            }
 
            return newNode;
        }
 
 
 
        public void deleteNode (Node node) {
            if (this.root == null) throw new IllegalStateException("DataStructures.LinkedList is empty.");
            if (node == null) throw new IllegalArgumentException("Given node is null");
            if (node == this.root) {
                //delete root.
                if (this.last == this.root) {
                    //make last also null;
                    this.last = null;
                }
                this.root = this.root.next;
            } else {
                node.previous.next = node.next;
                if (node.next != null) {
                    node.next.previous = node.previous;
                } else {
                    this.last = node.previous;  //update last.
                }
 
            }
        }
 
 
        public void printList () {
            Node currentNode = this.root;
            while (currentNode != null) {
                if (currentNode == this.root) {
                    printWriter.print(currentNode.data);
                } else {
                    printWriter.print(" " + currentNode.data);
                }
                currentNode = currentNode.next;
            }
            printWriter.println();
 
            printWriter.flush();
        }
 
        private Node createNode (T data) {
            return new Node<>(data, null, null);
        }
 
    }
 

}