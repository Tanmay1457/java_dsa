import java.util.*;

//public class Heap_2 {
//
//    //Heapsort.............................................................
//    public static void heapify(int arr[], int i, int size) {
//        int left = 2*i+1;
//        int right = 2*i+2;
//        int maxIdx = i;
//        if(left < size && arr[maxIdx] < arr[left]) { //descending arr[maxIdx] > arr[left]
//            maxIdx = left;
//        }
//
//        if(right < size && arr[maxIdx] < arr[right]) { //descending arr[maxIdx] > arr[right]
//            maxIdx = right;
//        }
//
//        if(maxIdx != i) {
//            //swap
//            int temp = arr[maxIdx];
//            arr[maxIdx] = arr[i];
//            arr[i] = temp;
//            heapify(arr, maxIdx, size);
//        }
//    }
//
//    public static void heapSort(int arr[]) { //O(n*logn)
//        //step 1 = to create MaxHeap
//        int n = arr.length;
//        for(int i=n/2; i>=0; i--) {
//            heapify(arr, i, n);
//        }
//
//        //step 2 = sorting
//        for(int i=n-1; i>=0; i--) {
//            //swap (largest(first) with last)
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//            heapify(arr, 0, i);
//        }
//
//    }
//    public static void main(String args[]) {
//        int arr[] = {4,2,6,7,9};
//        heapSort(arr);
//
//        for(int i=0; i<arr.length; i++) {
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//    }
//}


//Nearby cars........................................................



//public class Heap_2 {
//
//    public static class Point implements Comparable<Point>{ //implementing comparable interface
//        int x;
//        int y;
//        int disSq;
//        int idx;
//        public Point(int x, int y, int disSq, int idx) {
//            this.x = x;
//            this.y =  y;
//            this.disSq = disSq;
//            this.idx = idx;
//        }
//
//        @Override
//        public int compareTo(Point p2) {
//            return this.disSq - p2.disSq; //on basis of distance ascending order
//        }
//    }
//    public static void main(String args[]) {
//        int points[][] = {{3,3}, {5,-1}, {-2,4}};
//        int k = 2;
//        PriorityQueue<Point> pq = new PriorityQueue<>();
//        for(int i=0; i<points.length; i++) {
//            int disSq = points[i][0]*points[i][0] + points[i][1]*points[i][1]; //x^2 + y^2
//            pq.add(new Point(points[i][0], points[i][1], disSq, i));
//        }
//
//        //nearest K Cars
//        for(int i=0; i<k; i++) {
//            System.out.println("C" +pq.remove().idx+" ");
//        }
//    }
//}


//Connecting N ropes...................

//

//Weakest solider.....................................................


//


//Sliding window maximum  O(nlogk)..........................................

public class Heap_2{

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            //descending Order Sorting
            return p2.val - this.val; //large value come first
            //ascending order sorting
            //return this.val - p2.val;
        }
    }
    public static void main(String args[]) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int ans[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st window
        for(int i=0; i<k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        //1st window result
        ans[0] = pq.peek().val;

        for(int i=k;i<arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) { //remove element previous in window
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            ans[i-k+1] = pq.peek().val;
        }

        //printing of the ans
        for(int i=0; i<ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}