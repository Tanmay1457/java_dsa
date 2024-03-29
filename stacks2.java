import java.util.*;

//
//public class stacks2 {
//
//
//    public static void main(String[] args) {
//
////Next Greater element...............................................................
//        int arr[] = {6,8,0,1,3};
//        Stack<Integer> s = new Stack<>();
//        int nxtGreater [] = new int[arr.length];
//
//        for (int i=arr.length-1; i>=0; i--){
//
//            while (!s.isEmpty() && arr[s.peek()] <= arr[i]){ //1.........
//                s.pop();
//            }
//            if (s.isEmpty()){  //2.........
//                nxtGreater[i] = -1;
//
//            }else {
//                nxtGreater[i] = arr[s.peek()];
//            }
//
//            s.push(i); //3.......
//        }
//
//        for (int i=0; i< nxtGreater.length; i++){
//            System.out.print(nxtGreater[i]+" | ");
//        }
//        System.out.println();
//
//
//    }
//
////Valid Parenthesis..............................................................
//
//
//}
//
//
//    //Question variation ask only some change require in code
//    /*
//    1] next greater left  for (int i=0; i<=arr.length-1; i++)
//    2] next smaller while (!s.isEmpty() && arr[s.peek()] >= arr[i])
//    */
//

//Valid parenthesis....................................................

public class stacks2 {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){ //Opening
                s.push(ch);
            }else {
                //closing
                if (s.isEmpty()){
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }
                else {
                    return false;
                }
            }
        }
        if (s.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

//Duplicate Parenthesis...............................................................

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //closing
            if (ch == ')'){
                int count = 0;
                while (s.pop() != '('){
                    count++;
                }
                if (count < 1){
                    return true; //dupilcate
                }
            }
            else {
                //Opening
                s.push(ch);
            }
        }
        return false;
    }

//Max Area in Histogram
    public static void maxArea(int arr[]){ //O(n) optimized
        int maxArea = 0;
        int nsr[] = new int[arr.length]; //Next smallest right
        int nsl[] = new int[arr.length]; //Next smallest left

       //Next smallest right      //O(n)
        Stack<Integer> s = new Stack<>();

        for (int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i] = arr.length;
            }
            else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next smallest left   //O(n)

        s = new Stack<>();

        for (int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i] = -1;
            }
            else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area: width = j-i-1 = nsr[i] - nsl[i] - 1   //O(n)
        for (int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }

        System.out.println("max area in histogram = "+ maxArea);

    }
    public static void main(String[] args) {
//        String str = "]";
//        System.out.println(isValid(str));

//          String str = "((a+b))"; //true
//          String str2 = "(a-b)"; //false
//          System.out.println(isDuplicate(str2));

             int arr[] = {2,1,5,6,2,3}; //heights
             maxArea(arr);
    }
}
