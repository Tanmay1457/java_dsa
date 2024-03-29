public class Backtracking {

//Back tracking on array.....................................................................................
    public static void  changeArr(int arr[],int i,int val){
        //Base case
         if (i == arr.length){
             printArr(arr);
             return;
         }
        //Recursion
        arr[i] = val;
        changeArr(arr, i+1,val+1);
        arr[i] = arr[i] - 2; //decrese by 2 i.e Backtracking step

    }
    public static void printArr(int arr[]){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//Find subset.................................................................................................
    public static void findSubset(String str, String ans, int i){
        //Base case
        if (i == str.length()){
            if (ans.length() == 0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }


        //Yes Choice...........
        findSubset(str,ans+str.charAt(i),i+1);

        //No choice............
        findSubset(str,ans,i+1);
    }

//Find Permutation...........................................................................................
    public static void findPermutation(String str, String ans){
        //Base case
        if (str.length() == 0){
            System.out.println(ans);
            return;
        }


        //Recurssion
        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i); //picking chracter

            //"abcde" => "ab" + "de" = "abde" c removed i.e picking character
            String newstr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newstr,ans+curr);
        }
    }

    //N queen problem in another file.......


    public static void main(String[] args) {

    //.................................................
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);
    //.................................................
        String str = "abc";
        findSubset(str,"",0);

    //.................................................
        findPermutation(str,"");


    }
}
