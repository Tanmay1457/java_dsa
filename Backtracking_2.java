public class Backtracking_2 {

//Grid Ways.......................................................................................

    public static int gridways(int i,int j,int n,int m){
        //base case
         if (i == n-1 && j == m-1){ //condition for last cell
             return 1;
         } else if (i == n || j == n) { //boundary cross condition
             return 0;

         }
        //ways
        int w1 = gridways(i+1,j,n,m);
        int w2 = gridways(i,j+1,n,m);
        return w1 + w2;
    }

//Sudoku Problem.................................................................................

    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column
        for (int i=0; i<=8; i++){
            if (sudoku[i][col] == digit){
                return false;
            }
        }

        //Row
        for (int j=0; j<=8; j++){
            if (sudoku[row][j] == digit){
                return false;
            }
        }

        //Grid
        //start row
        int SR = (row/3) * 3;
        //start column
        int SC = (col/3) * 3;
        //3x3 grid
        for (int i=SR; i<SR+3; i++){
            for (int j=SC; j<SC+3; j++){
                if (sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        //Base case
        if (row == 9 ){
            return true;
        }

        //Recursion
        int nextRow = row, nextCol = col+1;
        if (col+1 == 9){ //next row
            nextRow = row+1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow,nextCol);
        }

        for (int digit=1; digit<=9; digit++){
            if (isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit; //if safe then place
                if (sudokuSolver(sudoku,nextRow,nextCol)){
                    //solution exist
                    return true;
                }
                sudoku[row][col] = 0; //not safe then do not place
            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println(".......................Grid Ways......................");
        //Grid ways
        int n=3, m=3;
        System.out.println("Total Ways : ");
        System.out.println(gridways(0,0,n,m));
        System.out.println(".......................SudoKu......................");
        //Sudoku
        int sudoku[][] = {
                {0,0,8,0,0,0,0,0,0},
                {4,9,0,1,5,7,0,0,2},
                {0,0,3,0,0,4,1,9,0},
                {1,8,5,0,6,0,0,2,0},
                {0,0,0,0,2,0,0,6,0},
                {9,6,0,4,0,5,3,0,0},
                {0,3,0,0,7,2,0,0,4},
                {0,4,9,0,3,0,0,5,7},
                {8,2,7,0,0,9,0,1,3}
            };
        if (sudokuSolver(sudoku,0,0)){
            System.out.println("Solution Exist");
            printSudoku(sudoku);
        }
        else {
            System.out.println("Solution does not exist");
        }
    }
}
