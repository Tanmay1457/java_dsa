public class pattern_1 {
    public static void main(String[] args) {

//Star pattern........................................................................................................................

/*           for(int line =1; line<=4; line++){//for one line

                  for(int star=1;star<=line;star++){//for same line (no of star = line no) 
                    System.out.print("*");
                  }
                    System.out.println();
                } */


//Inverted Star pattern................................................................................................................
             
/*          int n=4; //Total no of lines

            for(int line=1;line<=n;line++){

                   for(int star=1;star<= n-line+1;star++){
                         System.out.print("*");//here we use only print
                   }

                   System.out.println(); 
             } */


//Half Pyramid Pattern..................................................................................................................

/*          int n=4; //Total no of lines
              
            for(int line=1; line<=n; line++){//for line n
                 
                    for(int number=1; number<=line; number++){ //here we print no from 1 to n
                        System.out.print(number);//for printing same line
                    }
                    System.out.println(); 
              }  */ 
              
           
//Print Character Pattern................................................................................................................

/*           int n=4; // total no of lines
             char ch = 'A';

             for(int line=1; line<=n; line++){

                 for(int chars=1; chars<=line;chars++){//charcter not repeated
                     System.out.print(ch);
                     ch++;//increment every time
                 }
                 System.out.println();
             }  */ 
             
          }
    }

