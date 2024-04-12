import java.util.*;

//Majority Element O(n)...............................................

//public class Hashing_2{
//
//
//    public static void main(String args[]) {
//        int arr[] = {1,2,3,5,1,3,2,5,1,1};
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<arr.length; i++) {
//            // if(map.containsKey(arr[i])) {
//            //     map.put(arr[i], map.get(arr[i]+1));
//            // }
//            // else
//            // map.put(arr[i], 1);
//
//            //optimization
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); //ShortCut of upper 4 lines
//        }
//
////        Set<Integer> keySet = map.keySet();
////        for (Integer key : keySet) {
////            if(map.get(key) > arr.length/3) {
////                System.out.println(key);
////            }
////        }
//
//        //optimization for above
//        for (Integer key : map.keySet()) { //shortCut of upper 1 line
//            if(map.get(key) > arr.length/3) {
//                System.out.println(key);
//            }
//        }
//    }
//}


//Valid Anagram O(n)...............................................

//public class Hashing_2 {
//
//    public static boolean isValidAnagrams(String s1, String s2) {
//        if(s1.length() != s2.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<s1.length(); i++) { //string 1
//            char ch = s1.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for(int i=0; i<s2.length(); i++) { //string 2
//            char ch = s2.charAt(i);
//            if(map.get(ch) != null) {
//                if(map.get(ch) == 1) {
//                    map.remove(ch);
//                }
//                else {
//                    map.put(ch, map.get(ch) - 1);
//                }
//            }
//            else {
//                return false;
//            }
//        }
//        return map.isEmpty();
//    }
//    public static void main(String args[]) {
//        String s1 = "race";
//        String s2 = "care";
//        System.out.println(isValidAnagrams(s1, s2));
//    }
//}


//Hashset...........................................................

//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.HashSet;
//import java.util.TreeSet;
//
//public class Hashing_2 {
//
//    public static void main(String args[]) {
////         HashSet<Integer> set = new HashSet<>();
////         set.add(2);
////         set.add(3);
////         set.add(4);
////         set.add(4);
////         set.add(3);
////
////         System.out.println(set); //o/p [2, 3, 4]
////         System.out.println(set.contains(3));
////         System.out.println(set.contains(1));
////
////         set.remove(3);
////         System.out.println(set.contains(3));
////         System.out.println(set.size());
////         set.clear();
////         System.out.println(set.isEmpty());
//
//
////Iteration on HashSet...........
//        HashSet<String> cities = new HashSet<>(); //unordered
//        cities.add("Vrindavan");
//        cities.add("Ayodhya");
//        cities.add("TirupatiBalaji");
//        cities.add("JagannathPuri");
//        System.out.println("Hashset (Unordered) : "+cities);
//
//// Linked Hashset (Ordered)............
//        LinkedHashSet<String> LHS = new LinkedHashSet<>();
//        LHS.add("Vrindavan");
//        LHS.add("Ayodhya");
//        LHS.add("TirupatiBalaji");
//        LHS.add("JagannathPuri");
//        System.out.println("LinkedHashset (Ordered) : "+LHS);
//
//        //Method 1 for traversing
//        System.out.println("Using Iterator:........... ");
//        Iterator it = cities.iterator(); //it is also used for Linked hashset just replace cities to LHS
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
//
////        //Method 2 for traversing
//        System.out.println("Using enhanced for loop : .......... ");
//        for (String city : cities) { //it is also used for Linked hashset just replace cities to LHS
//            System.out.println(city);
//        }
//
//
////TreeSet O(log n).............................................................
//
//        TreeSet<String> ts = new TreeSet<>();
//        ts.add("Vrindavan");
//        ts.add("Ayodhya");
//        ts.add("TirupatiBalaji");
//        ts.add("JagannathPuri");
//        System.out.println("TreeSet (alphabetical order) : "+ts);
//
//    }
//}


//Count Distinct Elements O(n)........................................................

//public class Hashing_2 {
//    public static void main(String args[]) {
//        int arr[] = {4,3,2,5,6,7,3,4,2,1};
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0; i<arr.length; i++) {
//            set.add(arr[i]);
//        }
//        System.out.println("Distinct Elements Count is : " + set.size());
//    }
//}


//Union & intersection of set O(n+m)..................................


//public class Hashing_2 {
//
//
//    public static void main(String args[]) {
//        int arr1[] = {7, 3, 9};
//        int arr2[] = {6, 3, 9, 2, 9, 4};
//        HashSet<Integer> set = new HashSet<>();
//
//        //Union
//        for(int i=0; i<arr1.length; i++) {
//            set.add(arr1[i]);
//        }
//        for(int i=0; i<arr2.length; i++) {
//            set.add(arr2[i]);
//        }
//        System.out.println("Union of two set is : "+set.size());
//        System.out.println(set);
//
//
//        //InterSection
//        HashSet<Integer> intersectionSet = new HashSet<>();
//        HashSet<Integer> newSet = new HashSet<>();
//        for(int i=0; i<arr1.length; i++) {
//            newSet.add(arr1[i]);
//        }
//        int count = 0;
//        for(int i=0; i<arr2.length; i++) {
//            if(newSet.contains(arr2[i])) {
//                count++;
//                intersectionSet.add(arr2[i]);
//                newSet.remove(arr2[i]);
//
//            }
//        }
//        System.out.println("InterSection of the arr1 & arr2 is : "+ count);
//        System.out.println(intersectionSet);
//    }
//}


//Find Itinerary from Tickets O(n)..................................................

//public class Hashing_2 {
//
//    public static String getStartPoint(HashMap<String, String> tickets) {
//        //Create reverseMap
//        HashMap<String, String> revMap = new HashMap<>();
//        for (String key : tickets.keySet()) {
//            revMap.put(tickets.get(key), key);
//        }
//        //find Starting Point which is not exist in revMap And exist in Original map
//        for (String key : tickets.keySet()) {
//            if(!revMap.containsKey(key)) {
//                return key; //Starting point found
//            }
//        }
//        return null;
//    }
//    public static void main(String args[]) {
//        HashMap<String, String> tickets = new HashMap<>();
//        tickets.put("Chennai", "Bengaluru");
//        tickets.put("Mumbai", "Delhi");
//        tickets.put("Delhi", "Goa");
//        tickets.put("Goa", "Chennai");
//
//        String start = getStartPoint(tickets);
//        System.out.print(start); //print starting point
//        for (String key : tickets.keySet()) {
//            System.out.print(" -> " + tickets.get(start));
//            start = tickets.get(start); //update start
//        }
//        System.out.println();
//    }
//}
//


//Largest Subarray with 0 sum O(n).......................................................


//public class Hashing_2{
//
//    public static void main(String args[]) {
//        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int sum = 0;
//        int len = 0;
//        for(int j=0; j<arr.length; j++) {
//            sum += arr[j];
//            if(map.containsKey(sum)) {
//                //Update Length
//                len = Math.max(j, j-map.get(sum)); // j-map.get(sum) = indicates i
//            }
//            else {
//                map.put(sum, j);
//            }
//        }
//
//        System.out.println("Length of the Largest subarray with sum 0 => " + len);
//    }
//}


//Subarray sum equal to k O(n)...................................................

public class Hashing_2 {  //TC = 0(n)
    public static void main(String args[]) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //By default Case
        int sum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i]; //sum(j)
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); //variation of if else
        }
        System.out.println(count);
    }
}