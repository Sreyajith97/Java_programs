import java.util.*;

public class dfs {

    static class Graph{
        int V;
        LinkedList<Integer>adj[];
        Graph(int v){
            V=v;
            adj=new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList();
            }
        }
        void addEdge(int v,int w){
            adj[v].add(w);
        }
        void DFS(int s){
            boolean visited[] = new boolean[V];;
            Dfsutil(s,visited);
        }
        void Dfsutil(int s,boolean[] visited){
            visited[s]=true;
            System.out.print(s+" ");
            for(int n: adj[s]){
                if(!visited[n]){
                    Dfsutil(n,visited);
                }
            }
        }
    }
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println("Following is Depth First Traversal");
        g.DFS(2);    
    }
}
