package Sorting;

import java.util.Collections;
import java.util.List;

public class InsertionSort {
    public static void sort(List<String> list) {
        int len = list.size();
        String key = null;
        for(int i = 1; i < len; i++){
            key = list.get(i);
            int j = 0;
            for(j = i - 1; j >= 0 && (key.compareTo(list.get(j)) < 0); j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, key);
        }
    }
}
