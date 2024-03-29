
import java.util.*;

//public class QueueB {
//    //Stacks using 2 Queues.............
//    static class Stack {
//        static Queue<Integer> q1 = new LinkedList<>();
//        static Queue<Integer> q2 = new LinkedList<>();
//
//        public static boolean isEmpty(){
//            return q1.isEmpty() && q2.isEmpty();
//        }
//
//        public static void push(int data){
//            if (!q1.isEmpty()){
//                q1.add(data);
//            }else {
//                q2.add(data);
//            }
//        }
//
//        public static int pop(){
//            if (isEmpty()){
//                System.out.println("empty stack");
//                return -1;
//            }
//            int top = -1;
//
//            //case 1
//            if (!q1.isEmpty()){
//                while (!q1.isEmpty()){
//                    top = q1.remove();
//                    if (q1.isEmpty()){
//                        break;
//                    }
//                    q2.add(top);
//                }
//            }else { //case 2
//                while (!q2.isEmpty()){
//                    top = q2.remove();
//                    if (q2.isEmpty()){
//                        break;
//                    }
//                    q1.add(top);
//                }
//            }
//            return top;
//        }
//
//        public static int peek() {
//            if (isEmpty()){
//                System.out.println("empty stack");
//                return -1;
//            }
//            int top = -1;
//
//            //case 1
//            if (!q1.isEmpty()){
//                while (!q1.isEmpty()){
//                    top = q1.remove();
//                    q2.add(top);
//                }
//            }else { //case 2
//                while (!q2.isEmpty()){
//                    top = q2.remove();
//                    q1.add(top);
//                }
//            }
//            return top;
//        }
//    }
//    public static void main(String[] args) {
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//
//        while (!s.isEmpty()){
//            System.out.println(s.peek());
//            s.pop();
//        }
//    }
//}


//First non repeating letter in stream of character.............................

//public class QueueB {
//    public static void printNonRepeating(String str){
//        int freq[] = new int[26]; //'a' - 'z'
//        Queue<Character> q = new LinkedList<>();
//
//        for (int i=0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            q.add(ch);
//            freq[ch-'a']++; //increment freq
//
//            while (!q.isEmpty() && freq[q.peek()-'a'] > 1){
//                q.remove();
//            }
//            if (q.isEmpty()){
//                System.out.print(-1+" ");
//            }else {
//                System.out.print(q.peek()+" ");
//            }
//        }
//        System.out.println();
//    }
//    public static void main(String[] args) {
//        String str = "aabccxb";
//        printNonRepeating(str);
//    }
//}


//Interleave 2 halves of queue..........................

//public class QueueB {
//    public static void interLeave(Queue<Integer> q){
//        Queue<Integer> firstHalf = new LinkedList<>();
//        int size = q.size();
//
//        for(int i=0; i<size/2; i++){
//            firstHalf.add(q.remove());
//        }
//
//        while (!firstHalf.isEmpty()){
//            q.add(firstHalf.remove());
//            q.add(q.remove());
//        }
//
//    }
//    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.add(8);
//        q.add(9);
//        q.add(10);
//
//        interLeave(q);
//        //print q
//        while (!q.isEmpty()) {
//            System.out.print(q.remove() + " ");
//        }
//        System.out.println();
//    }
//}

//Queue Reversal............................

import java.util.*;

//public class QueueB {
//    public static void reverse(Queue<Integer> q) {
//        Stack<Integer> s = new Stack<>();
//
//        while (!q.isEmpty()) {
//            s.push(q.remove());
//        }
//        while (!s.isEmpty()) {
//            q.add(s.pop());
//        }
//    }
//
//    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
//        q.add(5);
//
//        reverse(q);
//
//        // print q
//        while (!q.isEmpty()) {
//            System.out.print(q.remove() + " ");
//        }
//        System.out.println();
//    }
//}


//Deque....................

//public class QueueB {
//    public static void main(String[] args) {
//        Deque<Integer> deque = new LinkedList<>();
//        deque.addFirst(1);
//        deque.addFirst(2);// 2 1
//        deque.addLast(3);
//        deque.addLast(4);
//        System.out.println(deque);
//        deque.removeLast();
//        System.out.println(deque);
//
//        System.out.println("first ele"+ deque.getFirst());
//        System.out.println("first ele"+ deque.getLast());
//    }
//}

//Stack and queue using Deque

public class QueueB {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }

    static class Queue{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        System.out.println("peek="+s.peek());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek=" + q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
