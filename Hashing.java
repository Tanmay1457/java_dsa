import java.util.HashMap;
import java.util.*;


//public class Hashing {
//    public static void main(String[] args) {
//        //Create
//        HashMap<String,Integer> map = new HashMap<>();
//
//        //put operation O(1).........
//        map.put("india", 8);
//        map.put("America", 10);
//        map.put("canada", 6);
//        map.put("us",89);
//        System.out.println(map); //o/p:{canada=6, America=10, india=8} it is unordered map
///*
//        //get opertaion O(1)...........
//        int usVAl = map.get("America");  //o/p 10
//        System.out.println(usVAl);
//        System.out.println(map.get("Dubai")); //o/p null
//
//       // isConstainsKey operation O(1)..........
//        System.out.println(map.containsKey("russia")); //o/p false
//
//
//
//       //remove() operation O(1) return removed key value and then delete both  ............
// */
////        System.out.println(map.remove("canada"));
////        System.out.println(map);
//        //o/p
//       // {canada=6, America=10, india=8}
//       // 6
//       // {America=10, india=8}
//        //if key not present return null
//
//        //get size
//        System.out.println(map.size());
//
//        //isEmpty()
//        System.out.println(map.isEmpty()); //false
//
//        //clear operation clear all hashmap
////        map.clear();
////        System.out.println(map.isEmpty()); //true
//
//        //Iteration on Maps
//        Set<String> keys = map.keySet(); //here we apply loop on keyset not on hashmap
//        System.out.print(keys);
//        System.out.println();
//        for (String s : keys) { //it is "foreach" loop
//            System.out.println("Key = " + s + ", Correspond Value= " + map.get(s));
//        }
//
//        //Alternative of Iteration
//        System.out.println( map.entrySet()); //o/p [canada=6, America=10, india=8, us=89]
//
//    }
//}
//


//Hashmap total implementation from scratch............................................................



