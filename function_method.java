import java.util.*;

//Introduction to function/method.........................................................................

/* 
public class function_method {

    public static void main(String[] args) {//main function...............

        printhello(); //We call to the function......

    }

//Function for printing hello........... 

    public static void printhello(){   //This is method of class "function_method"
        System.out.println("hello");
        System.out.println("hello"); 
    }
} */


//Function with parameter..................................................................................

/*
public class function_method {

    public static void main(String[] args) {//main function...............
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt() ;
        int b = sc.nextInt(); 
        sum(a,b);//function call with passing value(arguments or actual parameter)
    
    }

    public static void sum(int a, int b){//sum function with ip parameter(parameter or formal parameter)
        int sum = a+b;
        System.out.println("sum is :" + sum);
    }

} */


//Call By value............................................................................................

/* 
public class function_method {

    public static void main(String[] args) {//main function...............
       
        int a = 5;
        int b = 10; 
        Swap(a, b); //Call by value(All function in java use call by value)

     //We want o/p in main function all changes remain in function it will not reflect in main function (i.e scope)

        System.out.println("a="+a);//op=5
        System.out.println("b="+b);//op=10  
    }

    public static void Swap(int a, int b){
        int temp= a;
        a = b;
        b=temp;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
    
} */


//nCr calculation..........................................................................................

/* 
public class function_method {

    public static void main(String[] args) {//main function...............
        System.out.println(nCrCalculation(5, 2));
       

    }
    public static int factorial(int n){ //factorial function
        int f=1;
        for(int i=1; i<=n; i++){
            f = f * i;
        }
        return f;

    }


    public static int nCrCalculation(int n ,int r ){   
        int fact_n = factorial(n);//n!
        int fact_r = factorial(r);//r!
        int fact_nminusr = factorial(n-r);//(n-r)!
        
        int binCoff = fact_n / (fact_r * fact_nminusr);  
        return binCoff;
        
    }
} */


//Function oveloading using parameter............................................................................

/* 
public class function_method {
    public static void main(String[] args) {
       System.out.println(sum(3, 5)); 
       System.out.println(sum(3, 5,6));
    }

    //function of sum of 2 No
    public static int sum(int a, int b){
        return a+b;
    } 

   //function of sum of 3 No
   public static int sum(int a, int b,int c){
    return a+b+c;
} 

} */

//Function oveloading using datatypes............................................................................

/* 
public class function_method {
    public static void main(String[] args) {
       System.out.println(sum(3, 5)); 
       System.out.println(sum(1.2f,0.5f));//f mandatory remember😁🤦‍♂️
    }

    //function of sum of 2 float No
    public static int sum(int a, int b){
        return a+b;
    } 

   //function of sum of 3 float No
   public static float sum(Float a, float b){
    return a+b;
} 

} */


//prime No.............................................................................................................

/* 
public class function_method {
    public static void main(String[] args) {
       System.out.println(isprime(5)); 
    }
    

    //only for n>=2
    public static boolean isprime(int n){

        //Corner case..............
        //for no = 2
        if(n==2){
           return true; //Below code does not execute  
        }
         
        for(int i=2; i<=n-1; i++){

            if(n%i==0){
                
                return false;
            }

            
        }
        return true;
    }
    

//optimized vesion......................... 

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                
                return false;
            }
    } 
    
    return true;
  }  
}
*/

//for finding prime no 2 to 10 only use if(isprime(i)) and print it
