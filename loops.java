import java.util.*;

public class loops {
    public static void main(String[] args) {
        

//While loop....................................................................................

/*      int counter = 0;
        while(counter<10){
            System.out.println("hi");
            counter++; //Increment every time
           }
        System.out.println("10 time print"); 

//while(true)===> it goes in infinite loop

*/ 


//For loop.....................................................................................

    /*     for(int i=1; i<=10; i++){

            System.out.println("hello");

        }  */


//print SQUARE Pattern.........................................................................

    /*     for(int line=1; line<=4; line++){
             
            System.out.println("* * * * ");

           }  */


//print reverse of the number..................................................................
        
    /*  int n = 10899;

        while(n > 0){
            int lastdigit = n % 10;
            System.out.print(lastdigit);
            n = n / 10; // for removing last digit
        }
        System.out.println(); */ 


//Do While loop................................................................................

    /*  int counter = 1;
        do{
            System.out.println("hi");
            counter++;
        }while(counter <= 10); */ 


//Break Statement..............................................................................

    /*    for(int i=1; i<=5; i++){
            if(i == 3){
                break; //After 3 it go out of loop
            }
            System.out.println(i); 
        }

        System.out.println("out of loop"); */ 


//Continue Statement............................................................................
         
    /*      for(int i=1; i<=5; i++){
            if(i == 3){
                continue; //it will skip only 3 after that it continue its execution
            }
            System.out.println(i); 
        } */


//Prime Number..................................................................................

/* 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n == 2){
        System.out.println("n is prime");
    }else{
    boolean isPrime = true;
    for(int i=2; i<=n-1; i++){ // here we do optimization in for(int i=2; i<=Math.sqrt(n); i++)
        if(n % i == 0){
            isPrime = false; // n is a multiple of i(i.e i not equal to 1 or n) it is composite no
        }

    }
    if(isPrime == true){
        System.out.println("n is Prime");
    } else{
        System.out.println("n is not prime");
    }
  } */
}
    
}
