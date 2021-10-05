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
            adjMx[dest][source] = 1;
            numOfEdges++;
        }
    }

    public void deleteEdge(int source, int dest) {
        if(source > numOfVertices && dest > numOfVertices) {
            return;
        }
        if(adjMx[source][dest] == 1 && adjMx[dest][source] == 1) {
            adjMx[dest][source] = 0;
            adjMx[dest][source] = 0;
            numOfEdges--;
        }
    }

    // adj_mx_to_adj_list
    public LinkedList<Integer>[] adjMx2AdjList() {
        adjList = new LinkedList[numOfVertices + 1];
        for(int row = 1; row <= numOfVertices; row++){
            for(int col = 1; col <= numOfVertices; col++){
                if(adjMx[row][col] == 1){
                    adjList[row].add(col);
                }
            }
        }
        return adjList;
    }

    // adj_list_to_inc_mx
    public int[][] adjList2IncMx() {
        incMx = new int[numOfVertices][numOfEdges];
        if(adjList != null){
            return null;
        }
        int edgeCnt = 1;
        for(int i = 1; i < numOfVertices / 2; i++) {
            for(int j = 0; j < adjList[i].size(); j++) {
                if(adjList[i].get(j) > i) {
                    incMx[i][edgeCnt] = 1;
                    incMx[adjList[i].get(j)][edgeCnt] = 1;
                    edgeCnt++;
                }
            }
        }
        return incMx;
    }

    // inc_mx_to_adj_list

    public LinkedList<Integer>[] incMx2AdjList() {
        LinkedList<Integer> newAdjList[] = new LinkedList[numOfVertices];
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
}
