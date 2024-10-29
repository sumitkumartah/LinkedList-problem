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
  
  
 //insert at the head
   public static Node insertHead(Node head, int val)
    {
      Node newnode=new Node (val);    // return new Node(val, head);
      newnode.next=head;
      head=newnode;
      return  newnode;
    }


   //insert at the tail
   public static Node insertEnd(Node head, int val)
    {
      if(head==null) return new Node(val);     
      Node temp=head;
      while(temp.next!=null)
      {
       temp=temp.next;
      }
      Node newnode=new Node (val); 
      temp.next=newnode;
      newnode.next=null;
      return head;
    }

   
//insert at the kth position
   public static Node insertK(Node head, int k, int val){
       if(head==null){
           if(k==0) return new Node(val);
           else{
               return null;
           }
       }
       
       if(k==0){
           Node newHead=insertHead(head, val);
           return newHead;
       }
       
       int cnt=1;
       Node temp=head;
       while(temp!=null){
           if(cnt==k){
               Node newnode=new Node(val);
               newnode.next=temp.next;
               temp.next=newnode;
               break;
           }
           cnt++;
           temp=temp.next;
       }
       return head;
    }

//insert before the  el x
public static Node insertBefore(Node head, int tar, int val){
       if(head==null){
               return null;
       }
       
       if(head.data==tar){
           Node newHead=insertHead(head, val);
           return newHead;
       }
       
       Node temp=head;
       while(temp!=null){
           if(temp.next.data==tar){
               Node newnode=new Node(val);
               newnode.next=temp.next;
               temp.next=newnode;
               break;
           }
           
           temp=temp.next;
       }
       return head;
    }

    
    
   //insert after the  el x
  public static Node insertAfter(Node head, int el, int val)
    {
      if(head==null) return new Node(val); 
      Node temp=head;
      while(temp!=null)
      {
       if(temp.data==el)
        {
         Node newnode=new Node(val);
         newnode.next=temp.next;
         temp.next=newnode;
         break;
        }
       temp=temp.next;
      }
      return head;
    }




    // main function
    public static void main(String args[]) {
        int arr[] = { 12, 5, 3, 6, 7, 2, 8, 1 };
        Node head = Arr2LL(arr);
        
       //insert at the head
        //head=insertHead(head, 9);
        
       //insert at the end
         //head=insertEnd(head, 9);

       //insert at the kth position
         //head=insertAtK(head,3, 9);

       //insert before the el x
         //head=insertBefore(head, 2, 9);
      
      //insert before the el x
         //head=insertBefore(head, 2, 9);

      //insert after the el x
        head=insertAfter(head, 2, 9);
      
       print(head);
    }
}
