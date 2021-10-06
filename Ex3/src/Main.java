import MyGraph.Graph;

public class Main {

    private void run() {
        Graph g = new Graph(5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(5,2);
        g.printAdjMx();

        g.adjMx2AdjList();
        g.printList();

        g.adjList2IncMx();
        g.printIncMX();

        g.printNewIncMX(g.incMx2AdjList());

    }

    public static void main(String args[]) {
        Main obj = new Main();
        obj.run();
    }
}
