import MyGraph.Graph;

public class Main {

    private void run() {
        // Initialize a graph with adjacency matrix
        Graph g = new Graph(5);

        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(5,2);
        g.printAdjMx();

        // a. Convert from an adjacency matrix to adjacency lists
        g.adjMx2AdjList();
        g.printAdjList();

        // b. Convert from an adjacency list to an incidence matrix.
        g.adjList2IncMx();
        g.printIncMX();

        // c. Convert from an incidence matrix to adjacency lists.
        g.printNewAdjList(g.incMx2AdjList());

    }

    public static void main(String args[]) {
        Main obj = new Main();
        obj.run();
    }
}
