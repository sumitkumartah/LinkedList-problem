class Node{
 int data;
 Node next;
 Node back;
 Node(int data, Node next, Node back)
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
  
  private static Node Arr2LL(int arr[]) {
        Node head = new Node(arr[0]); // set arr[0] as head of LL
        Node prev = head;       // set prev in the head
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i] , null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
  

  private static void print(Node head){
    Node curr=head;
    while(curr!=null)
    {
     System.out.print( curr.data+ "   ");
     curr=curr.next;
    }
  }


 //delete the head of the DLL
  private static Node deletehead(Node head)
  {
    if(head == null || head.next == null)    // If the list is empty or has only one node, return null
        return null;
   // Node temp = head;     // Store the reference to the current head node
    head = head.next;       // Update the head to point to the next node
  
    head.back = null;       // Set the back reference of the new head to null
    //temp.next = null;      // Detach the old head node from the list
    return head;            // Return the updated head
   }

  

//delete the tail of the DLL
  private static Node deletetail(Node head)
  {

    if(head == null || head.next == null)    // If the list is empty or has only one node, return null
        return null;

     Node tail=head;
     while(tail.next!=null)
     {
      tail=tail.next;
     }
     Node prev=tail.back;
     prev.next=null;
     tail.back=null;
     return head;
  }



 // delete the kth el of the DLL
 private static Node deleteKthEl(Node head, int k)
 {
   if(head==null)return null;
   int cnt=0;
   Node temp=head;
   while(temp!=null)
   {
    cnt++;
    if(cnt==k)break;
    temp=temp.next;
   }
   Node prev=temp.back;
   Node front=temp.next;
   if(prev==null && front==null) return null;   // there is only 1 el in DLL
   else if(prev==null) return deletehead(head);    //if prev is null it is the first node then delete the first node
   else if(front==null) return deletetail(head);   //if front is null it is the last node then delete the last node
   else{
    prev.next=front;
    front.back=prev;
    temp.back=null;
    temp.next=null;
    return head;
   }

 }


// delete a particular el of the DLL
    private static Node deleteEl(Node head, int el) {
        if (head == null)
            return null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == el)
                break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;
        if (prev == null && front == null)
            return null;   // there is only 1 el in DLL
        else if (prev == null)
            return deletehead(head);    //if prev is null it is the first node then delete the first node
        else if (front == null)
            return deletetail(head);   //if front is null it is the last node then delete the last node
        else {
            prev.next = front;
            front.back = prev;
            temp.back = null;
            temp.next = null;
            return head;
        }
    }

    // delete a particular el of the DLL except the first node
    public static void deleteNode(Node temp) {
        Node prev = temp.back;
        Node front = temp.next;
        if (front == null) { // it is the last node
            prev.next = null;
            temp.back = null;
            return; // Use return instead of break
        }
        prev.next = front;
        front.back = prev;
        temp.next = temp.back = null;
    }


 //delete after the given node 
private static Node deleteAfter(Node head, int el) {
   if (head == null)
        return null;
    Node temp = head;
    while (temp.next != null) {
        if (temp.data == el)
            break;
        temp = temp.next;
    }
    
    // If the target node is not found
    if (temp.next == null || temp.data != el)
        return head;

    Node nodeToDelete = temp.next;
    
    temp.next=nodeToDelete.next;
    nodeToDelete.next.back=temp;
    
    nodeToDelete.back=null;
    nodeToDelete.next=null;
    return head;
    
}


//delete before the given node 
private static Node deleteBefore(Node head, int el) {
   if (head == null)
        return null;
    Node temp = head;
    while (temp!= null) {
        if (temp.data == el)
            break;
        temp = temp.next;
    }
    
    // If the target node is not found
    if (temp== null || temp.data != el)
        return head;

    Node nodeToDelete = temp.back;
    
    nodeToDelete.back.next=temp;
    temp.back=nodeToDelete.back;
   
    
    nodeToDelete.back=null;
    nodeToDelete.next=null;
    return head;
    
}
//            OR
//delete before the given node 
     public static Node deleteNode(Node head, int x){
         if(head.data==x) return head;
        Node temp=head;
     
        while(temp.next!=null){
           if(temp.next.data==x){
               break;
           }
            temp=temp.next;
        }
       
      
      Node prev=temp.back;
      Node front=temp.next;
       
      if(prev==null) return deleteHead(head);
       
      prev.next=front;
      front.back=prev;
      temp.back=null;
      temp.next=null;
      return head;
    }



 
    //main function
    public static void main(String args[]) {
        int arr[] = {2, 4, 8, 7, 1, 9, 5, 3};
        Node head = Arr2LL(arr);

        //delete the head of the DLL
        // head= deletehead(head);

        //delete the head of the DLL
        //head= deletetail(head);

        // delete the kth el of the DLL
        //head=deleteKthEl(head, 3);

        // delete the el of the DLL
        //head = deleteEl(head, 9);

        // delete a particular el of the DLL except the first node
        //deleteNode(head.next.next.next);
        
        //delete after the given node 
         //head= deleteAfter(head, 1);
         

        //delete before the given node 
          head=deleteBefore(head, 1);


        //print the DLL
        print(head);
    }
}
