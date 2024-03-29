public class Recursion {

    public static void printDec(int n){
        if (n == 1){ //Base case
            System.out.println(n);
            return;
        }
        System.out.println(n+" ");
        printDec(n-1); //Call
    }

    public static void printInc(int n){
        if (n == 1){ //Base case
            System.out.println(n+" ");
            return;
        }
        printInc(n-1); //call
        System.out.println(n+" ");
    }

    public static int fact(int n){
        if (n== 0){
            return 1;
        }
        //int fn_minus_1 = fact(n-1);
        int fn = n* fact(n-1);
        return fn;

    }

    public static int calcSum(int n){
        if (n == 1){
            return 1;
        }
        int Sn_m1 = calcSum(n-1);
        int Sn = n + Sn_m1;
        return Sn;
    }

    public static int fib(int n){
        if (n == 0 || n ==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[],int i){
        if (i == arr.length -1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccurance(int arr[], int key,int i){
        if (i == arr.length){
            return -1;
        }
        if (arr[i] == key){
            return i;
        }
        return firstOccurance(arr,key,i+1);
    }

    public static int lastOccurance(int arr[], int key,int i){
        if (i == arr.length){
            return -1;
        }
        int isFound = lastOccurance(arr,key,i+1);
        if (isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n){
        if (n==0){
            return 1;
        }
//        int xnm1 = power(x,n-1);
//        int xn = x* xnm1;
//        return xn;
        return x * power(x,n-1);
    }

    public static int optimizedpower(int a,int n1){
        if (n1 == 0){
            return 1;
        }

        //o(n).........
        //int halfPower = optimizedpower(a,n1/2) * optimizedpower(a,n1/2);
        //solution
        int half =  optimizedpower(a,n1/2);
        int halfPower = half * half; //  O(log(n)).........

        //n odd
        if (n1%2 != 0){
            halfPower= a*halfPower;
        }
        return halfPower;
    }

    public static int tillingproblem(int n){ // 2 x n (floor size)
        if (n == 0 || n == 1){
            return 1;
        }
        //vertical choice
        int vert = tillingproblem(n-1); //remaing (n-1) ways after placing one tile

        //Horizontal choice
        int horz = tillingproblem(n-2);

        int totWays = vert + horz;
        return totWays;
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            //if duplicate
            removeDuplicate(str, idx + 1, newStr, map);
        } else {
            map[currChar -'a'] =  true;
            removeDuplicate(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static int friendsParing(int n){
        if (n == 1 || n == 2){
            return n;
        }
//        //choice - single
//        int fnm1 = friendsParing(n-1);
//
//        //choice - pair
//        int fnm2 = friendsParing(n-2);
//        int pairways = (n-1) * fnm2;
//
//        //tot ways
//        int totways = fnm1 + pairways;
//        return totways;

        //optimize way...........................
        return friendsParing(n-1) + (n-1)* friendsParing(n-2);
    }

    public static void PrintBinStrings(int n, int lastplace, String str){
        //Base case
        if (n == 0){
            System.out.println(str);
            return;
        }

        //work
//        if (lastplace == 0){//sit 0 on chair n
//
//            PrintBinStrings(n-1,0,str.append("0"));
//            PrintBinStrings(n-1,1,str.append("1"));
//        }else { //sit 1 on chair n
//            PrintBinStrings(n-1,0,str.append("0"));
//        }
        PrintBinStrings(n-1,0,str+"0");
        if (lastplace == 0){//sit 0 on chair n
            PrintBinStrings(n-1,1,str+"1");
        }
    }



    public static void main(String[] args) {

//Print No from n to 1..................................................................
        int n = 5;
        printDec(n);

//Print No from 1 to n..................................................................
        printInc(n);

//Print factorial of n...................................................................
        fact(n);
        System.out.println(fact(n));

//Print sum of natural No.................................................................
        System.out.println(calcSum(n));

//Fibonacci of no .........................................................................
        System.out.println(fib(n)); //here we consider nth term

//Check array is sorted or not...............................................................
        //int arr[] = {1,2,3,5,4};
        //System.out.println(isSorted(arr,0));

//First occurance ...........................................................................
        int arr[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(firstOccurance(arr,5,0));

//Last occurance............................................................................
        System.out.println(lastOccurance(arr,5,0));

//power of x^n...................................................................................
        System.out.println(power(2,10));

//Optimized [log(n)] power of x^n...................................................................................
        int a =2;
        int n1 = 5;
        System.out.println(optimizedpower(a,n1));

//Tilling problem......................................................................................
        System.out.println(tillingproblem(4));

//Remove Duplicate in string ..........................................................................
        String str = "appnnacollege";
        removeDuplicate(str,0,new StringBuilder(""),new boolean[26]);

//friend Pairing ..........................................................................................
        System.out.println(friendsParing(3));

//Binary string with no consecutative one's.................................................................
        PrintBinStrings(3,0,"");

    }
}
