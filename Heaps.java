import java.util.*;

public class Heaps {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) { //O(log n)
            arr.add(data);

            int child = arr.size()-1;
            int par = (child-1)/2;

            while(arr.get(child) < arr.get(par)) {  // TC = O(logn) ? => reason = if There is N nodes in a BT then there is LogN parents of BT and in worst case I have to travel all the Parent Nodes
                int temp = arr.get(child);       //for max heap while(arr.get(child) > arr.get(par))
                arr.set(child, arr.get(par));
                arr.set(par, temp);
                child = par;
                par = (child-1)/2;
            }
        }

        public int peek() {  //peek an element
            return arr.get(0);
        }


        //Heapify function fix heaps correctly
        private void heapify(int i) {
            int left = 2*i + 1; //left child
            int right = 2*i + 2; //right child
            int minIdx = i; //for max heap int maxIdx = i

            if(left < arr.size() && arr.get(minIdx) > left) { //for max heap if(left < arr.size() && arr.get(minIdx) < left)
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > right) { //for max heap if(right < arr.size() && arr.get(minIdx) < right)
                minIdx = right;
            }

            if(minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx); //again call to fix heap correctly
            }
        }

        //Delete from heap  O(log N) ...........................
        public int remove() {
            int data = arr.get(0);

            //step 1 = Swap 1st and last Node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 = delete last
            arr.remove(arr.size()-1);

            //step 3 = heapify (fix heap)
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main(String args[]) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        System.out.print("This is my MinHeap : ");
        while(!pq.isEmpty()) { //Heapsort --> O(nlogn)
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}