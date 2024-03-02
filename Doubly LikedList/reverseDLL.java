import java.util.*;
class Node{
  int data;
  Node next;
  Node back;
  
  Node (int data, Node next, Node back)
  {
   this.data=data;
   this.next=next;
   this.back=back;
  }
 
 Node(int data)
 {
   this.data=data;
   next=null;
   back=null;
  }

}


class Main{

//convert array to DLL
  private static Node Arr2LL(int arr[])
  {
   Node head=new Node(arr[0]);
   Node prev=head;
   for(int i=1;i<arr.length;i++)
   {
    Node temp=new Node(arr[i], null, prev);
    prev.next=temp;
    prev=temp;
   }
  return head;
 }
    

//print the LL
 private static void print(Node head)
 {
   Node temp=head;
   while(temp!=null)
   {
    System.out.print(temp.data+ "  ");
    temp=temp.next;
   }
}



//reverse the DLL by using stack
  private static Node ReverseStack(Node head)
  {
   Stack<Integer> st=new Stack<>();
   Node temp=head;
   while(temp!=null)
   {
    st.push(temp.data);
    temp=temp.next;
   }
   
   temp=head;
   while(temp!=null)
   {
    temp.data= st.pop();
   
    temp=temp.next;
   }
   return head;
  }


//reverse the DLL using changing the connection between nodes
   private static Node ReverseDLL(Node head)
   {
    if(head==null || head.next==null) return head;
     Node temp= head;
     Node last= null;
     while(temp!=null)
     {
       last=temp.back;
       temp.back=temp.next;
       temp.next=last;
       

       temp=temp.back; //for traverse the next node 
     }
     return last.back;  //return from the last node
  }
 


//main function
 public static void main(String args[])
 {
  int arr[] = {2, 4, 8, 7, 1, 9, 5, 3};

  //convert array to DLL
  Node head = Arr2LL(arr);

  //reverse the DLL by using stack
   //head=ReverseStack(head);
  
//reverse the DLL using changing the connection between nodes
   head=ReverseDLL(head);

  //print the DLL
   print(head);
 }
}
