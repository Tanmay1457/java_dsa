import java.util.*;
public class Strings {
    public static void main(String[] args) {
        char arr[] = {'a','b','c','d'};
        String str = "abcd";
        String str1 = new String("xyz"); //Another Method
        //String Are Immutable

//Input and Output In string.............................................................................
        /*
        Scanner sc = new Scanner(System.in);//Input.......
        String name;
        name = sc.nextLine(); //string are stored (store all word but next() only store single word)

        System.out.println(name); //Output.........
        */

//Sting Length............................................................................................
        /*
        String Fullname = "Tanmay Nigade";//space will be counted
        System.out.println(Fullname.length());
        */
//Concatenation of String..................................................................................

        String fname = "Tanmay";
        String Lname = "Nigade";
        String Fullname = fname + " " + Lname;
        //System.out.println(Fullname);

//Char At function...........................................................................................

        //System.out.println(Fullname.charAt(1)); //Character at index no 1
        //printLetter(Fullname);
    }
    /*
       public static void  printLetter(String str){
            for (int i=0; i<str.length(); i++){
                 System.out.print(str.charAt(i) + " ");
            }
         System.out.println();
        } */


}
