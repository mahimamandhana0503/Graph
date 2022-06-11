import java.io.*;
import java.util.*;

public class BarpatiteGraph {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   static class Pair {
       int v;
       int psf;
       int level;
       Pair(int v, int level) {
           this.v = v;
           this.level = level;
       }
   } 

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      
      int[] visited = new int[vtces];
      for(int v=0;v<vtces;v++)
      visited[v] = -1;

      for(int v=0;v<vtces;v++) {
          if(visited[v]==-1) {
              boolean bar = isBarpatite(graph, v, visited);
              if(bar == false) {
                  System.out.println("false");
                  return;
              }
          }
      }
      
      System.out.println("true");


      // write your code here
   }

   static ArrayDeque<Pair> q = new ArrayDeque<>();
   public static boolean isBarpatite(ArrayList<Edge>[] graph, int src, int[] visited) {

        q.add(new Pair(src, 0));
        while(q.size() > 0) {
            Pair rem = q.removeFirst();
            if(visited[rem.v] != -1) {
                if((visited[rem.level]==rem.level)) {
                    return true;
                } else 
                return false;
            }
            visited[rem.v] = rem.level;

            for(Edge e: graph[src]) {
                if(visited[e.nbr]==-1) {
                    q.add(new Pair(e.nbr, rem.level+1));
                }
            }
        }
       return true;
   }
}