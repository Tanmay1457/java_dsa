
//Binary To Decimal....................................................................................................

/* 
public class NumberSystem {
    public static void main(String[] args) {
        BtoD(101);
    }

    public static void BtoD(int BinNo){
        int myNum = BinNo;
        int pow = 0;
        int decNo = 0;

        while(BinNo > 0){
            int lastDigit = BinNo % 10;//.....................😎

            decNo = decNo + (lastDigit* (int)Math.pow(2, pow));//typecast

            pow++;
            BinNo = BinNo/10;//.......................😎
        }

        System.out.println("decimal of "+ myNum +" = "+decNo);

    }
} */


// Decimal To Binary....................................................................................................

/* 
public class NumberSystem {
    public static void main(String[] args) {
        DtoB(7);
    }

    public static void DtoB(int n){
        int myNum=n;
        int pow = 0;
        int BinNo = 0;

        while(n>0){

            int rem= n % 2;//remainder.................😎

            BinNo = BinNo + (rem * (int)Math.pow(10, pow));

            pow++;
            n=n/2;//divide.......................😎

        }
        System.out.println("Binary of"+ myNum + " = "+BinNo );
    }
} */