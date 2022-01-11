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
    private Set testSet;

    /* Main controller */
    public void run(int i, int j, String dictionaryFilePath, String wordsFilePath) throws IOException {

        /* 1. Initialize the set */
        switch (i) {
            // Linked List Set
            case 0: testSet = new LinkedListSet(); break;
            // HashMap Set
            case 1: testSet = new HashMapSet(1500); break;
            // Tree Set
            case 2: testSet = new TreeSet(); break;
            default: return;
        }

        /* 2. Preprocess the file and add word to set */
        readFile(dictionaryFilePath, testSet, i, j);
        System.out.println("\nSet size is: " + testSet.size());

        int inSetNum = 0;
        long elapsedTime = 0;

        /* 3. Preprocess the words and load the words into a list */
        String[] words = words2Find(wordsFilePath);
        FileWriter writer = new FileWriter(new File("./data/search_"+ i +"_"+ j +".csv"));
        System.out.println("There are " + words.length + " words to look up");

        /* 4. Look up words in the dictionary and count elapsed time */
        for (String word : words) {
            long start = System.nanoTime();
            if (testSet.contains(word)) {
                inSetNum++;
                long finish = System.nanoTime();
                elapsedTime += finish - start;
                writer.write(word+","+Long.toString(finish - start) + "\n");
            }
        }
        writer.close();
        System.out.println("Finding costs: " + (double) elapsedTime + " nanoseconds");
        System.out.println("There are " + inSetNum + " words in the Set.");
    }


    // Read file and add to a set
    public void readFile(String filePath, Set mySet, int i, int j) throws IOException {
        // Make file reader
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        // Make file Writer
        FileWriter writer = new FileWriter(new File("./data/add_" + i +"_"+ j + ".csv"));

        // Process line by line
        String curLine;
        long elapsedTime = 0;
        int fileLen = 0;
        while ((curLine = in.readLine()) != null) {
            // use regex to tokenize the word
            String[] lineWords = curLine.split("[^a-zA-Z0-9]+");
            for (String word : lineWords) {
                fileLen++;
                // record time for each insertion start
                long start = System.nanoTime();
                if(word != null) {
                    // add each word which is not null
                    if (mySet.add(word) == true) {
                        // record time end
                        long finish = System.nanoTime();
                        elapsedTime += (finish - start);
                        writer.write(Long.toString(finish - start) + "\n");
                    }
                }
            }
        }
        writer.close();
        System.out.println("file length: " + fileLen);
        System.out.println("Insertion costs: " + (double) elapsedTime + " nanoseconds");
    }

    /* Add words to a list and return a primitive String array */
    public String[] words2Find(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String curLine;
        List<String> words = new ArrayList<>();
        // Add words into List
        while ((curLine = in.readLine()) != null) {
            // replace under score with empty
            String newLine = curLine.replace("_", "");
            words.add(newLine);
        }
        String[] ret = new String[words.size()];
        words.toArray(ret);
        return ret;
    }

    public static void main(String args[]) throws IOException {
        String dictionaryFilePath = "./data/pride-and-prejudice.txt";
        String wordsFilePath = "./data/words-shuffled.txt";
        Main obj = new Main();
        /*
            0 - 2 to choose set type
            0: LinkedList Set
            1: Hash Set
            2: Tree Set
        * */
        for(int i = 0; i < 3; i++) {
            /* run each algorithm 10 times */
            for(int j = 0; j < 1; j++){
                obj.run(i, j, dictionaryFilePath, wordsFilePath);
            }
        }
        return;
    }
}
