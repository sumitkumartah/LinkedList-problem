// input -   [2] -->[3] -->[1] -->[4] -->[5]
// output-- [2] --> [1]--> [5] --> [3] -->[4]


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
    

  //replace method TC=O(2N) sc=O(n)
   public static Node OddEven(Node head, int n) {
    int[] arr = new int[n];
    Node temp1 = head;
    int i = 0;
    while (temp1 != null && temp1.next != null) {
        arr[i] = temp1.data;
        temp1 = temp1.next.next;
        i++;
    }
    if (temp1 != null) { // if size of LL is odd 
        arr[i] = temp1.data;
        i++;
    }

    Node temp2 = head.next;
    while (temp2 != null && temp2.next != null) {
        arr[i] = temp2.data;
        temp2 = temp2.next.next;
        i++;
    }
    if (temp2 != null) { // if size of LL is odd 
        arr[i] = temp2.data;
        i++;
    }

   int  j = 0;
    Node temp = head;
    while (temp != null) {
        temp.data = arr[j];
        temp = temp.next;
        j++;
    }
    return head;
}



//optimal approach
 public static Node OddEvenOp(Node head)
  {
   if(head==null || head.next==null ) return head;
    Node odd=head;
    Node even=head.next;
    Node evenHead=head.next; // for add in the last of the odd node
    while(even!=null && even.next!=null)
    {
     odd.next=odd.next.next;
     even.next=even.next.next;
     odd=odd.next;
     even=even.next;
    }
   odd.next=evenHead;
   return head;
  }

    // main function
    public static void main(String args[]) {
        int arr[] = { 12, 5, 3, 6, 7, 2, 8 };
        Node head = Arr2LL(arr);


        int n=arr.length;
        //head=OddEven(head, n);

        head=OddEvenOp(head);
        print(head);
    }
}