//public class Hashing {
//
//    static class HashMap<K,V> {   //generic (generic parametarized form = can be String, Int, Boolean, Float etc.) i.e type not fixed it take generically
//
//        private class Node { //it is node in linked list bucket
//            K key;
//            V val;
//            //Constructor
//            public Node(K key, V val) {
//                this.key = key;
//                this.val = val;
//            }
//        }
//
//        private int n;   //Total no. of Nodes in Buckets[] = n
//        private int N;   //Size of the bucket || (bucket.length)
//        private LinkedList<Node> buckets[];  // Array of LinkedList = N = buckets.length || HashMap
//
//        @SuppressWarnings("unchecked")
//        public HashMap() { //constructor
//            this.N = 4;
//            this.buckets = new LinkedList[4]; //bucket size = 4 in some version of java LinkedList[4] we need to tell type of LL it give error to avoid it we use @SuppressWarnings
//            for(int i=0; i<4; i++) {
//                buckets[i] = new LinkedList<>(); //linked list or node created in each bucket
//            }
//        }
//
//
//        //⭐
//        public int hashFun(K key) {
//            int hc = key.hashCode(); //any type value return int value
//            return Math.abs(hc) % N; //find absolute value and finding index with modulo of size
//        }
//
//        //⭐
//        private int searchInLL(K key, int bucketIdx) {
//            LinkedList<Node> ll = buckets[bucketIdx];
//            int dataIdx = 0;
//            for(int i=0; i<ll.size(); i++) {
//                Node node = ll.get(i);
//                if(node.key == key) {
//                    return dataIdx;
//                }
//                dataIdx++;
//            }
//            return -1; //if key not found
//        }
//
//        //⭐
//        @SuppressWarnings("unchecked")
//        private void reHash() {
//            LinkedList<Node> oldSize[] = buckets;
//            buckets = new LinkedList[N*2]; //create bucket of size two tme greater than original
//            N = 2*N;
//            for(int i=0; i<buckets.length; i++) {
//                buckets[i] = new LinkedList<>();
//            }
//
//            //Nodes -> add in bucket
//            for(int i=0; i<oldSize.length; i++) { //run loop on current bucket
//                LinkedList<Node> ll = oldSize[i];
//                for(int j=0; j<ll.size(); j++) {
//                    Node node = ll.remove();
//                    put(node.key, node.val);
//                }
//            }
//        }
//
//        //put...............
//        public void put(K key, V val) {
//            int bucketIdx = hashFun(key);
//            int dataIdx = searchInLL(key, bucketIdx); //search on LL to return data
//            if(dataIdx != -1) { //Node exist - valid Node
//                Node node = buckets[bucketIdx].get(dataIdx); //arry->node->find node
//                node.val = val;
//            }
//            else {
//                buckets[bucketIdx].add(new Node(key, val)); //adding new node passing new key and value
//                n++;
//            }
//
//            //ReHashing.....
//            double lambda = (double)n / N;
//            if(lambda > 2.0) {
//                reHash();
//            }
//        }
//
//
//        //ContainsKey()......................
//        public boolean containsKey(K key) {
//            int bucketIdx = hashFun(key);
//            int dataIdx = searchInLL(key, bucketIdx);
//
//            if(dataIdx != -1) { //valid -exist
//                return true;
//            }
//            return false; //not exist
//        }
//
//        //get().........................
//        public V get(K key) {
//            int bucketIdx = hashFun(key);
//            int dataIdx = searchInLL(key, bucketIdx);
//            if(dataIdx != -1) { //exist
//                Node node = buckets[bucketIdx].get(dataIdx); //find node
//                return node.val; //return node
//            }
//            else return null;
//        }
//
//
//        //remove()..........................
//        public V remove(K key) {
//            int bucketIdx = hashFun(key);
//            int dataIdx = searchInLL(key, bucketIdx);
//
//            if(dataIdx != -1) {
//                Node node = buckets[bucketIdx].remove(dataIdx);
//                n--; //Decreasing the size of LinkedList
//                return node.val; //return node value
//            }
//            return null;
//        }
//
//        //keySet()..................................
//        public ArrayList<K> keySet() {
//            ArrayList<K> keys = new ArrayList<>();
//            for(int i=0; i<buckets.length; i++) {
//                LinkedList<Node> ll = buckets[i];
//                for (Node node : ll) {
//                    keys.add(node.key);
//                }
//            }
//            return keys;
//        }
//
//        //isEmpty().................................
//        public boolean isEmpty() {
//            return  n == 0; //if Size is equal to zero Means my HAshMap is Empty
//        }
//    }
//    public static void main(String args[]) {
//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("India", 500);
//        hm.put("Canada", 200);
//        hm.put("USA", 100);
//        hm.put("UK", 300);
//        ArrayList<String> keys = hm.keySet();
//        for (String key : keys) { //for each loop
//            System.out.println(key);
//        }
//        System.out.println(hm.get("UK"));
//        System.out.println(hm.remove("UK"));
//        System.out.println(hm.containsKey("UK"));
//
//    }
//}



public class Hashing {
    public static void main(String[] args) {

        //Linked hashmap................................

        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>(); //store valued according to insertion order
        lhm.put("india",100); //it implemented by doubly linked list internally to maintain order....
        lhm.put("uk",10);
        lhm.put("china",90);

        //hashmap................................

        HashMap<String, Integer> hm = new HashMap<>(); //unordered
        hm.put("india",100);
        hm.put("uk",10);
        hm.put("china",90);

        //Linked hashmap................................

        TreeMap<String, Integer> tm = new TreeMap<>(); //store valued according to alphabetical order of key and return it
        tm.put("india",100); //it implemented by Red Black Tree (self balancing BT) internally to maintain order....
        tm.put("uk",10);  //Time complexity = O(log n)
        tm.put("china",90);

        System.out.println("Linked hashmap = "+lhm);
        System.out.println("Hashmap = "+ hm);
        System.out.println("Treemap = "+ tm);


    }
}