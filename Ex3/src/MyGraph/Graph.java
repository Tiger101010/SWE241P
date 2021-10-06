package MyGraph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numOfVertices;
    private int numOfEdges;
    // adj mx
    private int adjMx[][];
    // adj list
    private LinkedList<Integer> adjList[];
    // inc mx
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
        if(adjMx[source][dest] == 0 && adjMx[dest][source] == 0) {
            adjMx[dest][source] = 1;
            adjMx[source][dest] = 1;
            numOfEdges++;
        }
    }

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

    // adj_mx_to_adj_list
    public LinkedList<Integer>[] adjMx2AdjList() {
        adjList = new LinkedList[numOfVertices + 1];
        for(int i = 0; i < numOfVertices + 1; i++){
            adjList[i] = new LinkedList<>();
        }
        for(int row = 1; row <= numOfVertices; row++){
            for(int col = 1; col <= numOfVertices; col++){
                if(adjMx[row][col] == 1 && row != col){
                    adjList[row].add(col);
                }
            }
        }
        return adjList;
    }

    // adj_list_to_inc_mx
    public int[][] adjList2IncMx() {
        incMx = new int[numOfVertices + 1][numOfEdges + 1];
        if(adjList == null){
            return null;
        }
        int edgeCnt = 1;
        for(int i = 1; i <= numOfVertices; i++) {
            for(int j = 0; j < adjList[i].size(); j++) {
                if(adjList[i].get(j) > i) {
                    incMx[i][edgeCnt] = 1;
                    incMx[adjList[i].get(j)][edgeCnt] = 1;
                    //System.out.println(incMx[i][edgeCnt]+" "+incMx[adjList[i].get(j)][edgeCnt]);
                    edgeCnt++;
                }
            }
        }
        return incMx;
    }

    // inc_mx_to_adj_list

    public LinkedList<Integer>[] incMx2AdjList() {
        LinkedList<Integer> newAdjList[] = new LinkedList[numOfVertices + 1];
        for(int i = 0; i < numOfVertices + 1; i++){
            newAdjList[i] = new LinkedList<>();
        }
        for(int i = 1; i <= numOfEdges; i++){
            int vertices[] = new int[2];
            int vCnt = 0;
            for(int j = 1; j <= numOfVertices; j++) {
                if(incMx[j][i] == 1) {
                    vertices[vCnt] = j;
                    vCnt++;
                }
            }
            if(vCnt > 0) {
                newAdjList[vertices[0]].add(vertices[1]);
            }
        }
        return newAdjList;
    }

    public void printAdjMx(){
        System.out.println("\nThe Adjacency Matrix is :");
        System.out.print("\t");
        for(int i = 1; i <= numOfVertices; i++){
            System.out.print("[" + i +"]\t");
        }
        System.out.println();
        for(int i = 1; i <= numOfVertices; i++) {
            System.out.print("[" + i + "]\t");
            for (int j = 1; j <= numOfVertices; j++) {
                System.out.print(" " + adjMx[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public void printList(){
        System.out.println("\nThe Adjacency List is :");
        for(int i = 1; i < adjList.length; i++){
            System.out.println("Vertice " + i +": " + adjList[i]);
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

    public void printNewIncMX(LinkedList<Integer> newList[]) {
        System.out.println("\nThe New Adjacency List is :");
        for (int i = 1; i < adjList.length; i++) {
            System.out.println("Vertice " + i + ": " + adjList[i]);
        }
    }
}
