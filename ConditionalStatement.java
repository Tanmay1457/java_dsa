import java.util.*;

public class ConditionalStatement {
    public static void main(String[] args) {
        //int age = 16;

//If-Else Statement......................................................................
        
     /* if(age>=18){
            System.out.println("Adult");// 1st execute this
        }

        if(age > 13 && age <18) {
            System.out.println("teeneger");// 2nd execute this
        }

        else{
            System.out.println("not adult");//Otherwise execute this
        }  */


//Else-If Statement......................................................................

     /* if(age>=18){
            System.out.println("Adult");// 1st execute this if condition true and remaining statement ignore
        }

        else if(age > 13 && age <18) {
            System.out.println("teeneger");// 2nd execute this if 1st statement false
        }

        else{
            System.out.println("not adult");//Otherwise execute this
        }  */  
        

//Ternary Operator........................................................................

     /* int number = (5>3)?10:4; //If true 10 print otherwise 4 will print
        System.out.println(number); */


//Switch Statement........................................................................
        
     /* int number = 2;
        switch(number){
            case 1 : System.out.println("samosa");
                     break; 
            case 2 : System.out.println("burger");//All statement below this executed  
                     break; //so we use break keyword
            default : System.out.println("ok bye ");
                     break;
        }  */


//Calculator using switch statement ......................................................


    /*   Scanner sc = new Scanner(System.in);
         System.out.println("Enter a :");
         int a = sc.nextInt();
         System.out.println("Enter b :");
         int b = sc.nextInt();
         System.out.println("Enter operator");
         char operator = sc.next().charAt(0);//for taking single character 

         switch(operator){
            case '+' : System.out.println("Result\t" + a+b);
                 break;
            case '-' : System.out.println( "Result\t" + (a-b));
                 break;
            case '*' : System.out.println("Result\t" + a*b);
                 break;
            case '/' : System.out.println("Result\t" + a/b);
                 break;
            case '%' : System.out.println("Result\t" + a%b);
                 break;
            default : System.out.println("wrong choice");
            
         } */

    }
    
}
