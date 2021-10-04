package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void sort(List<String> list){
        if(list == null) {
            return;
        }
        int left = 0, right = list.size() - 1;
        sortHelper(list, left, right);
    }

    private static void sortHelper(List<String> list, int left, int right){
        if(left < right){
            int middle = left + (right - left) / 2;
            sortHelper(list, left, middle);
            sortHelper(list, middle + 1, right);

            merge(list, left, right, middle);
        }
    }

    private static void merge(List<String> list, int left, int right, int middle) {
        int sizeOfLeft = middle - left + 1;
        int sizeOfRight = right - middle;

        List<String> leftOfList = new ArrayList<>();
        List<String> rightOfList = new ArrayList<>();
        for (int i = left; i <= middle; i++) {
            leftOfList.add(list.get(i));
        }
        for (int i = middle + 1; i <= right; i++) {
            rightOfList.add(list.get(i));
        }

        int idxOfLeft = 0, idxOfRight = 0;
        int idxOfMerged = left;
        while(idxOfLeft < sizeOfLeft && idxOfRight < sizeOfRight) {
            if(leftOfList.get(idxOfLeft).compareTo(rightOfList.get(idxOfRight)) < 0) {
                list.set(idxOfMerged, leftOfList.get(idxOfLeft));
                idxOfLeft++;
            } else {
                list.set(idxOfMerged, rightOfList.get(idxOfRight));
                idxOfRight++;
            }
            idxOfMerged++;
        }
        while(idxOfLeft < sizeOfLeft){
            list.set(idxOfMerged, leftOfList.get(idxOfLeft));
            idxOfLeft++;
            idxOfMerged++;
        }
        while(idxOfRight < sizeOfRight){
            list.set(idxOfMerged, rightOfList.get(idxOfRight));
            idxOfRight++;
            idxOfMerged++;
        }
    }

}
