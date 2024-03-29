public class ArrayPart2 {

/* 
//Linear Search........................................................................................
    public static int LS(int number[], int key){
        
        for(int i=0; i<number.length; i++){
            if(number[i]==key){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int number[]={2,4,6,8,10,12,14,16};
        int key=10;

        int index= LS(number, key);
        
        if(index== -1){
            System.out.println("NOT found");
        }else{
        System.out.println("key at index " + index);
        }
    }*/
 // Linear Search Time Complexity ==>  "BigOh(n)" due to for loop (0 to ntimes)


//Largest and smallest no in array...................................................................................

/* 
public static void main(String[] args) {
    int number[]= {1,2,3,6,5};
    System.out.println("largest value is :"+ getLargest(number));

     
   }

public static int getLargest(int number[]){
    int largest = Integer.MIN_VALUE; //represent minus infinity value
    int smallest = Integer.MAX_VALUE; //smallest value

    for(int i=0; i<number.length; i++){
        if(largest< number[i]){
            largest = number[i]; //update that no to largest
        }

        if(smallest> number[i]){
            smallest = number[i];
        }
    }
    
    System.out.println("smallest value is " + smallest);
    return largest;//here only one can return not both
   
  } */


//Binary Search......................................................................................................

/* 
public static int BinarySearch(int number[], int key){
    int start=0, end = number.length - 1;

    while(start<=end){//Equal bcoz when we dealing with single element its start and end is same
        int mid = (start + end)/2;

        //Comparisons
        if(number[mid] == key){//found
            return mid;
        }
        if(number[mid] < key){//Right side
            start = mid+1;
        }else{//Left side
            end = mid-1;
        }
    }
    return -1;//if key not exist
}
public static void main(String[] args) {
    int number[]= {2,4,6,8,10,12,14};
    int key = 10;

    System.out.println("index for key is :" + BinarySearch(number, key));

    //Time Complexity of Binary Search ==> BigOh(log n)............... 

 } */



/* 
//Reverse an Array with no extra space....................................................................................................

public static void reverse(int number[]){
    int first=0, last=number.length - 1;

    while(first < last){
        //swap the value
        int temp = number[last];//here number[4] value at index 4 printed
        number[last]=number[first];
        number[first]=temp;

        first++;
        last--;

    }
}

public static void main(String[] args) {
   int number[] = {2,4,6,8,10};

   reverse(number);

   //print array
   for(int i=0; i<number.length; i++){
      System.out.print(number[i]+" ");
   }
  

  } */



/* 
//Pair of an Array....................................................................................................................

 public static void printPair(int number[]){
    int totalpair=0;//very Imp 
    for(int i=0; i<number.length; i++){
        int current = number[i];//value at respective index is 2,4,6,8,10
        for(int j=i+1; j<number.length; j++){
           System.out.print("("+current+ "," + number[j]  + ")" ); 
           totalpair++;
        }
       
    }
    System.out.println("Total pair are "+totalpair);//Imp Question
 }
 public static void main(String[] args) {
    int number[]={2,4,6,8,10};
    
    System.out.println("All Possible Pair :-");
    printPair(number);
 }
 //Time Complexity ==> BigOh(n^2)................ */


//Print Sub-Array........................................................................................................................
/* 
public static void PrintSubarray(int number[]){
    
    int totalSubarray=0;
    for(int i=0; i<number.length; i++){
        int start= i;
        for(int j=i; j<number.length; j++ ){
            int end =j;
            for(int k=start; k<=end; k++){//print
                System.out.print(number[k]+" ");//SubArray.....
            }
            totalSubarray++;
           
        }
       
    }
    System.out.println(totalSubarray);
    
}

public static void main(String[] args) {
    int number[]={2,4,6,8,10};
    PrintSubarray(number);
  } */ 


//Max SubArraySum (Brute force Approach).................................................................................................

/* 
public static void maxSubarraySum(int number[]){
    
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;//minus infinity
   
    for(int i=0; i<number.length; i++){
        int start= i;
        for(int j=i; j<number.length; j++ ){
            int end =j;
            currentSum=0;
            for(int k=start; k<=end; k++){
                //subarray sum
                currentSum += number[k];
            }
            System.out.println(currentSum);
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
            
           
        }
       
    }
    
    System.out.println("Maximum sum ="+ maxSum);
    
}

public static void main(String[] args) {
    int number[]={1,-2,6,-1,3};
    maxSubarraySum(number);
  } */

//Time Complexity ==> BigOh(n^3) due to three for loop it is very  wrost time complexity
//Now we see optimized approach i.e prefix sum
}
