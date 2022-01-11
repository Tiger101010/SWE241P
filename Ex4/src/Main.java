import MyGraph.Graph;

public class Main {

    private void run() {
        // Build a graph
        Graph g = new Graph(10);
        addEdges2Graph(g);

        System.out.println("\nThe BFS result start from A is: " + g.bfs('A'));

        System.out.println("\nThe DFS result start from A is: " + g.dfs('A'));

        System.out.println("\nThe DFS result start from A is: " + g.dfsRecursive('A') + " Recursive Version");
    }

    private void addEdges2Graph(Graph g){
        g.addEdge('A', 'B');
        g.addEdge('A', 'D');
        g.addEdge('A', 'I');
        g.addEdge('B', 'C');
        g.addEdge('B', 'D');
        g.addEdge('B', 'E');
        g.addEdge('D', 'E');
        g.addEdge('D', 'G');
        g.addEdge('I', 'G');
        g.addEdge('I', 'J');
        g.addEdge('C', 'E');
        g.addEdge('C', 'F');
        g.addEdge('E', 'F');
        g.addEdge('E', 'H');
        g.addEdge('E', 'G');
        g.addEdge('G', 'H');
        g.addEdge('G', 'I');
        g.addEdge('G', 'J');
        g.addEdge('J', 'H');
        g.addEdge('H', 'F');

        // g.printAdjMx();
        g.adjMx2AdjList();
        g.printAdjList();
    }

    public static void main(String args[]) {
        Main obj = new Main();
        obj.run();
    }
}
