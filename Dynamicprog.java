import java.util.*;

//fibonacci code..........................................................
//fib Code by DP -> TC -> 0(n) from 0(2^n)
//public class Dynamicprog {
//
//    //By recursion -> TC -> 0(n)
//    //Top Down Approach
//    public static int fibMemoization(int n, int dp[]) {
//        //Base Case
//        if(n == 0 || n == 1) {
//            return n;
//        }
//        if(dp[n] != 0) {
//            return dp[n];
//        }
//        dp[n] = fibMemoization(n-1, dp) + fibMemoization(n-2, dp);
//        return dp[n];
//    }
//
//    //By Iteration -> TC -> 0(n)
//    //Bottom Up Approach
//    public static int fibTabulation(int n) {
//        int dp[] = new int[n+1];
//        dp[1] = 1;
//        for(int i=2; i<=n; i++) {
//            dp[i] =  dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }
//
//    public static void main(String args[]) {
//        int n = 5;
//        int dp[] = new int[n+1];
//        //System.out.println(fibMemoization(n, dp));
//        System.out.println(fibTabulation(n));
//    }
//}


//Climbing stairs climb 1 stair or 2 stair................................................................

//public class Dynamicprog {
//
//    //Simple recursion -> 0(2^n)
//    public static int climbingWays(int n) {
//        //Base Case
//        if(n == 0) {
//            return 1;
//        }
//        if(n < 0) {
//            return 0;
//        }
//        return climbingWays(n-1)  + climbingWays(n-2);
//    }
//
//    //Recursion + dp -> Memoization -> 0(n)
//    public static int climbingWaysMemoization(int n, int dp[]) {
//        if(n == 0) {
//            return 1;
//        }
//        if(n < 0) {
//            return 0;
//        }
//
//        if(dp[n] != -1) {
//            return dp[n];
//        }
//
//        dp[n] = climbingWaysMemoization(n-1, dp) + climbingWaysMemoization(n-2, dp);
//        return dp[n];
//    }
//
//    //Recusion + dp -> Tabulation -> 0(n)
//    public static int climbingWaysTabulation(int n) {
//        int dp[] = new int[n+1];
//        dp[0] = 1;
//
//        if(dp[n] != 0) {
//            return dp[n];
//        }
//        for(int i=1; i<=n; i++) {
//            if(i == 1) {
//                dp[i] = dp[i-1] + 0;
//            }
//            else {
//                dp[i] = dp[i-1] + dp[i-2];
//            }
//        }
//        return dp[n];
//    }
//    public static void main(String args[]) {
//        int n = 5;
//        System.out.println("Simple recursion -> 0(2^n) ="+climbingWays(n));
//        int dp[] = new int[n+1];
//        Arrays.fill(dp, -1);
//        System.out.println("Recursion + dp -> Memoization -> 0(n) ="+climbingWaysMemoization(n, dp));
//        System.out.println("Recusion + dp -> Tabulation -> 0(n) ="+climbingWaysTabulation(5));
//    }
//}

//0-1 Knapsack.................................................................

//public class Dynamicprog {
//
//    //By Recursion -> TC = 0(2^n)....................
//    public static int knapSack(int val[], int wt[], int W, int n) {
//        //Base Case
//        if(W == 0 || n == 0) {
//            return 0;
//        }
//        //Valid Condition
//        if(wt[n-1] <= W) {
//            //Include Choice
//            int ans1 = val[n-1]+knapSack(val, wt, W-wt[n-1], n-1);
//            //Exclude Choice
//            int ans2 = knapSack(val, wt, W, n-1);
//            return Math.max(ans1, ans2);
//        }
//
//        //Invalid Condition
//        else {  //exclude choice
//            return knapSack(val, wt, W, n-1);
//        }
//    }
//
//
//    //By Memoization -> TC = 0(n*W)............................
//    public static int knapSackMemoization(int val[], int wt[], int W, int n, int dp[][]) {
//        //Base Case
//        if(W == 0 || n == 0) {
//            return 0;
//        }
//        if(dp[n][W] != -1) {
//            return dp[n][W];
//        }
//        //Valid Condition
//        if(wt[n-1] <= W) {
//            //Include Choice
//            int ans1 = val[n-1]+knapSackMemoization(val, wt, W-wt[n-1], n-1, dp);
//            //Exclude Choice
//            int ans2 = knapSackMemoization(val, wt, W, n-1, dp);
//            dp[n][W] = Math.max(ans1, ans2);
//            return dp[n][W];
//        }
//
//        //Invalid Condition
//        else {  //exclude choice
//            dp[n][W] = knapSack(val, wt, W, n-1);
//            return dp[n][W];
//        }
//    }
//
//
//    //By  Tabulation -> TC = 0(n*W)......................................
//    public static int knapSackTabulation(int val[], int wt[], int W) {
//        int n = val.length;
//        int dp[][] = new int[n+1][W+1];
//        //initialization
//        for(int i=0; i<dp.length; i++) { //0th col initialization
//            dp[i][0] = 0;
//        }
//        for(int j=0; j<dp[0].length; j++) { //0th row initialization
//            dp[0][j] = 0;
//        }
//         //tabulation loop
//        for(int i=1; i<n+1; i++) {
//            for(int j=1; j<W+1; j++) {
//                int v = val[i-1]; //ith item value
//                int w = wt[i-1]; //ith item weight
//                //Valid Condition
//                if(w <= j) {
//                    int incProfit = v + dp[i-1][j-w]; //Include profit
//                    int excProfit = dp[i-1][j]; //exclude profit
//                    dp[i][j] = Math.max(incProfit, excProfit);
//                }
//                else { //invalid
//                    int excProfit = dp[i-1][j];
//                    dp[i][j] = excProfit;
//                }
//            }
//        }
//        //printing dp matrix
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        return dp[n][W];
//    }
//
//    public static void main(String args[]) {
//        int values[] = {15, 14, 10, 45, 30};
//        int weight[] = {2, 5, 1, 3, 4};
//        int W = 7;
//
//        int dp[][] = new int[values.length+1][W+1];
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                dp[i][j] = -1;
//            }
//        }
//        System.out.println("By Recursion -> TC = 0(2^n) = "+knapSack(values, weight, W, values.length));
//        System.out.println("By Memoization -> TC = 0(n*W) = "+knapSackMemoization(values, weight, W, values.length, dp));
//        System.out.println("By  Tabulation -> TC = 0(n*W) = "+knapSackTabulation(values, weight, W));
//    }
//}


