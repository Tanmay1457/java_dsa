import java.util.Arrays; //for inbulit sorting
import java.util.Collection;
import java.util.Collections;

public class BasicSortingAlgorithm {

//Bubble Sort............................................................................................

    public static void bubblesort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){//for no of turn i.e n-1 turn
            
            
            for(int j=0; j<arr.length-1-turn; j++){//for inner loop
                
                if(arr[j] > arr[j+1]){//current check with next element
                     
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                }
                
            }

        }
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

//Selection Sort........................................................................................

    public static void SelectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++ ){//for n-2 turn

            int minPos =i; //let current element is minimum
             
            for(int j=i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j]){
                   minPos = j; //minimum no update!
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;

        }
    }

//Insertion Sort........................................................................................

    public static void InsertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){//for fixing i-1th element at correct position
            int curr = arr[i];//store temporary index
            int prev = i-1;

            //finding correct position to insert
            while(prev >=0 && arr[prev] > curr){//for descending order i.e arr[prev] < curr
                arr[prev + 1] = arr[prev];//shift by next index
                prev--;
            }

            //inertion
            arr[prev + 1] = curr;

        }
    }


//Counting Sort..............................................................................................

    public static void CountingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];//starting from zero so
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++; //count update
        }

        //sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

//.................................................................................................................................
    public static void main(String[] args) {
       
         int arr[] = {5, 4, 1, 3, 2};

         //bubblesort(arr);...............1]
         //SelectionSort(arr);..............2]
         //InsertionSort(arr);...............3]

    //Inbuilt sorting.............................4]
    // Arrays.sort(arr);.......1st method
    // Arrays.sort(arr, 0, 3); //only 1st three element sort .......2nd method

    // Arrays.sort(arr, Collections.reverseOrder());//make int to Integer


         //CountingSort(arr);
          
         //printArr(arr);

         // Print the sorted array
         System.out.println(Arrays.toString(arr));
    }
}
