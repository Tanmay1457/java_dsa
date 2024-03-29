public class DivideAndConquer {


    public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

        int[] sorted = new int[one.length + two.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < one.length && j < two.length) {

            if (one[i] < two[j]) {
                sorted[k] = one[i];
                k++;
                i++;
            } else {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (i == one.length) {

            while (j < two.length) {
                sorted[k] = two[j];
                k++;
                j++;
            }
        }

        if (j == two.length) {

            while (i < one.length) {
                sorted[k] = one[i];
                k++;
                i++;
            }
        }

        return sorted;

    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] br = new int[1];
            br[0] = arr[lo];

            return br;
        }

        int mid = (lo + hi) / 2;

        int[] fh = mergeSort(arr, lo, mid);
        int[] sh = mergeSort(arr, mid + 1, hi);

        int[] merged = mergeTwoSortedArrays(fh, sh);

        return merged;
    }
//........................................................................................................
    public static void printArr(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[],int si, int ei){
        if (si >= ei){
            return;
        }
        //last element
        int pidx = partition(arr,si,ei);
        quickSort(arr,si,pidx-1); //left
        quickSort(arr,pidx+1,ei); //right
    }
    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1; //to make place for element smaller than pivot

        for (int j=si; j<ei; j++){
            if (arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

//...........................................................................................................
    public static int search(int arr1[],int tar,int si,int ei){
        if (si > ei){
            return -1;
        }
         int mid = si + (ei - si)/2;

         //found in mid
         if (arr1[mid] == tar){
             return mid;
         }

        //mid on line L1
         if (arr1[si] <= arr1[mid]){
             //cas a
             if (arr1[si] <= tar && tar <= arr1[mid]){
                 return search(arr1,tar,si,mid-1);
                 //case b
             }else {
                 return search(arr1,tar,mid+1,ei);
             }
         }

         //mid on Line L2
         else {
            //case c
             if (arr1[mid] <= tar && tar <= arr1[ei]){
                 return search(arr1, tar, mid+1, ei);
             }
             //case d
             else {
                 return search(arr1, tar, si, mid-1);
             }

         }

       }

    public static void main(String[] args) {

//Merge sort..............................................................................................
        int[] arr = { 6,3,9,5,2,8 };

        int[] merged = mergeSort(arr, 0, arr.length - 1);

        for (int val : merged) {
            System.out.print(val + " ");
        }

//Quick Sort...............................................................................................
        quickSort(arr,0,arr.length-1);
        printArr(arr);

//search in sorted rotated array...........................................................................................
        int arr1[] = {4,5,6,7,0,1,2};
        int target = 6; //o/p = 4
        int tarIdx = search(arr1,target,0,arr.length-1);
        System.out.println(tarIdx);

    }

}