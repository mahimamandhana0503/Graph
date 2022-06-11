import java.io.*;
import java.util.*;

public class DFSIterative {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
      Stack<Integer> s = new Stack<>();

    //   for(int v=0;v<vtces;v++) {
    //       if(visited[v] == false) {
              bfs(graph, src, visited, s);
        //   }
    //   }

      // write your code here  
   }

   public static void bfs(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> s) {
       s.push(src);
        while(s.size() > 0) {

            int pop = s.pop();
           
            if(visited[pop] == true)
                continue;
            visited[pop] = true;
            System.out.println(pop);
            for(Edge e: graph[pop]) {
                if(visited[e.nbr] == false) {
                    s.push(e.nbr);
                }
            }
        }

       
   }
}