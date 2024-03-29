import java.util.ArrayList;
import java.util.Stack;
import java.util.*; //for collection framework implementation


//
//public class stacks {
//
//    //Arraylist Implementation......................................
//
//    static class Stack{
//        static ArrayList<Integer> list = new ArrayList<>();
//        public static boolean isEmpty(){
//            return list.size()==0;
//        }
//
//        //Push
//        public static void push(int data){
//            list.add(data);
//        }
//
//        //pop
//        public static int pop(){
//            if (isEmpty()){
//                return -1;  //corner case when stack empty
//            }
//            int top = list.get(list.size()-1);
//            list.remove(list.size()-1);
//            return top;
//        }
//
//        //peek
//        public static int peek(){
//            if (isEmpty()){
//                return -1;  //corner case when stack empty
//            }
//            return list.get(list.size()-1);
//        }
//
//
//
//
//    }
//    public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);
//
//         while (!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }
//
//    }
//
//
//}

//Linked List Implementation..................................................
//public class stacks {
//    static class Node{
//        int data;
//        Node next;
//        Node(int data){
//            this.data = data;
//            this.next = null;
//        }
//    }
//    static class Stack {
//        static Node head = null;
//
//        public static boolean isEmpty() {
//            return head==null;
//        }
//
//        //push
//        public static void push(int data){
//            Node newNode = new Node(data);
//            if (isEmpty()) {
//                head = newNode;
//                return;
//            }
//            newNode.next = head;
//            head = newNode;
//        }
//
//        //pop
//        public static int pop(){
//            if (isEmpty()){
//                return -1;
//            }
//            int top = head.data;
//            head = head.next;
//            return top;
//        }
//
//        //peek
//        public static int peek(){
//            if (isEmpty()){
//                return -1;
//            }
//            return head.data;
//        }
//    }

//Push at bottom of stack...................................................

//    public static void pushAtBottom(Stack<Integer> s, int data){
//        if (s.isEmpty()){
//            s.push(data);
//            return;
//        }
//        int top = s.pop();
//        pushAtBottom(s,data);
//        s.push(top);
//    }


//    public static String reverseString(String str){
//        Stack<Character> s = new Stack<>();
//        int idx = 0;
//        while (idx < str.length()){
//            s.push(str.charAt(idx));
//            idx++;
//        }
//        StringBuilder result = new StringBuilder("");
//        while (!s.isEmpty()){
//            char curr = s.pop();
//            result.append(curr);
//        }
//        return result.toString();
//    }
//    public static void main(String[] args) {
//         //Stack s = new Stack();
//         Stack<Integer> s = new Stack<>(); //using collection framework implementation
//         s.push(1);
//         s.push(2);
//         s.push(3);
//
//         pushAtBottom(s,4);
//         while (!s.isEmpty()){
//             System.out.println(s.pop());
//         }

//         while (!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }

    //}

//}


public class stacks {

    //Reverse string using a stack................................................

//    public static String reverseString(String str) {
//        Stack<Character> s = new Stack<>();
//        int idx = 0;
//        while (idx < str.length()) {
//            s.push(str.charAt(idx));
//            idx++;
//        }
//        StringBuilder result = new StringBuilder("");
//        while (!s.isEmpty()) {
//            char curr = s.pop();
//            result.append(curr);
//        }
//        return result.toString();
//    }

    //Reverese a Stack............................................................
//    public static void pushAtBottom(Stack<Integer> s, int data){
//        if (s.isEmpty()){
//            s.push(data);
//            return;
//        }
//        int top = s.pop();
//        pushAtBottom(s,data);
//        s.push(top);
//    }
//
//    public static void reverseStack(Stack<Integer> s){
//        if (s.isEmpty()){
//            return;
//        }
//        int top = s.pop();
//        reverseStack(s);
//        pushAtBottom(s,top);
//    }
//    public static void printStack(Stack<Integer> s){
//        while (!s.isEmpty()){
//            System.out.println(s.pop());
//        }
//    }


    //Stock Span Problem............................................................
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i=1; i< stocks.length; i++){
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i] = i+1;
            }
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
//        String str = "abc";
//        String result = reverseString(str);
//        System.out.println(result); // Print the reversed string instead of the original string


//          Stack<Integer> s = new Stack<>();
//          s.push(1);
//          s.push(2);
//          s.push(3);
//          //input - 3,2,1
//
//          reverseStack(s);
//          printStack(s);
//          //Output - 1,2,3


            int stocks[] = {100,80,60,70,60,85,100};
            int span[] = new int[stocks.length];
            stockSpan(stocks,span);

            for (int i=0; i<span.length; i++){
                System.out.println(span[i]+" ");
            }


    }
}


