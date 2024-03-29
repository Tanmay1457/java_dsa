import java.util.*; //package for importing input class

public class input {
    
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);     // class for input  sc= object of class
    
//.................................................................................................

    /* String input = sc.next(); //object sc capture input with help of "next" function 
       System.out.println(input);// next function capture till space "tony stark" stark not printed */ 

       //.................................................................................................
       
    /* String name = sc.nextLine();     //for printing long sentence
       System.out.println(name); */

       //.................................................................................................

    /* int number = sc.nextInt(); // for printing number
       System.out.println(number); */

       //..................................................................................................

    /*   float price = sc.nextFloat(); // for decimal number
       System.out.println(price); */ 

       //...................................................................................................

    /* boolean var = sc.nextBoolean(); // for boolean value 
       System.out.println(var); */

       //...................................................................................................


      

       //int a = sc.nextInt();
       //int b = sc.nextInt();
       //....................................
    /* For sum of two variable a and b */

       //int sum = a + b;
       //System.out.println(sum);

       //...................................

    /* For product of two variable a and b */

      //int product = a * b;
      //System.out.println(product);

//......................................................................................................

    /* implicit or widening or type conversion in java */

    //float number = sc.nextInt();
    //System.out.println(number);

/*  int number = sc.nextFloat();  // it will give error
    System.out.println(number); */

//......................................................................................................

    /* Type casting or narrowing conversion or explicit conversion  */


  /*float a = 25.12f;
    int b = a; // it will give lossy conversion error */


 /* float a = 25.12f; // it will remove .12 (i.e no after . decimal)
    int b = (int)a; // here we do typecasting
    System.out.println(b); */

// character to number conversion
    
/*  char ch = 'a';
    int number = ch;
    System.out.println(number);   // it wil give 97(ASCII value of a)  */


//........................................................................................................

  /* Type Promotion(only done for expression) */

//...........................
  /* char a = 'a';
     char b = 'b';
     System.out.println((int)(a)); // type cast to integer
     System.out.println((int)(b)); // type cast to integer
     System.out.println(b-a); */
//............................
   /*short a = 5;
     byte b = 25;
     char c = 'c';
   //byte bt = a + b + c; // error occur it consider RHS is integer
     byte bt = (byte)(a + b + c);
     System.out.println(bt); //we got any random answer that has no meaning */
//.............................
 /* int a = 10;
    float b = 20.25f;
    long c = 25;
    double d = 30;
    double ans = a + b + c + d; //all value converted into double value (ans = 85.25)
    System.out.println(ans); */
    
//..............................

/*   byte b = 5;
   //byte a = b * 2; //Error will occur we convert small value to large value

     byte a = (byte)(b*2); // we need to Type cast
     System.out.println(a);  */
    } 
}
