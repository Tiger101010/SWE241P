package MyGraph;

import java.util.*;

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

    public void addEdge(char source, char dest) {
        addEdge((int)(source - 'A' + 1), (int)(dest - 'A' + 1));
        return;
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

    // Adjacency Matrix to Adjacency List
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


    // Using queue to implement BFS
    public List bfs(char start){
        int source = (int)(start - 'A' + 1);
        List<Character> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[numOfVertices + 1];
        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()) {
            int cur = queue.peek();
            queue.poll();
            for(int i = 0; i < adjList[cur].size(); i++) {
                if(visited[adjList[cur].get(i)] == false) {
                    queue.add(adjList[cur].get(i));
                    visited[adjList[cur].get(i)] = true;
                }
            }
            ret.add((char)(cur + 'A' - 1));
        }

        return ret;
    }

    // Use Stack to implement DFS
    public List dfs(char start) {
        int source = (int) (start - 'A' + 1);
        List<Character> ret = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[numOfVertices + 1];

        stk.push(source);

        while (!stk.isEmpty()) {
            int cur = stk.pop();

            for (int i = adjList[cur].size() - 1; i >= 0; i--) {
                int nextVer = adjList[cur].get(i);
                if (visited[nextVer] == false) {
                    stk.push(nextVer);
                }
            }
            if(visited[cur] == false) {
                ret.add((char) (cur + 'A' - 1));
                visited[cur] = true;
            }
        }
        return ret;
    }

    // Use Recursion to implement DFS
    public List dfsRecursive(char start) {
        int source = (int) (start - 'A' + 1);
        List<Character> ret = new ArrayList<>();
        boolean[] visited = new boolean[numOfVertices + 1];
        dfsHelper(source, visited, ret);
        return ret;
    }

    private void dfsHelper(int start, boolean[] visited, List ret) {
        visited[start] = true;
        // System.out.print((char) (start + 'A' - 1) + " ");
        ret.add((char) (start + 'A' - 1));

        for(int i = 0; i < adjList[start].size(); i++) {
            int next = adjList[start].get(i);
            if(visited[next] == false) dfsHelper(next, visited, ret);
        }
    }
}
