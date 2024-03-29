public class AdvancePattern2  {
    
//Hollow Rectangle.............................................................................................................
    /* 
    public static void hollow_rectangle(int totRows, int totCols){//Total column and row
        //outer loop 
        for(int i=1; i<=totRows; i++){
           //inner loop columns
           for(int j=1; j<=totCols; j++){
              //cell - (i,j)
              if(i==1 || i== totRows || j==1 || j==totCols){//if any condition true print star
                //if boundary cell then print star
                System.out.print("*");
              } else{
                System.out.print(" ");//empty space
              }
           }
           System.out.println();//By traversing all column
        } */


//Inverted and rotated pyramid.................................................................................................
    /* 
    public static void Inverted_pyramid(int n){//No of levels or line
        //outer loop
        for(int i=1; i<=n; i++){

           //To print spaces
           for(int j=1; j<=n-i; j++){
            System.out.print(" ");//to print spaces in same line 
           }

           //To print Star
           for(int j=1; j<=i; j++){//print star equal to i
            System.out.print("*");
           }
           System.out.println();
        }
    } */


//Inverted and rotated pyramid with No...........................................................................................
    /* 
    public static void Inverted_NoPyramid(int n){
        //outer loop
        for(int i=1; i<=n; i++){

            //inner loop for no
            for(int j=1; j<=n-i+1; j++){
              System.out.print(j+" ");  
            }
            System.out.println();
        }

    } */


//Floyd Triangle...................................................................................................................
    /* 
    public static void Floyd_Triangle(int n){
        int counter = 1;
        for(int i=1; i<=n; i++){
            //How many time counter will print
            for(int j=1; j<=i; j++){
                System.out.print(counter + " ");
                counter++;//To store next value
            }
            System.out.println();
        }

    } */


//0-1 Triangle....................................................................................................................
    /* 
    public static void zero_one_triangle(int n){

        for(int i=1; i<=n; i++){

            for(int j=1; j<=i; j++){

                if((i+j)%2==0){//If even print => 1
                    System.out.print(" 1 ");
                } else{
                    System.out.print(" 0 ");// If odd print => 0
                }
            }
            System.out.println();
        }

    } */


//Butterfly🦋Pattern..............................................................................................................
    /* 
    public static void butterfly_Pattern(int n){
        //1st half..................................
        for(int i=1; i<=n; i++ ){

            //star = i.........
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            //spaces = 2*(n-i)........
            for(int j=1; j<=2*(n-i); j++ ){
                System.out.print(" ");
            }

            //star = i.........
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();

        }

        //2nd half.................................
        for(int i=n; i>=1; i--){//make for loop n to 1 (if i++ it is infinite loop)

            //star = i.........
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }

            //spaces = 2*(n-i)........
            for(int j=1; j<=2*(n-i); j++ ){
                System.out.print(" ");
            }

            //star = i.........
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();

        }
    } */


//Solid Rhombus......................................................................................................................
    /*  
     public static void Solid_Rhombus(int n){
        for(int i=1; i<=n; i++){

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            //star
            for(int j=1; j<=n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
     } */


//Hollow Rectangle......................................................................................................................
      /* 
      public static void hollow_rhombus(int n){

          for(int i=1; i<=n; i++){

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
             }

            //we use hollow rectangle code that converted into hollow rhombus
            for(int j=1; j<=n; j++){

                if(i==1 || i==n || j==1 || j==n){//if any condition true it is executed
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
          }
      } */


//Diamond Pattern.........................................................................................................................
      /* 
      public static void diamond_pattern(int n){
        //1st half.........................
        for(int i=1; i<=n; i++){

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            //star
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2nd half...........................
        for(int i=n; i>=1; i--){

            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            //star
            for(int j=1; j<=2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

      } */

//........................................................................................................................................................      
    public static void main(String[] args) {

        // hollow_rectangle(4, 5); .......................... 1]
        // Inverted_pyramid(4); ............................. 2]
        // Inverted_NoPyramid(5); ........................... 3]
        // Floyd_Triangle(5); ............................... 4]
        // zero_one_triangle(5 ); ........................... 5]
        // butterfly_Pattern(4); ............................ 6]
        // Solid_Rhombus(5); ................................ 7]
        // hollow_rhombus(5); ............................... 8]
        // diamond_pattern(4); .............................. 9]
    }
}
