import LinkedList.LinkedList;
import MySet.LinkedListSet;
import MySet.Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public void run() throws IOException {
        Set testSet = new LinkedListSet();
        readFile("./data/pride-and-prejudice.txt", testSet);
        System.out.println("Set size is: " + testSet.size());

        int inSetNum = 0;
        long elapsedTime = 0;

        String[] words = words2Find("./data/words-shuffled.txt");
        for (String word : words) {
            long start = System.nanoTime();
            if (testSet.contains(word)) {
                long finish = System.nanoTime();
                elapsedTime += finish - start;
                inSetNum++;
            }
        }
        System.out.println("Finding costs: " + (double) elapsedTime / 1_000_000_000.0 + " seconds");
        System.out.println("There are " + inSetNum + " words in the Set.");
    }

    public void readFile(String filePath, Set mySet) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String curLine;
        long elapsedTime = 0;
        while ((curLine = in.readLine()) != null) {
            String[] lineWords = curLine.split("[^a-zA-Z0-9]");
            for (String word : lineWords) {
                long start = System.nanoTime();
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
        List<String> words = new ArrayList<String>();
        while ((curLine = in.readLine()) != null) {
            words.add(curLine);
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
