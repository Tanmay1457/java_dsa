//import java.util.ArrayList;
//
//public class Greedyalgorithm {
//    public static void main(String[] args) {
//
//        //Activity Selection O(n)..........................
//        int start[] = {1,3,0,5,8,5};
//        int end[] = {2,4,6,7,9,9}; //already sorted
//
//        int maxAct = 0;
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        //1st activity
//        maxAct = 1;
//        ans.add(0);
//        int lastEnd = end[0];
//        for (int i=1; i<end.length; i++){
//            if (start[i] >= lastEnd){
//                //activity select
//                maxAct++;
//                ans.add(i);
//                lastEnd = end[i];
//
//            }
//        }
//
//        System.out.println("max activities = " + maxAct);
//        for (int i=0; i< ans.size(); i++){
//            System.out.print("A"+ans.get(i)+" ");
//        }
//        System.out.println();
//    }
//}

//if end time not sorted......................................
import java.util.*;

//public class Greedyalgorithm {
//    public static void main(String[] args) {
//
//        //Activity Selection O(n)
//        int start[] = {1,3,0,5,8,5};
//        int end[] = {2,4,6,7,9,9};
//
//        //sorting
//        int activities[][] = new int[start.length][3];
//        for (int i=0; i<start.length; i++){
//            activities[i][0] = i;
//            activities[i][1] = start[i];
//            activities[i][2] = end[i];
//        }
//
//        //lambda function
//        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
//
//        int maxAct = 0;
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        //1st activity
//        maxAct = 1;
//        ans.add(activities[0][0]);
//        int lastEnd = activities[0][2];
//        for (int i=1; i<end.length; i++){
//            if (activities[i][1] >= lastEnd){
//                //activity select
//                maxAct++;
//                ans.add(activities[i][0]);
//                lastEnd = activities[i][2];
//
//            }
//        }
//
//        System.out.println("max activities = " + maxAct);
//        for (int i=0; i< ans.size(); i++){
//            System.out.print("A"+ans.get(i)+" ");
//        }
//        System.out.println();
//    }
//}

//Fractional Knapsack......................................

//public class Greedyalgorithm {
//    public static void main(String[] args) {
//        int val [] = {60,100,120};
//        int weight[] = {10,20,30};
//        int W = 50;
//
//        double ratio[][] = new double[val.length][2]; //0th col= index, 1st col= ratio
//
//        for (int i=0; i< val.length; i++){
//            ratio[i][0] = i;
//            ratio[i][1] = val[i]/(double)weight[i];
//        }
//        //ascending order
//        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
//
//        int capacity = W;
//        int finalVal = 0;
//        for (int i= ratio.length-1; i>=0; i--){ //for descending order reverse condition
//            int idx = (int)ratio[i][0];
//            if (capacity >= weight[idx]){ //include full item
//                finalVal += val[idx];
//                capacity -= weight[idx];
//            }
//            else {
//                //include fractional item
//
//                finalVal += (ratio[i][1] * capacity);
//                capacity = 0;
//                break;
//
//            }
//        }
//        System.out.println("final value =" + finalVal);
//    }
//}

//Minimum absolute difference.......................................

//public class Greedyalgorithm {
//    public static void main(String[] args) { //O(nlogn)
//        int A[] = {4,1,8,7};
//        int B[] = {2,3,6,5};
//
//        Arrays.sort(A);
//        Arrays.sort(B);
//
//        int minDiff = 0;
//        for (int i=0; i< A.length; i++){
//            minDiff += Math.abs(A[i]-B[i]);
//        }
//        System.out.println("Min absolute difference of pairs = "+minDiff);
//    }
//}

//Maximum length chain of pairs........................................

public class Greedyalgorithm {
    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainlength = 1;
        int chainend = pairs[0][1]; // last selected pair end

        for (int i=1; i< pairs.length; i++){
            if (pairs[i][0] > chainend){
                chainlength++;
                chainend= pairs[i][1];
            }
        }
        System.out.println("max length of chain = " + chainlength);
    }
}