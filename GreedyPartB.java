import java.util.*;


//Indian coins...................................................
//public class GreedyPartB {
//    public static void main(String[] args) {
//
//        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
//
//        Arrays.sort(coins, Comparator.reverseOrder());
//
//        int countOfCoins = 0;
//        int amount = 590;
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        for (int i=0; i<coins.length; i++){
//            if (coins[i] <= amount){
//                while (coins[i] <= amount){
//                    countOfCoins++;
//                    ans.add(coins[i]);
//                    amount -= coins[i];
//                }
//            }
//        }
//        System.out.println("total minimum coins used =" + countOfCoins);
//        for (int i=0; i< ans.size(); i++ ){
//            System.out.print(ans.get(i)+" ");
//        }
//        System.out.println();
//    }
//}

//Job scheduling with deadline.............................................

//public class GreedyPartB {
//    static class job {
//        int deadline;
//        int profit;
//        int id;
//
//        public job(int i, int d, int p) {
//            id = i;  // unique id for each job
//            deadline = d;
//            profit = p;
//        }
//    }
//
//    public static void main(String[] args) {
//        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
//
//        ArrayList<job> jobs = new ArrayList<>();
//
//        for (int i = 0; i < jobsInfo.length; i++) {
//            jobs.add(new job(i, jobsInfo[i][0], jobsInfo[i][1]));
//        }
//
//        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); //descending order of profit for ascending(obj1.profit- obj2.profit)
//
//        ArrayList<Integer> seq = new ArrayList<>();
//        int time = 0;
//        for (int i = 0; i < jobs.size(); i++) {
//            job curr = jobs.get(i);
//            if (curr.deadline > time) {
//                seq.add(curr.id);
//                time++;
//            }
//        }
//
//        // print sequence
//        System.out.println("max jobs = " + seq.size());
//        for (int i = 0; i < seq.size(); i++) {
//            System.out.print(seq.get(i) + " ");
//        }
//        System.out.println();
//    }
//}


//Chocola Problem..............................................

public class GreedyPartB {
    public static void main(String[] args) {
        int n = 4 , m = 6; //rows and columns

        Integer costVer[]= {2,1,3,1,4}; //m-1
        Integer costHor[]= {4,1,2}; //n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0; //cuts
        int hp =1, vp = 1; //pieces
        int cost = 0;

        while (h < costHor.length && v<costVer.length){
            if (costVer[v] <= costHor[h]){ //horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }
            else {
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }
        //remaining cuts
        while (h < costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }
        while (v < costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Min cost of cuts =" + cost);


    }
}