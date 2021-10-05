import Sorting.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public void print(List<String> list){
        for (String s: list) {
            System.out.print(s + "->");
        }
        System.out.println();
    }

    public void run() throws IOException{
        List<String> list = new ArrayList<String>();
        readFile("./data/pride-and-prejudice.txt", list);
        // readFile("./data/test.txt", list);
        long start = System.nanoTime();
        InsertionSort.sort(list);
        // SelectionSort.sort(list);
        // HeapSort.sort(list);
        // MergeSort.sort(list);
        // QuickSort.sort(list);

        // Collections.sort(list);
        long end = System.nanoTime();
        // System.out.println(list);
        //System.out.println("Sorting costs: " + (double) (end - start) / 1_000_000_000.0 /60 + " minutes");
        System.out.println("Sorting costs: " + (double) (end - start) / 1_000_000_000.0 + " seconds");
        return;
    }

    public void readFile(String filePath, List mySet) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String curLine;
        long elapsedTime = 0;
        while ((curLine = in.readLine()) != null) {
            String[] lineWords = curLine.split("[^0-9a-zA-Z]+");
            for (String word : lineWords) {
                long start = System.nanoTime();
                if(word != null)
                    mySet.add(word);
                long finish = System.nanoTime();
                elapsedTime += (finish - start);
            }
        }
        System.out.println("Insertion costs: " + (double) elapsedTime / 1_000_000_000.0 + " seconds");
    }

    public static void main(String args[]) throws IOException{
        Main obj = new Main();
        obj.run();
        return;
    }
}