//Target sum Subset.............................................................

//public class Dynamicprog {
//
//    //TC = 0(n*sum)
//    public static boolean targetSumSubset(int arr[], int sum) {
//        int n = arr.length;
//        boolean dp[][] = new boolean[n+1][sum+1];
//        //initialization
//        //here i = items  & j = target sum
//        for(int i=0; i<n+1; i++) {
//            dp[i][0] = true;
//        }
//        for(int i=1; i<n+1; i++) {
//            for(int j=1; j<sum+1; j++) {
//                int v = arr[i-1];
//                //include condition.........
//                if(v <= j && dp[i-1][j-v] == true) {
//                    dp[i][j] = true;
//                }
//                //exclude condition..............
//                else if(dp[i-1][j] == true) {
//                    dp[i][j] = true;
//                }
//            }
//        }
//        //printing dp[][]
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return dp[n][sum];
//    }
//    public static void main(String args[]) {
//        int arr[] = {4, 2, 7, 1, 3};
//        int sum = 10;
//        System.out.println("targetSumSubset = "+targetSumSubset(arr, sum));
//    }
//}


//Unbounded knapsack O(n*w)...........................................................

//public class Dynamicprog {
//
//    public static int unboundedKnapSack(int val[], int wt[], int W) {
//        int n = val.length;
//        int dp[][] = new int[n+1][W+1];
//
//        for(int i=1; i<n+1; i++) {
//            for(int j=1; j<W+1; j++) {
//                //valid
//                int curr = wt[i-1];
//                if(curr <= j) {
//                    //unbounded knapsack ans=100 (45+45(2 time include) + 10 = 100)
//                    dp[i][j] = Math.max(val[i-1] + dp[i][j-curr], dp[i-1][j]); //for bounded dp[i][j] = Math.max(val[i-1] + dp[i-1][j-curr], dp[i-1][j]); ans = 75
//                }
//                //invalid + Exclude
//                else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        //printing dp[][]
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return dp[n][W];
//    }
//
//    public static void main(String args[]) {
//        int val[] = {15, 14, 10, 45, 30};
//        int wt[] = {2, 5, 1, 3, 4};
//        int W = 7;
//        System.out.println(unboundedKnapSack(val, wt, W));
//    }
//}


//Rod Cutting....................................................................

//public class Dynamicprog {
//
//    public static int rodCutting(int length[], int prices[], int totRodLen) {
//        int n = prices.length;  //or I can take length.length also as length is the same for both of the arrays
//        int dp[][] = new int[n+1][totRodLen+1];
//        //initialization -> as java initialize array elms val already with 0 yet we need to clear the initialization
//        //in our mind (Even though we do not need to do this)
//        for(int i=0; i<n+1; i++) {
//            for(int j=0; j<totRodLen+1; j++) {
//                if(i == 0 || j == 0) {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//
//        for(int i=1; i<n+1; i++) {
//            for(int j=1; j<totRodLen+1; j++) {
//                //valid
//                if(length[i-1] <= j) {
//                    //unbounded knapsack code
//                    dp[i][j] = Math.max(prices[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
//                }
//                else //invalid - totally Exclude
//                    dp[i][j] = dp[i-1][j];
//            }
//        }
//        //printing dp[][]
//        for(int i=0; i<dp.length; i++) {
//            for(int j=0; j<dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        return dp[n][totRodLen];
//    }
//    public static void main(String args[]) {
//        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
//        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
//        int rodLength = 8;
//        System.out.println("Maximum Value = "+rodCutting(length, prices, rodLength));
//    }
//}


//Longest common subsequence O(n*m)...................................................

public class Dynamicprog {

    // By Simple recursion
    public static int lcs(String s1, String s2, int n, int m) {
        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }
        // Same
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            // +1 is for the current same ans
            return lcs(s1, s2, n - 1, m - 1) + 1;
        } else {
            int ans1 = lcs(s1, s2, n - 1, m);
            int ans2 = lcs(s1, s2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }


    // By DP or Memoization
    public static int lcsDP(String str1, String str2, int n, int m) {
        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }
        // Creating dp[][] to store overlapping subproblems
        int dp[][] = new int[n + 1][m + 1];
        // initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        // Check if solution is already calculated or not in dp[][]
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            // storing dp ans before returning it
            return dp[n][m] = lcsDP(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = lcsDP(str1, str2, n - 1, m);
            int ans2 = lcsDP(str1, str2, n, m - 1);
            // Storing dp ans before returning it
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    // By Tabulation
    public static int lcsTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String args[]) {
        String str1 = "abcdefg";
        String str2 = "abeg";
        System.out.println("By Simple Recursion: " + lcs(str1, str2, str1.length(), str2.length()));
        System.out.println("By DP or Memoization: " + lcsDP(str1, str2, str1.length(), str2.length()));
        System.out.println("By Tabulation: " + lcsTab(str1, str2));
    }
}
