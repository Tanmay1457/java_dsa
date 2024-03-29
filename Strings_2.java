
public class Strings_2 {

//Check if a String is a Palindrome............................................................................


    public static boolean ispalindrome ( String str) {
        for (int i=0; i<str.length()/2; i++){
            int n = str.length();
            if (str.charAt(i) != str.charAt(n-1-i)){
                //Not a Palindrome
                return false;
            }
        }
        return true;
    }

// Shortest Path Question......................................................................................

    public static float getShortestPath(String path){
        int x=0 , y=0;
        for (int i=0; i<path.length(); i++){
            char direc = path.charAt(i);
            //South...............
            if (direc == 'S'){
                y--;
            }
            //North...............
            else if (direc == 'N') {
                y++;
            }
            //West...............
            else if (direc == 'W') {
                x--;
            }
            //East...............
            else {
                x++;
            }
        }

        int X2 = x*x; //X^2
        int Y2 = y*y; //Y^2

        //Displacement formula..........
        return (float)Math.sqrt(X2 + Y2);
    }

    public static  String substring(String str, int SI, int EI){
        String subStr = "";
        for (int i= SI; i<EI; i++){
            subStr += str.charAt(i);
        }
        return  subStr;
    }

    public static String toUppercase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0)); // 0th index character processed
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if (str.charAt(i) == ' ' && i<str.length()-1){ // if blank space available then
               sb.append(str.charAt(i));//store space as it is
               i++;
               sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i)); // copy as it is
            }
        }
       return sb.toString();
    }

    public static String Compress(String str){
        String newStr = "";

        for (int i=0; i<str.length(); i++){
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count>1){
                newStr += count.toString();
            }
        }
        return newStr; //Compressed string
    }


public static void main(String[] args) {
        //String str = "racecar";
        //System.out.println(ispalindrome(str));

        //String path = "WNEENESENNN";
        //System.out.println(getShortestPath(path ));

//String Comparison..............................................................................

     /*
     String s1 = "Tony";
     String s2 = "Tony";
     String s3 = new String("Tony");

     if(s1 == s2){
         System.out.println("Equal");
     }else {
         System.out.println("Not Equal");
     }

        if(s1 == s3){ //It result not equal due to its Intening effect
            System.out.println("Equal");
        }else {
            System.out.println("Not Equal");
        }
 //solution :-
        if(s1.equals(s3)){
            System.out.println("Equal");
        }else {
            System.out.println("Not Equal");
        }*/

//Substring Function.............................................................................

        //String str = "HelloWorld";
       //System.out.println(substring(str,0,5));

        //Inbulit substring Function.................
        //System.out.println(str.substring(0,5));

//Print Largest String.............................................................................
        /*
        String fruits[] = {"apple","mango","banana"};

        String Largest = fruits[0];
        for (int i=1; i<fruits.length; i++){
            if (Largest.compareTo(fruits[i])<0){
                Largest = fruits[i];//assign to largest
            }
        }
    System.out.println(Largest);
    */

//String Bulider...................................................................................
       /*
       StringBuilder sb = new StringBuilder("");
       for(char ch='a'; ch<='z'; ch ++){
            sb.append(ch);//Append Character at last  Time Complexity O(26)
          }
       System.out.println(sb.length());

        */

//Convert First Letter to Uppercase....................................................................
       /*
       String str = "hi, i am tanmay";
       System.out.println(toUppercase(str));
       */

//String Compression...................................................................................

       String str = "aaabbcccdd";
       System.out.println(Compress(str));
    }

}
