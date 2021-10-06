import LinkedList.LinkedList;
import MySet.HashMapSet;
import MySet.LinkedListSet;
import MySet.Set;
import MySet.TreeSet;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public void run() throws IOException {
        // java.util.Set<String> testSet = new HashSet<>();
        // Set testSet = new LinkedListSet();
        Set testSet = new HashMapSet(64);
        // Set testSet = new TreeSet();
        readFile("./data/pride-and-prejudice.txt", testSet);
        //readFile("./data/test.txt", testSet);
        System.out.println("Set size is: " + testSet.size());

        int inSetNum = 0;
        long elapsedTime = 0;

        String[] words = words2Find("./data/words-shuffled.txt");
        //FileWriter writer = new FileWriter(new File("./data/search-linked.csv"));
        System.out.println("There are " + words.length + " words in the Set.");
        for (String word : words) {
            long start = System.nanoTime();
            if (testSet.contains(word)) {
                inSetNum++;
                long finish = System.nanoTime();
                elapsedTime += finish - start;
                //writer.write(word+"\t"+Long.toString(finish - start) + "\n");
            }
        }
        //writer.close();
        System.out.println("Finding costs: " + (double) elapsedTime + " nanoseconds");
        System.out.println("There are " + inSetNum + " words not in the Set.");
    }

    public void readFile(String filePath, Set mySet) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        //FileWriter writer = new FileWriter(new File("./data/add-hash.csv"));
        String curLine;
        long elapsedTime = 0;
        int fileLen = 0;
        while ((curLine = in.readLine()) != null) {
            String[] lineWords = curLine.split("[^a-zA-Z0-9]+");
            for (String word : lineWords) {
                fileLen++;
                long start = System.nanoTime();
                if(word != null) {
                    if (mySet.add(word) == true) {
                        long finish = System.nanoTime();
                        elapsedTime += (finish - start);
                        //writer.write(Long.toString(finish - start) + "\n");
                    }
                }
            }
        }
        //writer.close();
        System.out.println("file length: " + fileLen);
        System.out.println("Insertion costs: " + (double) elapsedTime + " nanoseconds");
    }

    public void readFile(String filePath, java.util.Set mySet) throws IOException {
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

    public String[] words2Find(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String curLine;
        List<String> words = new ArrayList<>();
        while ((curLine = in.readLine()) != null) {
            String newLine = curLine.replace("_", "");
            words.add(newLine);
        }
        String[] ret = new String[words.size()];
        words.toArray(ret);
        return ret;
    }

    public static void main(String args[]) throws IOException {
        Main obj = new Main();
        obj.run();
        return;
    }
}
