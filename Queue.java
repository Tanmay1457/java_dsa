//public class Queue {
//
////Array implementation....................
//    static class QueueB {
//        static int arr[];
//        static int size;
//        static int rear;
//        static int front;  // changes for circular queue
//
//        QueueB(int n) { //constructor
//            arr = new int[n];
//            size = n;
//            rear = -1;
//            front = -1; // changes for circular queue
//        }
////        public static boolean isEmpty(){
////            return rear == -1;
////        }
//    // changes for circular queue
//        public static boolean isEmpty() {
//            return rear == -1 && front == -1;
//        }
//
//        public static boolean isFull(){
//            return (rear+1)%size == front;
//        }
//
//        //add
////        public static void add(int data){
////            if (rear == size-1){
////                System.out.println("queue is full");
////                return;
////            }
////            rear = rear + 1;
////            arr[rear] = data;
////        }
//
//        // changes for circular queue
//       public static void add(int data){
//           if (isFull()){
//             System.out.println("queue is full");
//             return;
//        }
//        //add 1st element
//        if (front == -1){
//            front = 0;
//        }
//        rear = (rear + 1)%size;
//        arr[rear] = data;
//       }
//
//        //remove
//        public static int remove(){
//            if (isEmpty()){
//                System.out.println("empty queue");
//                return -1;
//            }
//
////            int front = arr[0];
////            for (int i=0; i<rear; i++){  //due to this it take O(n) time
////                arr[i] = arr[i+1];
////            }
////            rear = rear - 1;
////            return front;
//
//            // changes for circular queue
//            int result = arr[front];
//
//            //last element delete
//            if (rear == front){
//                rear = front = -1;
//            }else {
//                front = (front+1)%size;
//            }
//            return result;
//        }
//
//        //peek
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("empty queue");
//                return -1;
//            }
////            return arr[0];
//
//            // changes for circular queue
//            return arr[front];
//        }
//    }
//    public static void main(String[] args) {
//        //Array
//           QueueB q = new QueueB(3);
//           q.add(1);
//           q.add(2);
//           q.add(3);
//
//        // changes for circular queue
//        System.out.println(q.remove());
//        q.add(4);
//        System.out.println(q.remove());
//        q.add(5);
//
//
//           while (!q.isEmpty()){
//               System.out.println(q.peek());
//               q.remove();
//           }
//    }
//}
//
//


//public class Queue {
//
//    //Linked list  implementation....................
//    static class Node {
//        int data;
//        Node next;
//
//        Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    static class QueueB {
//        static Node head = null;
//        static Node tail = null;
//
//
//        public static boolean isEmpty() {
//            return head == null && tail == null;
//        }
//
//
//        //add
//        public static void add(int data){
//            Node newNode = new Node(data);
//            if (head == null){
//                head = tail = newNode;
//                return;
//            }
//            tail.next = newNode;
//            tail = newNode;
//        }
//
//        //remove
//        public static int remove(){
//            if (isEmpty()){
//                System.out.println("empty queue");
//                return -1;
//            }
//            int front = head.data;
//            //single element
//            if (tail == head){
//                tail = head =null;
//            }else {
//                head = head.next;
//            }
//            return front;
//
//        }
//
//        //peek
//        public static int peek(){
//            if (isEmpty()){
//                System.out.println("empty queue");
//                return -1;
//            }
//
//            return head.data;
//        }
//    }
//    public static void main(String[] args) {
//        //Array
//        QueueB q = new QueueB();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }
//    }
//}

//using collection framework  O(1) for all Operation .......................
//import java.util.*;
//
//public class Queue {
//
//    public static void main(String[] args) {
//
//        //java.util.Queue<Integer> q = new LinkedList<>(); // or ArrayDeque take more info for this
//
//        java.util.Queue<Integer> q = new ArrayDeque<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//
//        while (!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();
//        }
//    }
//}

//Queue using two stack......................

import java.util.*;
//Queue using 2 stacks .............

//public class Queue {
//    static class QueueB {
//        static Stack<Integer> s1 = new Stack<>();
//        static Stack<Integer> s2 = new Stack<>();
//
//        public static boolean isEmpty() {
//            return s1.isEmpty();
//        }
//
//        // add O(n)
//        public static void add(int value) {
//            while (!s1.isEmpty()) {
//                s2.push(s1.pop());
//            }
//            s1.push(value);
//            while (!s2.isEmpty()) {
//                s1.push(s2.pop());
//            }
//        }
//
//        // remove O(1)
//        public static int remove() {
//            if (isEmpty()) {
//                System.out.println("queue empty");
//                return -1;
//            }
//            return s1.pop();
//        }
//
//        // peek O(1)
//        public static int peek() {
//            if (isEmpty()) {
//                System.out.println("queue empty");
//                return -1;
//            }
//            return s1.peek();
//        }
//    }
//
//    public static void main(String[] args) {
//        QueueB q = new QueueB();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//
//        while (!q.isEmpty()) {
//            System.out.println(q.peek());
//            q.remove();
//        }
//    }
//}

