import java.util.*;


public class TwoDimensionalArray {

/*
    //search element in array
    public static boolean search(int matrix[][],int key){
        for(int i=0;i<matrix.length; i++ ){
            for(int j=0;j<matrix[0].length; j++ ){
                if(matrix[i][j] == key){
                    System.out.println("found at cell(" + i + "," + j +")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3]; //3x3 matrix created
        int n=matrix.length , m=matrix[0].length ; //row and column

        Scanner sc= new Scanner(System.in);// i/p element
        for(int i=0;i<n; i++ ){
            for(int j=0;j<m; j++ ){
                matrix[i][j] = sc.nextInt();
            }
        }

        //o/p element
        for(int i=0;i<n; i++ ){
            for(int j=0;j<m; j++ ){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        search(matrix, 5);
    } */

//Spiral Matrix.......................................................................................................
    /*
    public static void printSpiral(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol){

            //Top Boundry row fixed i.e 0th column changes
            for(int j=startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j]+" ");
            }

            //Right Boundry
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol]+" ");
            }

            //Bottom Boundry
            for(int j=endCol-1; j>=startCol; j--){

                //special condition for nxn or mxn matrix if it is "ODD"
                if(startRow == endRow){
                    break; //same element not print two times
                }
                System.out.print(matrix[endRow][j]+" ");
            }

            //Left Boundry
            for(int i=endRow-1; i>=startRow+1; i--){

                //special condition for nxn or mxn matrix if it is "ODD"
                if(startCol == endCol){
                    break; //same element not print two times
                }
                System.out.print(matrix[i][startCol]+" ");
            }

            //update
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();

    }*/

//Diagonal Sum....................................................................................................

    //time complexity O(n^2)........................................


    public static int Diagonalsum( int matrix[][]){
        int sum= 0;

        /*
        for(int i=0; i<matrix.length; i++){//n time
            for(int j=0; j<matrix[0].length; j++){//for every columns n time run
                //Primary Diagonal condition........
                if(i == j){
                    sum += matrix[i][j];
                }
                //Secondary Diagonal condition......
                else if(i+j == matrix.length-1){
                    sum += matrix[i][j];
                }
            }
        }*/

        //Optimized approach linear time complexity..................
        for(int i=0; i<matrix.length; i++){
            //primary diagonal.........
            sum+= matrix[i][i];
            //seconary diagonal............
            //odd matrix handling condition
            if(i != matrix.length-i-1){
                sum+= matrix[i][matrix.length-i-1];
            }


        }

        System.out.println(sum);
        return sum;


    }

//Search in sorted Matrix(By Staircase Search)........................................................................
    public static boolean staircaseSearch(int matrix[][],int key){
        int row =0, col = matrix.length-1;

        while (row< matrix.length && col >=0){
            if(matrix[row][col] == key){
                System.out.println("found key at (" + row + ","+ col+")");
                return true;
            }
            //case 1 move Left .......................
            else if (key < matrix[row][col]) {
                col--;
            }
            //case 2 move Bottom ....................
            else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void main(String[] args) {
        /*int matrix[][] = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};*/

        // printSpiral(matrix);.....................................

        // Diagonalsum(matrix);.....................................

       // staricase search.........
        int matrix[][] = {{10,20,30,40},
                          {15,25,35,45},
                          {27,29,37,48},
                          {32,33,39,50}};

        int key = 100;
        staircaseSearch(matrix,key);//Time complexity => O(n+m) n=row & m=column
    }
}
