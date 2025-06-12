package GraphDataStructure;
import java.util.*;
public class Graph {
    Map<Integer,Map<Integer,Integer>>  graph;

    public Graph(int v){
        graph = new HashMap<>();
        for(int i=1;i<=v;i++){
            graph.put(i,new HashMap<>());
        }
    }

    void addEdge(int v1,int v2, int w){
        graph.get(v1).put(v2,w);
        graph.get(v2).put(v1,w);
    }

    boolean containsEdge(int v1,int v2){
        return graph.get(v1).containsKey(v2);
    }

    boolean containsVertex(int v){
        return graph.containsKey(v);
    }

    int number_Of_Edge(){
        int sum=0;
        for(int i:graph.keySet()){
            sum+=graph.get(i).size();
        }
        return sum/2;
    }

    void removeEdge(int v1,int v2){
        graph.get(v1).remove(v2);
        graph.get(v2).remove(v1);
    }

    void removeVertex(int v){
        for(int i:graph.get(v).keySet()){
            graph.get(i).remove(v);
        }
        graph.remove(v);
    }

    void displayGraph(){
        for(int k:graph.keySet()){
            System.out.println(k+" : "+graph.get(k));
        }
    }
    //traversals in graph
    //BFS traversal
    public void bfs(){
        List<Integer>ans=bfs(graph);
        System.out.println(ans);
    }
    private List<Integer> bfs(Map<Integer,Map<Integer,Integer>> graph){
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.add(1);
        while(!q.isEmpty()){
            int v=q.poll();
            if(visited.contains(v))continue;
            ans.add(v);
            visited.add(v);
            for(int i:graph.get(v).keySet()){
                if(!visited.contains(i)){
                    //visited.add(i);
                    q.add(i);
                }
            }
        }
        return ans;
    }
    //dfs traversal
    public void dfs(){
        Set<Integer> visited=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        dfs(graph,visited,ans,1);
        System.out.println(ans);
    }
    private void dfs(Map<Integer,Map<Integer,Integer>> graph,Set<Integer> visited,List<Integer> ans,int depth){
        ans.add(depth);
        visited.add(depth);
        for(int v:graph.get(depth).keySet()){
            if(!visited.contains(v)){
                dfs(graph,visited,ans,v);
            }
        }
    }
}
