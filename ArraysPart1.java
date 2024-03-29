import java.util.*;


public class ArraysPart1 {

   
    public static void main(String[] args) {


       //int marks[]= new int[100];

//Input in Array...............................................................................................

    /* 
    
     Scanner sc =new Scanner(System.in);
     marks[0]= sc.nextInt();//mark stored at 0th index
     marks[1]= sc.nextInt();
     marks[2]= sc.nextInt();
     
     System.out.println("physics :" + marks[0]);//output the value
     System.out.println("Chemistry :" + marks[1]);
     System.out.println("Math :" + marks[2]); */

//update the value.............................................................................................
    
    /* 
    marks[2]=100;//Another way is mark[2]=mark[2]+1; i.e all arithmetic operation done
    System.out.println("Math :" + marks[2]);*/

//length of array..............................................................................................

    //System.out.println("length of array: " + marks.length);

//Passing array as argument(i.e reference => changes visible).....................................................................
    int mark[] ={97,98,99};
    update(mark);

    //print updated mark
    for(int i=0; i<mark.length; i++){//Imp array loop.............
        System.out.print(mark[i]+" ");
  }
  System.out.println();
}

    public static void update(int mark[]){
      for(int i=0; i<mark.length; i++){//Imp array loop.............
            mark[i]=mark[i] + 1;
      }  
    }
}


