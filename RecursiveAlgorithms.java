import java.util.*;
class RecursiveAlgorithms{
    boolean result = false;
    
    boolean binarySearch(int[] arr, int x){ //binary search recursive
        int middle = arr.length / 2;
        if(arr[middle]== x) return true;
        else{
        	if(arr.length == 1) return false;
            if(arr[middle] > x) return binarySearch(Arrays.copyOfRange(arr, 0, middle), x);
            else return binarySearch(Arrays.copyOfRange(arr, ++middle, arr.length), x);
        }
    }
    
    static ArrayList<Integer> quicksort(ArrayList<Integer> arr){ //quicksort recursive
        if (arr.size() < 2) return arr;
        else{
            int pivot = arr.get(0);
            ArrayList<Integer> less = new ArrayList<Integer>();
            ArrayList<Integer> greater = new ArrayList<Integer>();
            ArrayList<Integer> merged = new ArrayList<Integer>();
            for(int i = 1;i < arr.size(); i++){
                int num = arr.get(i);
                if(num < pivot) less.add(num);
                else greater.add(num);
            }
            merged.addAll(quicksort(less));
            merged.add(pivot);
            merged.addAll(quicksort(greater));
            return merged;
        }
    }
    
    static int max(int[] arr){ //find max element in array(recursive exercise)
        if (arr.length == 2) return (arr[0] > arr[1]) ? arr[0] : arr[1];
        else{
            int maxOtherNums = max(Arrays.copyOfRange(arr, 1, arr.length));
            return (arr[0] > maxOtherNums) ? arr[0] : maxOtherNums; 
        }   
    }

    static int sum(int[] arr, int n){ //find sum of array elements(recursive exercise)
        if (n == arr.length) return 0;
        else{
            return arr[n] + sum(arr, ++n);
        }
    }
    
    static int length(int[] arr, int n){ //find array length(recursive exercise)
        if (n == arr.length) return 0;
        else return 1 + length(arr, ++n);
    }

    public static void main(String[] args){
       ArrayList arr = new ArrayList();
       arr.addAll(Arrays.asList(1, 3, 2, 5, 4));
       System.out.println(quicksort(arr));
    }
}
