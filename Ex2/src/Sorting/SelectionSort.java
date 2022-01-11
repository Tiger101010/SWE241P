package Sorting;

import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public static void sort(List<String> list){
        int len = list.size();
        for(int i = 0; i < len - 1; i++){
            int indexOfMin = i;
            for(int j = len - 1; j > i; j--) {
                if(list.get(j).compareTo(list.get(indexOfMin)) < 0){
                    indexOfMin = j;
                }
            }
            Collections.swap(list, i, indexOfMin);
        }
    }
}
