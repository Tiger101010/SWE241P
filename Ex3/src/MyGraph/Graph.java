package MyGraph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numOfVertices;
    private int numOfEdges;
    // Adjacency Matrix
    private int adjMx[][];
    // Adjacency List
    private LinkedList<Integer> adjList[];
    // Incidence Matrix
    private int incMx[][];

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        adjMx = new int[numOfVertices + 1][numOfVertices + 1];
        //adjList = new LinkedList[numOfVertices];
    }

    public void addEdge(int source, int dest){
        if(source > numOfVertices && dest > numOfVertices) {
            return;
        }
        // Count Edges when add them and avoid count an edge twice
        if(adjMx[source][dest] == 0 && adjMx[dest][source] == 0) {
            adjMx[dest][source] = 1;
            adjMx[source][dest] = 1;
            numOfEdges++;
        }
    }

    // Count Edges when delete them and avoid delete an edge twice
    public void deleteEdge(int source, int dest) {
        if(source > numOfVertices && dest > numOfVertices) {
            return;
        }
        if(adjMx[source][dest] == 1 && adjMx[dest][source] == 1) {
            adjMx[dest][source] = 0;
            adjMx[source][dest] = 0;
            numOfEdges--;
        }
    }

    /*
        Adjacency Matrix to Adjacency List
        Time Complexity: O(V^2)
    */
    public LinkedList<Integer>[] adjMx2AdjList() {
        // initialize Adjacency list; Index is 1 based
        adjList = new LinkedList[numOfVertices + 1];
        for(int i = 0; i < numOfVertices + 1; i++){
            adjList[i] = new LinkedList<>();
        }
        // Go through all row and col in Matrix
        for(int row = 1; row <= numOfVertices; row++){
            for(int col = 1; col <= numOfVertices; col++){
                if(adjMx[row][col] == 1 && row != col){
                    adjList[row].add(col);
                }
            }
        }
        return adjList;
    }

    /*
        Adjacency List to Incidence Matrix
        Time Complexity: O(V+E)
     */
    public int[][] adjList2IncMx() {
        // Initialize incidence matrix; Index is 1-based
        incMx = new int[numOfVertices + 1][numOfEdges + 1];

        // Avoid null Adjacency List
        if(adjList == null){
            return null;
        }
        int edgeCnt = 1;
        // Iterate the List
        for(int i = 1; i <= numOfVertices; i++) {
            // index j of LinkedList is 0-based
            for(int j = 0; j < adjList[i].size(); j++) {
                // Label the edge;
                // index i is source and adjList[i].get(j) is the destination
                if(adjList[i].get(j) > i) {
                    incMx[i][edgeCnt] = 1;
                    incMx[adjList[i].get(j)][edgeCnt] = 1;
                    edgeCnt++;
                }
            }
        }
        return incMx;
    }

    /*
     Incidence Matrix to Adjacency List
     Time Complexity: O(VE)
     */
    public LinkedList<Integer>[] incMx2AdjList() {
        // Initialize a new Adjacency List; Index is 1-based
        LinkedList<Integer> newAdjList[] = new LinkedList[numOfVertices + 1];
        for(int i = 0; i < numOfVertices + 1; i++){
            newAdjList[i] = new LinkedList<>();
        }

        // Iterate by Edge index first to find an edge
        for(int i = 1; i <= numOfEdges; i++){

            // vertices[] to store an edge
            int vertices[] = new int[2];

            // vCnt to label if the vertica is source or destination;
            // index 0 is source; index 1 is destination
            int vCnt = 0;

            for(int j = 1; j <= numOfVertices; j++) {
                // Store the edge in array
                if(incMx[j][i] == 1) {
                    vertices[vCnt] = j;
                    vCnt++;
                }
            }

            // Put the edge found in new Adjacency List
            if(vCnt > 0) {
                newAdjList[vertices[0]].add(vertices[1]);
            }
        }
        // return the new Adjacency List converted from Incidence Matrix
        return newAdjList;
    }

    public void printAdjMx(){
        System.out.println("\nThe Adjacency Matrix is :");
        System.out.print("\t");
        for(int i = 1; i <= numOfVertices; i++){
            System.out.print("[" + (char)('A' + i - 1) +"]\t");
        }
        System.out.println();
        for(int i = 1; i <= numOfVertices; i++) {
            System.out.print("[" + (char)('A' + i - 1) + "]\t");
            for (int j = 1; j <= numOfVertices; j++) {
                System.out.print(" " + adjMx[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public void printAdjList(){
        System.out.println("\nThe Adjacency List is :");
        for(int i = 1; i < adjList.length; i++){
            System.out.print("Vertical " + (char)('A' + i - 1) +": ");
            for(int j = 0; j < adjList[i].size(); j++) {
                System.out.print((char)('A' + adjList[i].get(j) - 1) + " ");
            }
            System.out.println();
        }
    }

    public void printIncMX(){
        System.out.println("\nThe Incidence Matrix is :");
        System.out.print("V\\E\t");
        for(int i = 1; i <= numOfEdges; i++){
            System.out.print("[" + i +"]\t");
        }
        System.out.print("\n");
        for(int i = 1; i <= numOfVertices; i++) {
            System.out.print("[" + i + "]\t");
            for (int j = 1; j <= numOfEdges; j++) {
                System.out.print(" " + incMx[i][j]+ " \t");
            }
            System.out.println();
        }
    }

    public void printNewAdjList(LinkedList<Integer> newList[]) {
        System.out.println("\nThe New Adjacency List is :");
        for (int i = 1; i < adjList.length; i++) {
            System.out.println("Vertice " + i + ": " + adjList[i]);
        }
    }
}
