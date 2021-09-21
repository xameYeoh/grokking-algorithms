import java.util.*;

class Quicksort{
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
}
