import java.util.*;

class Node {
    int data;      // the data value
    Node next;      // the reference to the next Node in the linked list
    // Constructors
    Node(int data1, Node next1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = next1;  // Initialize next with the provided reference
    }
    Node(int data1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = null;   // Initialize next as null since it's the end of the list
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


//delete the head of the LL
  public static Node DeleteHead(Node head) {
    if (head == null || head.next == null) {
        return null; // If the list is empty or has only one node
    }
    head = head.next; // Move head to the next node
    return head;
  }



//delete tail of LL
   public static Node DeleteTail(Node head) {
    if (head == null || head.next == null) {
        return null; // If the list is empty or has only one node
    }
    Node temp=head;
    while(temp.next.next!=null){
     temp=temp.next;
    }
    temp.next=null; // set temp.next node  to null node
    return head;
   }



//delete kth el of the LL 
    public static Node DeleteK(Node head, int k) {
    if(head==null){
      return null;
     }
    
    if(k==1){
      head=head.next;
      return head;
      }
    
    int cnt=0;
    Node temp=head;
    Node prev= temp;
    while(temp!=null)
    {
     cnt++;
     if(cnt==k){
      prev.next=temp.next;
      break;
     }
    prev=temp;
    temp=temp.next;
   }
   return head;
 }

//or (with one ptr)
 public static Node deleteKth(Node head, int k){
        if(k==1){
            return head.next;
        }
        Node temp=head;
        while(temp.next!=null){
             
             k--;
            if(k==1){
                break;
            }
           temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }


    
    
    
//delete the particular el of the LL 
    public static Node Deleteparticular(Node head, int el) {
    if(head==null){
      return null;
     }
    
    if(head.data== el){
      head=head.next;
      return head;
      }
    
 
    Node temp=head;
    Node prev= temp;
    while(temp!=null)
    {
     if(temp.data==el){
      prev.next=temp.next;
      break;
     }
    prev=temp;
    temp=temp.next;
   }
   return head;
  }

    //or with one ptr)
 public static Node deletevalue(Node head, int el){
        if(head.data==el){
            head=head.next;
            return head;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.next.data==el){
                break;
            }
           temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }




    
//delete the before  particular el of the LL 
    public static Node DeleteBeforeparticular(Node head, int el) {
    if(head==null){
      return null;
     }
    
    if(head.next.data== el){
      head=head.next;
      return head;
      }
    
 
    Node temp=head;
    Node prev= temp;
    while(temp!=null)
    {
     if(temp.next.data==el){
      prev.next=temp.next;
      break;
     }
    prev=temp;
    temp=temp.next;
   }
   return head;
  }
    //OR
 public static Node deleteBefore(Node head, int el){
        if(head.next.data==el){
            head=head.next;
            return head;
        }
        Node temp=head;
        while(temp.next.next!=null){
            if(temp.next.next.data==el){
                break;
            }
           temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }






    
 //delete the after  particular el of the LL 
    public static Node DeleteAfterparticular(Node head, int el) {
    if(head==null){
      return null;
     }
    Node temp=head;
    Node prev= temp;
    while(temp!=null)
    {
     if(prev.data==el){
      prev.next=temp.next;
      break;
     }
    prev=temp;
    temp=temp.next;
   }
   return head;
  }

 // or
    public static Node deleteAfter(Node head, int el){
        if(head==null) return null;
        if(head.data==el){
            head=head.next.next;
            return head;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.data==el){
                break;
            }
           temp=temp.next;
        }
        if(temp.next==null) return head;
        else{
             temp.next=temp.next.next;
        }
       
        return head;
    }

    

    // main function
    public static void main(String args[]) {
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i]=sc.nextInt();
        // }
        
        int arr[] = { 12, 5, 3, 6, 7, 2, 8, 1 };
        Node head = Arr2LL(arr);
        
       //delete head of the LL
         // head=DeleteHead(head);  
        
       //delete tailof the LL
        //head=DeleteTail(head);
       
       //delete kth el of the LL 
         //head=DeleteK(head, 3);

        //delete the particular node
         //head= Deleteparticular(head, 6);

       // delete before of any node
        //head=  DeleteBeforeparticular(head, 6);

       // delete after of any node
        head=  DeleteAfterparticular(head, 6);
        
       print(head);
    }
}

