public class ArrayPart3 {

//Max SubArray Sum By optimized approach(Prefix Sum)....................................................................................

/* 
    public static void maxSubarraySum(int number[]){
    
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;//minus infinity
        int prefix[]= new int[number.length];
        
        prefix[0]= number[0];//i.e equal to number at 0th index
        //calculate Prefix array
        for(int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + number[i];// prefix[i]= previous sum + current index element
        }

       
        for(int i=0; i<number.length; i++){
            int start= i;
            for(int j=i; j<number.length; j++ ){
                int end =j;

                currentSum= start== 0 ? prefix[end]: prefix[end] - prefix[start - 1];//Actual logic......
                if(maxSum < currentSum){
                    maxSum = currentSum;
                }
               
            }
                
        }
        System.out.println("max sum="+ maxSum);
           
    }
        
//Time Complexity ==> BigOh(n^2) due to 2 for loop
//Now we see another optimized approach (i.e Kadane's Algorithm)   
        
    public static void main(String[] args) {
        int number[]={1,-2,6,-1,3};
        maxSubarraySum(number);
      } */




//Max SubArray Sum By optimized approach (Kadane's Algorithm).......................................................................................

/* 
    public static void kadanes(int number[]){
      int maxSum = Integer.MIN_VALUE; 
      int currSum = 0;

      for(int i=0; i<number.length; i++){
         currSum = currSum + number[i];
         if(currSum < 0){
            currSum=0;//for negative number make it zero

         }

         maxSum= Math.max(currSum, maxSum);//compare max and curr sum i.e maximum value store at max value
      }

      System.out.println("Maximum sum By Kadanes Algorithm is : "+ maxSum);
    }

    public static void main(String[] args) {
        int number[] = {-2,-3,4,-1,-2,1,5,-3};
        kadanes(number);
     } */



//Traping RainWater By Using Auxilary Array...........................................................................................................................

     /* 
     public static int trap(int height[]){

        int n=height.length;
         //calculate left max array(Auxilary arrayi.e helper array)..................1]
         int leftMax[] = new int[n];
         leftMax[0] = height[0]; //1st equal to its height
         for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);//current height compared with previous height
         }

         //calculate Right max array(Auxilary arrayi.e helper array)...................2]
         int rightMax[] = new int[n];
         rightMax[n - 1] = height[n - 1];//starting from last so last equal to its height 
         for(int i=n-2; i>=0; i--){
            rightMax[i]= Math.max(height[i], rightMax[i+1]);//we start in reverse order i.e i+1
        }

        int trappedwater = 0;
        //loop......................3]
        for(int i=0; i<n; i++){

            //waterLevel = min(leftMax bound, rightMax bound)...............4]
            int waterLevel = Math.min(leftMax[i],rightMax[i]);

            //trapped water = waterLevel - heght[i]....................5]
            trappedwater += waterLevel - height[i];
        }
        return trappedwater;
         
     }

     public static void main(String[] args) {
        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
     } */

//Time Complexity ==> BigOh(n).................................................


//Best Time To Buy & Sell Stock to get Max Profit......................................................................................................................

   public static int buyAndsellStocks(int prices[]){
       int buyPrice = Integer.MAX_VALUE;//plus infinity value
       int maxProfit = 0;

       for(int i=0; i<prices.length; i++){
          if(buyPrice < prices[i]){//profit
            int profit = prices[i] - buyPrice;//today profit
            maxProfit = Math.max(maxProfit, profit);//total profit among all days

          }else{

            buyPrice = prices[i];//price high than sp so it is LOSS
          }
       }

       return maxProfit;
   }
   public static void main(String[] args) {
       int prices[] = {7,1,5,3,6,4};
       System.out.println(buyAndsellStocks(prices));
   }

//Time Complexity ==> BigOh(n)......................................

}
