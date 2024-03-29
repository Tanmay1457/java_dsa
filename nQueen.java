public class nQueen {

    //find safe position to avoid attack
    public static boolean isSafe(char board[][],int row,int col){
        //check vertically up
         for (int i=row-1; i>=0; i--){
             if (board[i][col] == 'Q'){
                 return false;
             }
         }
         //diagonally left up
         for (int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
             if (board[i][j] == 'Q'){
                 return false;
             }
         }
         //diagonally right up
         for (int i=row-1, j=col+1; i>=0 && j< board.length; i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
         }
         return true;
    }
//    public static void nqueenNew(char board[][],int row){
//        //base case
//        if (row == board.length){
//            //printboard(board);
//            count++; //for optimization rather printing board we return possible way but time remain same
//            return;
//        }
//
//        //column loop we place queen without considering its attack (one queen in one row)
//        for (int j=0; j< board.length; j++){
//
//            if (isSafe(board,row,j)) { //it find it is safe to place
//                board[row][j] = 'Q';
//                nqueenNew(board, row + 1);//function call for next row
//                board[row][j] = 'X';//for placing another row+1 row (backtracking step)
//            }
//        }
//    }

    //For printing only one solution............

    public static boolean nqueenNew(char board[][],int row){
        //base case
        if (row == board.length){
            //printboard(board);
            count++; //for optimization rather printing board we return possible way but time remain same
            return true;
        }

        //column loop we place queen without considering its attack (one queen in one row)
        for (int j=0; j< board.length; j++){

            if (isSafe(board,row,j)) { //it find it is safe to place
                board[row][j] = 'Q';
                if (nqueenNew(board, row + 1)){
                    return true;
                }
                board[row][j] = 'X';
            }
        }
        return false;
    }
    public static void printboard(char board[][]){
        System.out.println("--------Chess Board(possible Solution)----------");
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count =0;
    public static void main(String[] args) {

        int n=4;
        char board[][] = new char[n][n];
        //Initialize
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = 'X';
            }
        }
        if (nqueenNew(board,0)){
            System.out.println("solution is possible.......");
            printboard(board);
        }else {
            System.out.println("solution not possible");
        }

        //System.out.println("Total ways to solve n queen = " + count);
    }
}
