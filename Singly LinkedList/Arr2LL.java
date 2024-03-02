import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Main {

    // convert array to linked list
    private static Node Arr2LL(int arr[]) {
        Node head = new Node(arr[0]); // set arr[0] as head of LL
        Node mover = head; // set mover in the head
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    // main function
    public static void main(String args[]) {
        int arr[] = { 12, 5, 3, 6, 7, 2, 8, 1 };
        Node head = Arr2LL(arr);
        print(head);
    }
}

