package GraphDataStructure;
import java.util.*;
public class CycleDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edges[][]=new int[n][2];
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        CycleDetection cd = new CycleDetection();
        if(cd.isCycle(n,edges)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    boolean isCycle(int n,int[][] edges){
        Map<Integer,List<Integer> >map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> set = map.keySet();
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                if(dfs(i,-1,map,set))return true;
            }
        }
        return false;
    }
    boolean dfs(int i,int j,Map<Integer,List<Integer> >map,Set<Integer> set){
        set.add(i);
        for(int k:map.get(i)){
            if(k==j)continue;
            if(set.contains(k)){
                return true;
            }
            if(dfs(k,i,map,set)){
                return true;
            }
        }
        return false;
    }
}
