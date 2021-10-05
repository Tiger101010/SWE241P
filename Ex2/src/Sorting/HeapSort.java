package Sorting;

import java.util.Collections;
import java.util.List;

public class HeapSort {
    private static Heap heap = new Heap();

    public static void sort(List<String> list) {
        heap.setHeap(list);
        for(int i = list.size() - 1; i >= 1; i--){
            heap.swap(i, 0);
            heap.siftDown(0, list.size() - i);
        };
    }
}

class Heap {
    private List<String> str;

    public Heap() {
        str = null;
    }

    public void setHeap(List<String> str) {
        this.str = str;
        heapify();
    }

    public void siftDown(int i, int reduceSize){
        if(reduceSize > str.size()) {
            return;
        }
        while(i * 2 + 1 < str.size() - reduceSize) {
            int son = i * 2 + 1;
            if(i * 2 + 2 < str.size() - reduceSize && comp(son, i * 2 + 2) < 0) {
                son = i * 2 + 2;
            }
            if(comp(son, i) <= 0){
                break;
            }
            swap(son, i);
            i = son;
        }
    }

    public void heapify() {
        for(int i = (str.size() - 1) / 2; i >= 0; i--) {
            siftDown(i, 0);
        }
    }

    public String top() {
        if (str != null)
            return str.get(0);
        return null;
    }


    public void swap(int i, int j) {
        Collections.swap(this.str, i, j);
    }


    private int comp(int i, int j){
        return str.get(i).compareTo(str.get(j));
    }

}
