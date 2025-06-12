package GraphDataStructure;

public class GraphClient {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(1,2,3);
        graph.addEdge(2,3,4);
        graph.addEdge(3,4,2);
        graph.addEdge(4,5,6);
        graph.addEdge(5,6,1);
        graph.addEdge(6,7,4);
        graph.addEdge(1,4,5);
        graph.addEdge(5,7,8);

       // graph.displayGraph();
        graph.bfs();
        graph.dfs();
    }
}
