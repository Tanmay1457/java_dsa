import java.util.*;

//Edit distance.....................................................
public class Dynamicprog_2 {
    //TC = 0(n*m)
    public static int minOperationsToChangeStr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        //initialization
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<m+1; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }
                if(j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                //same = nothing to do , find for rest of the length
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    //diff = 3 choices, add, delete, replace
                    //choice 1 = add
                    // int add = dp[i][j-1] + 1;
                    // //choice 2 = del
                    // int del = dp[i-1][j] + 1;
                    // //choice 3 = replace
                    // int rep = dp[i-1][j-1] + 1;
                    // dp[i][j] = Math.min(add, Math.min(del, rep));

                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        //dp[][]
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][m];
    }
    public static void main(String args[]) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(minOperationsToChangeStr(str1, str2));
    }
}