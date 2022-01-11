package Sorting;

import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void sort(List<String> list) {
        if (list == null) {
            return;
        }
        int left = 0, right = list.size() - 1;
        sortHelper(list, left, right);
    }

    private static void sortHelper(List<String> list, int left, int right) {
        int p = 0;

        if(left < right) {
            p = partition(list, left, right);
            sortHelper(list, left, p - 1);
            sortHelper(list, p + 1, right);
        }
    }

    private static int partition(List<String> list, int left, int right) {
        int indexOfPivot = right;
        String pivot = list.get(indexOfPivot);

        // From textbook
        int firstHigh = left;
        for(int i = left; i < right; i++){
            if(list.get(i).compareTo(pivot) < 0) {
                Collections.swap(list, i, firstHigh);
                firstHigh++;
            }
        }
        Collections.swap(list, firstHigh, indexOfPivot);

        return firstHigh;
    }


}
