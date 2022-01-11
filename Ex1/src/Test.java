import MySet.HashMapSet;
import MySet.LinkedListSet;
import MySet.Set;
import MySet.TreeSet;

import java.io.IOException;

public class Test {

    public static void printResult(boolean expectation, boolean result){
        System.out.print("Test ");
        if (expectation == result) {
            System.out.print("Pass\n");
        } else {
            System.out.print("Failed\n");
        }
        return;
    }

    public static void testSet(){

        Set testHashSet = new HashMapSet(100);
        Set testTreeSet = new TreeSet();
        Set testLinkedSet = new LinkedListSet();

        // Test HashSet
        printResult(true, testHashSet.add("a"));
        printResult(false, testHashSet.add("a"));
        printResult(true, testHashSet.contains("a"));
        printResult(true, testHashSet.add("b"));
        printResult(true, testHashSet.size() == 2);

        // Test TreeSet
        printResult(true, testTreeSet.add("a"));
        printResult(false, testTreeSet.add("a"));
        printResult(true, testTreeSet.contains("a"));
        printResult(true, testTreeSet.add("b"));
        printResult(true, testTreeSet.size() == 2);

        // Test LinkedListSet
        printResult(true, testLinkedSet.add("a"));
        printResult(false, testLinkedSet.add("a"));
        printResult(true, testLinkedSet.contains("a"));
        printResult(true, testLinkedSet.add("b"));
        printResult(true, testLinkedSet.size() == 2);
    }

    public static void testFunction() throws IOException {
        Main obj = new Main();
        String testInputPath = "./data/test.txt";

        Set testHashSet = new HashMapSet(100);
        Set testTreeSet = new TreeSet();
        Set testLinkedSet = new LinkedListSet();

        // Test readFile with sets
        obj.readFile(testInputPath, testHashSet,0, 0);
        printResult(true, testHashSet.size() == 5);

        obj.readFile(testInputPath, testTreeSet,0, 0);
        printResult(true, testTreeSet.size() == 5);

        obj.readFile(testInputPath, testLinkedSet,0, 0);
        printResult(true, testLinkedSet.size() == 5);
    }

    public static void main(String args[]) throws IOException {
        testSet();
        testFunction();
    }
}
