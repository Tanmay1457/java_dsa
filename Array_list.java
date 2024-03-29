////import java.util.ArrayList;
////import java.util.Collections;
////for all things import
import java.util.*;
//
//public class Array_list {
//    public static void main(String[] args) {
//     //Syntax
//     ArrayList<Integer> list = new ArrayList<>();
////Operation on Arraylist.............................................................................
//
////     //Add operation :- we add value dynamically
////        list.add(1); //O(1)
////        list.add(2);
////        list.add(3);
////       // list.add(1,9); //adding element at index O(n)
////        System.out.println(list);
////
////   //size of Arraylist it is method or function
////        System.out.println(list.size());
////     //Get operation :- print element present at which index
////        int element = list.get(1);
////        System.out.println(element);
////
////     //Remove operation :- remove element at specific index
////        list.remove(1);
////        System.out.println(list);
////
////     //Set :- set value at index
////     list.set(0,4);
////        System.out.println(list);
////
////     //Contain element :- checking element present or not
////        System.out.println(list.contains(1));
//
////Print reverse of arraylist................................................................
//        list.add(2);
//        list.add(5);
//        list.add(6);
//        list.add(9);
//        list.add(8);
//
////        for (int i= list.size()-1;i>=0; i--){
////            System.out.print(list.get(i) + " ");
////        }
////        System.out.println( );
//
////Find Maximum in arraylist....................................................................
//        //  O(n)
//        int max = Integer.MIN_VALUE; //-infinity
//        for (int i=0; i< list.size();i++){
////            if (max < list.get(i)){
////               max = list.get(i);
////            }
//     //or
//              max = Math.max(max, list.get(i));
//        }
//        System.out.println("Max Element = "+ max);
//
//
////Swap Two Number..............................................................................
//       int idx1 = 1, idx2 = 3;
//        System.out.println(list);
//        swap(list,idx1,idx2);
//        System.out.println(list);
//
////Sorting an Arraylist..........................................................................
//        System.out.println("Initial list "+ list);
//        Collections.sort(list); //acending order
//        System.out.println("list after sorting "+ list);
//        //descending
//        Collections.sort(list,Collections.reverseOrder());//comparator
//        System.out.println(list);
//
////Multidimensional Arraylist...................................................................
//        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
//        //list 1
//        ArrayList<Integer> list1 = new ArrayList<>();
//        list1.add(1); list1.add(2);
//        mainList.add(list1); //add in mainlist
//
//        //list 2
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(3); list2.add(4);
//        mainList.add(list2);
//
//        for (int i=0; i<mainList.size(); i++){
//            ArrayList<Integer> currList = mainList.get(i);
//            for (int j=0; j<currList.size(); j++){
//                System.out.print(currList.get(j) + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(mainList);
//
////Container with most water......................................................................
//
//        ArrayList<Integer> height = new ArrayList<>();
//        height.add(1);
//        height.add(8);
//        height.add(6);
//        height.add(2);
//        height.add(5);
//        height.add(4);
//        height.add(8);
//        height.add(3);
//        height.add(7);
//        System.out.println("Maximum Water stored by container ");
//        System.out.println(storeWater(height));
//    }
//
//    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
//        int temp = list.get(idx1);
//        list.set(idx1, list.get(idx2));
//        list.set(idx2,temp);
//    }
//
////    public static int storeWater(ArrayList<Integer> height){
////        int maxWater = 0;
////        //Brute Force Approach
////        for (int i=0; i< height.size(); i++){
////            for (int j=i+1; j< height.size(); j++){
////                int ht = Math.min(height.get(i), height.get(j) );
////                int width = j-i;
////                int currWater = ht * width;
////                maxWater = Math.max(maxWater,currWater);
////            }
////        }
////        return maxWater;
////    }
//
//    //2 Pointer approach O(n) ........................
//    public static int storeWater(ArrayList<Integer> height){
//        int maxWater = 0;
//        int LP = 0; //left
//        int RP = height.size()-1; //right
//
//        while (LP < RP){
//            //calculate water area
//            int ht = Math.min(height.get(LP), height.get(RP));
//            int width = RP - LP;
//            int currWater = ht * width;
//            maxWater = Math.max(maxWater,currWater);
//
//            //update ptr
//            if (height.get(LP) < height.get(RP)){
//                LP++;
//            }else {
//                RP--;
//            }
//        }
//        return maxWater;
//
//    }
//}
public class Array_list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        int target = 15;
//        System.out.println(pairsum1(list,target));

        //11,15,6,8,9,10 - sorted and rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        System.out.println(pairsum2(list,target));

    }

//Pair sum 1................................................................................
    //Brute Force
//   public static boolean pairsum1(ArrayList<Integer> list,int target){
//        for (int i=0; i< list.size(); i++){
//            for (int j=i+1; j< list.size(); j++){
//                if (list.get(i) + list.get(j) == target){
//                    return true;
//                }
//            }
//        }
//        return false;
//   }
    //2 pointer approach..................
//     public static boolean pairsum1(ArrayList<Integer> list,int target){
//        int LP = 0;
//        int RP = list.size()-1;
//
//        while (LP != RP){
//            //case 1
//            if (list.get(LP)+ list.get(RP) == target){
//                return true;
//            }
//            //case 2
//            if (list.get(LP)+ list.get(RP) < target){
//                LP++;
//            }else {
//                //case 3
//                RP--;
//            }
//        }
//        return false;
//     }

//Pair sum 2................................................................................

    //2 pointer approach.........
    public static boolean pairsum2(ArrayList<Integer> list, int target) {
        int bp = -1; //intial breaking point
        int n = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) { //breaking point
                bp = i;
                break;
            }
        }
        int LP = bp + 1; //smallest
        int RP = bp; //Largest
        while (LP != RP) {
            //case 1
            if (list.get(LP) + list.get(RP) == target) {
                return true;
            }
            //case 2
            if (list.get(LP) + list.get(RP) < target) {
                LP = (LP + 1) % n;
            } else {
                //case 3
                RP = (n + RP - 1) % n;
            }

        }

        return false;
    }
}


