import java.util.*;
public class BinarySearch {
	
	static boolean binarySearch(int[] arr, int x){
        int middle = arr.length / 2;
        if(arr[middle]== x) return true;
        else{
        	if(arr.length == 1) return false;
            if(arr[middle] > x) return binarySearch(Arrays.copyOfRange(arr, 0, middle), x);
            else return binarySearch(Arrays.copyOfRange(arr, ++middle, arr.length), x);
            
        }
    }
	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] {1,2,3,4,5}, 0));
	}
}
