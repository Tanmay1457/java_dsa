import java.util.LinkedList;

public class LinkedList_P1 {

    //node creation
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;

        }
    }
    //Head and Tail Creation
    public static Node head;
    public static Node tail;
    //Size of linked list initailly 0
    public static int size;

    //Add New Node at first
    public void addFirst(int data){
        //1- create new node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        //2- newNode next = head
        newNode.next = head; //link
        //3- head = newNode
        head = newNode;
    }
    //Add New Node at last
    public void addLast(int data){
        //1- create new node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //Method for printing Linkedlist
    public void print(){

        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Add element at middle
    public void add(int idx, int data){
        //if add at first
        if (idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove first node
    public int removeFirst(){
        //case 1 size=0
        if (size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        //case 2 size 1
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove last node
    public int removeLast(){
        if (size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //previous index = size - 2 (i.e 2nd last index)
        Node prev = head;
        for (int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Iterative search
    public int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while (temp != null){
            if (temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public int helper(Node head, int key){ //O(n)
        if (head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx ==  -1){
            return -1;
        }
        return idx+1;
    }
    //Recursive search
    public int recSearch(int key){
        return helper(head,key);
    }

    //Reverse a linked list (Iterative approach)
    public void reverse(){ //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Find and remove nth node from end
    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }
        if (n == sz){
            head = head.next; //remove first
            return;
        }
        //sz-n
        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; //form dirct link by removing middle node
        return;
    }

    //Check LL is palindrome or not........................

    //slow fast approach
    public Node findMid(Node head){
        Node slow = head; //+1 jump
        Node fast = head; //+2 jump
        while (fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow=mid
    }

    public boolean checkPalindrome(){
        if (head == null || head.next == null){
            return true;
        }
        //step1 find mid
        Node midNode = findMid(head);
        //step2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;

        }
        Node right = prev; // right half head
        Node left = head;

        //step3 check left half == right half
        while (right != null){
            if (left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //Detecting Cycle in LL
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null ){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast){
            return true; //cycle exist
            }
        }
        return false; //cycle not exist

    }

    //Remove Cycle in LL
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                cycle = true;
                break;

            }
        }
        if (cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null; //last node
        while (slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next = null
        prev.next = null;

    }
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //mid node
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1); //dummy node
        Node temp = mergedLL;
        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    //Merge sort in LL
    public Node mergeSort(Node head){
        //Base case
        if (head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left & right of midsort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head); //left half
        Node newRight = mergeSort(rightHead); //right half

        //Merge
        return merge(newLeft,newRight);
    }

    //Zig zag Linked list
    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL , nextR;

        //alternate merge
        while (left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;

        }
    }

    public static void main(String[] args) {
      LinkedList_P1 ll = new LinkedList_P1(); //object created of name ll
        //Add element
//        ll.print();
//        ll.addFirst(2);
//        ll.print();
//        ll.addFirst(1);
//        ll.print();
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(2);
//        ll.addLast(1);
//        ll.print();

        //add at middle
//        ll.add(2,9);
//        ll.print();
        //size
//        System.out.println(ll.size);

        //Remove first
//          ll.removeFirst();
//          ll.print();
//          System.out.println(ll.size);

        //Remove last
//          ll.removeLast();
//          ll.print();
//          System.out.println(ll.size);

        //Search in LL
//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.itrSearch(10));

        //recursive search
//        System.out.println(ll.recSearch(3));
//        System.out.println(ll.recSearch(10));

        //Reverse
//        ll.reverse();
//        ll.print();

        //Delete nth node from last
//        ll.deleteNthfromEnd(3);
//        ll.print();

        //Palindrome
//        System.out.println(ll.checkPalindrome());

        //Detecting cycle..........
//        head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next.next = head; //1->2->3->1

//        head = new Node(1);
//        Node temp = new Node(2);
//        head.next = temp;
//        head.next.next = new Node(3);
//        head.next.next.next = temp;
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());


//Merge sort.......
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();
        //ll.head = ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();

    }

 }


