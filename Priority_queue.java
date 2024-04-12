import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;

//public class Priority_queue {
//    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(); //new PriorityQueue<>(Comparator.reverseOrder())for descending order
//
//        pq.add(3);
//        pq.add(4);
//        pq.add(1);
//        pq.add(7);
//
//        while (!pq.isEmpty()){
//            System.out.println(pq.peek());
//            pq.remove(); //highesht priority remove first
//        }
//    }
//}

public class Priority_queue {

    static class Student implements Comparable<Student> { //interface //overriding
        String name;
        int rank;
        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }

    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>(); //to reverse order Comparator.reverseOrder()
        pq.add(new Student("abc", 13));
        pq.add(new Student("sdf", 8));
        pq.add(new Student("tyu", 5));
        pq.add(new Student("fgr", 72));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}