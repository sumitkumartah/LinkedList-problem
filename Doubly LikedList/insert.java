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





//insert at the beginning of DLL
 private static  Node insertStart(Node head, int el)
 {
   Node newnode=new Node(el);
    newnode.next=head;
    newnode.back=null;
    head.back=newnode;

   return newnode;
 }




//insert at the end of DLL
 private static Node insertEnd(Node head, int el) {
    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }

    Node newnode = new Node(el);
    temp.next = newnode;
    newnode.back = temp; 
    return head;
}





//insert before the end of the DLL
  private static Node insertBeforeEnd(Node head, int el) {
    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    Node prev=temp.back;
    Node newnode = new Node(el);
    prev.next = newnode;
    newnode.back = prev;

    newnode.next=temp;
    temp.back=newnode;

    return head;
}

 


//insert at the kth position
  private static Node insertKthPosition(Node head, int el ,int k) {
    if(k==1){
       insertStart(head, el);
    }
     
    int cnt=0;
    Node temp = head;
    while (temp!= null) {
        cnt++;
        if(cnt==k) break;
        temp = temp.next;
    }
    Node prev=temp.back;
    Node newnode = new Node(el,temp,prev);
    prev.next = newnode;
    newnode.next=temp;

    return head;
}





//insert before a given node el 
 
  private static Node insertBefore(Node head, int el, int val ) {
    Node temp = head;
    while (temp!= null) {
        
        if(temp.data==el) break;
        temp = temp.next;
    }
    Node prev=temp.back;
    Node newnode = new Node(val,temp,prev);
    prev.next = newnode;
    newnode.next=temp;

    return head;
}




//insert before a given node el and node!=head
 
  private static Node insertBeforeNode(Node temp, int el ) {
    Node prev=temp.back;
    Node newnode = new Node(el,temp,prev);
    prev.next = newnode;
    newnode.next=temp;

    return temp;
}






//insert a val after a given node el
private static Node insertAfter(Node head, int el, int val ) {
    Node temp = head;
    while (temp!= null) {
        
        if(temp.data==el) break;
        temp = temp.next;
    }
    Node front=temp.next;
    Node newnode = new Node(val,front,temp);
    temp.next = newnode;
    newnode.next=front;

    return head;
}





//insert after a given node el and node!=head
 
  private static Node insertAfterNode(Node temp, int el ) {
    Node front=temp.next;
    Node newnode = new Node(el,front,temp);
    temp.next = newnode;
    newnode.next=front;

    return temp;
}


  
 
//main function
 public static void main(String args[])
 {
  int arr[] = {2, 4, 8, 7, 1, 9, 5, 3};

  //convert array to DLL
  Node head = Arr2LL(arr);

  //insert at the beginning of DLL
   //head=insertStart(head, 1211);

  //insert at the end of DLL
   //head=insertEnd(head, 1211);

 //insert before the end of the DLL
   //head= insertBeforeEnd(head, 1211);
 
 //insert at the kth position
   //head= insertKthPosition(head, 1211, 3);

//insert before a given node
   //head= insertBefore(head, 9, 1211);

//insert before a given node and node!=head
   // head= insertBeforeNode(head.next.next.next, 1211);

 //insert a val after a given node el
    //head= insertAfter(head, 9, 1211);


//insert after a given node and node!=head
   head= insertAfterNode(head.next.next, 1211);

  //print the DLL
   print(head);
 }
}