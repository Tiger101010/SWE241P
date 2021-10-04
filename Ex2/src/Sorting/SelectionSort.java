package Sorting;

import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void sort(List<String> a){
        int len = a.size();
        for(int i = 0; i < len - 1; i++){
            int indexOfMin = i;
            for(int j = len - 1; j > i; j--) {
                if(a.get(j).compareTo(a.get(indexOfMin)) < 0){
                    indexOfMin = j;
                }
            }
            Collections.swap(a, i, indexOfMin);
        }
    }
}
