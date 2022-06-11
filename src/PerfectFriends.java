import java.io.*;
import java.util.*;

public class PerfectFriends {

    static ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

    static class Edge {
        int v;
        int nbr;

        Edge(int v, int nbr) {
            this.v = v;
            this.nbr = nbr;
        }
    }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      ArrayList<Edge>[] graph = new ArrayList[n];

      for (int v = 0; v < n; v++) {
        graph[v] = new ArrayList<>();
     }

      for(int e=0;e<k;e++) {
          String[] parts = br.readLine().split(" ");
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);

          graph[v1].add(new Edge(v1, v2));
          graph[v2].add(new Edge(v2, v1));
      }

      boolean[] visited = new boolean[n];
      

      for(int i=0;i<k;i++) {
          

        if(visited[i] == false) {
            ArrayList<Integer> list = new ArrayList<>();
            components(graph, i, list, visited);

        }
      }
    //   System.out.print(comps);

      int sum=0;
      for(int i=0;i<comps.size()-1;i++) {
        for(int j=i+1;j<comps.size();j++) {
            sum+=comps.get(i).size() * comps.get(j).size();
        }
      }
      System.out.println(sum);



      
      // write your code here
   }

   static int count=0;
   public static void components(ArrayList<Edge>[] graph, int src, ArrayList<Integer> list, boolean[] visited) {
        if(list.contains(src) || visited[src] == true)
            return;
        
         visited[src] = true;
         list.add(src);

         for(Edge e : graph[src]) {
             if(visited[e.nbr] == false && !list.contains(e.nbr)) {
                 components(graph, e.nbr, list, visited);
                 count++;
                 if(!comps.contains(list))
                    comps.add(list);
             }
         }
   }



}
