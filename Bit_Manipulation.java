public class Bit_Manipulation {

    public static void OddorEven(int n){
        int Bitmask = 1;
        if((n & Bitmask)==0){
            System.out.println("Even No");
        }else {
            System.out.println("Odd No");
        }
    }

    public static  int getIthBit(int n, int i){
        int Bitmask = 1<<i;
        if((n & Bitmask) ==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static  int SetithBit(int n, int i){
        int Bitmask = 1<<i;

        return n | Bitmask;
    }

    public static  int ClearithBit(int n, int i){
        int Bitmask = ~(1<<i);

        return n & Bitmask;
    }

    public static int UpdateithBit(int n, int i, int newBit){
        /*
        if(newBit == 0){
            return ClearithBit(n,i);
        }else{
            return SetithBit(n,i);
        }*/
        //2nd approach
        n = ClearithBit(n,i);
        int BitMask = newBit<<i;
        return n | BitMask;
    }

    public static int ClearIthPOS_Bit(int n, int i){
       int bitmask = (-1)<<i;
       return n & bitmask;
    }

    public static int clearIthRangeBit(int n, int i, int j){
       int a = (~0)<<(j+1);
       int b = (1<<i)-1;
       int bitmask = a | b;
       return n & bitmask;
    }

    public static boolean isPowerofTwo(int n){
        return (n&(n-1)) == 0;
    }

    public static  int CountsetBits(int n){
        int count = 0;
        while (n>0){
            if ((n & 1) !=0){  //Check LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExponention(int a, int n){
        int ans = 1;

        while (n>0){
            if((n & 1) != 0){
                ans = ans * a;

            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    /* Iterative Function to calculate (x^y) in O(log y) */
    static int ModularExponention(int x, int y, int p)
    {
        int res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args) {
//AND Operator.............................................................................
        System.out.println((5 & 6));

//OR Operator.............................................................................
        System.out.println((5 | 6));

//XOR Operator.............................................................................
        System.out.println((5 ^ 6));

//Binary 1's Complement.............................................................................
        System.out.println((~5));

//Binary Left Shift.............................................................................
        System.out.println((5<<2));

//Binary Right Shift.............................................................................
        System.out.println((6>>1));

//Check no odd or even............................................................................
        OddorEven(3);
        OddorEven(4);

//Get ith Bit.....................................................................................
        System.out.println(getIthBit(10,3));

//Get ith Bit.....................................................................................
        System.out.println(SetithBit(10,2));

//Clear ith Bit.....................................................................................
        System.out.println(ClearithBit(10,1));

//update ith Bit.....................................................................................
        System.out.println(UpdateithBit(10,2,1));

//Clear Last ith Bit..................................................................................
        System.out.println(ClearIthPOS_Bit(15,2));

//Clear Range Bit..................................................................................
        System.out.println(clearIthRangeBit(10,2,4));

//Check no is power of two..................................................................................
        System.out.println(isPowerofTwo(7));

//Count Set bit in Number..................................................................................
        System.out.println(CountsetBits(10));

//Fast Exponention..................................................................................
        System.out.println(fastExponention(3,5));

//Modular Exponention................................................................................
        int x = 2;
        int y = 5;
        int p = 13;
        System.out.print("Power is " + ModularExponention(x, y, p));
    }
}
