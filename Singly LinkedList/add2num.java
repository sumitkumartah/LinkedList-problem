// ADD 2 NUMBERS IN LL 

//          [3] --> [5] -->NULL
//          [4] --> [5] --> [9] --> [9] -->NULL   
//OUTPUT -  [7] --> [0] --> [0] --> [0] --> [1] -->NULL





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
        System.out.println("");
    }


    public static Node Sum2LL(Node head1, Node head2)
      {
       Node dummynode=new Node(-1);
       Node cur=dummynode;
       
       Node temp1=head1;
       Node temp2=head2;
       
       int carry=0;
       while(temp1!=null ||temp2!=null)
       {
         int sum=carry;
         if(temp1!=null)
         {
          sum+=temp1.data;
          temp1=temp1.next;
         }
         if(temp2!=null)
         {
          sum+=temp2.data;
          temp2=temp2.next;
         }

        Node newnode=new Node(sum%10);
        carry=sum/10;
        
        cur.next=newnode;
        cur=cur.next;
      }
    
      //if carry is in  the last
       if(carry>0)
       {
         Node newnode=new Node (carry);
         cur.next=newnode;
       }
       
       return dummynode.next;
      }

    // main function
    public static void main(String args[]) {
        int arr[] = { 4, 5, 7 };
        int arr2[]={4, 5, 9, 9};

        Node head = Arr2LL(arr);
        Node head2=Arr2LL(arr2);

       System.out.print( "First Linkedlist= ");
        print(head);
       System.out.print( "Second Linkedlist=  ");
        print(head2);

        Node res= Sum2LL(head, head2);
        System.out.print( "sum of the 2 Linkedlist=  ");
         print(res);
    }
}
