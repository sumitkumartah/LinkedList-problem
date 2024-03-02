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

class A {

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

  //sort a ll on 0s , 1s , 2s by using cnt method  ------->>>>>>    BRUTE FORCE TC=O(2N)   SC=O(1)
    public static Node sortLL(Node head)
    {
     int cnt0=0;
     int cnt1=0;
     int cnt2=0;
     Node temp=head;
     while(temp!=null)
     {
      if(temp.data==0) cnt0++;
      if(temp.data==1) cnt1++;
      if(temp.data==2) cnt2++;
       temp=temp.next;
     }
    temp=head;
    while(temp!=null)
     {
      if(cnt0>0)
       {
        temp.data=0;
        cnt0--;
       }
      else if(cnt1>0)
       {
        temp.data=1;
        cnt1--;
        }
       else
        {
         temp.data=2;
          cnt2--;
        }
       temp=temp.next;
      }
     return head;

}


 //sort a ll on 0s , 1s , 2s by using   ------->>>>>>    OPTIMAL TC=O(2N)   SC=O(1)
 public static Node sortLLOp(Node head){
   Node zerohead=new Node(-1);
   Node zero=zerohead;
   Node onehead=new Node (-1);
   Node one=onehead;
   Node twohead=new Node (-1);
   Node two=twohead;
   
   Node temp=head;
   while(temp!=null)
   {
    if(temp.data==0)
     {
      zero.next=temp;
      zero=temp;
     }
    else if(temp.data==1)
     {
      one.next=temp;
      one=temp;
     }
     else{
      two.next=temp;
      two=temp;
      }
    temp=temp.next;
   }
  
   zero.next=(onehead.next==null)?twohead.next : onehead.next;
   onehead.next=twohead.next;
   twohead.next=null;
   
   Node newhead=zerohead.next;
   return newhead;
  }



    // main function
    public static void main(String args[]) {
        int arr[] = {0, 2, 1, 1, 0, 2, 1, 0,2, 1, 0, 2};
        Node head = Arr2LL(arr);
        head=sortLL(head);

        head=sortLLOp(head);
        print(head);
    }
}

