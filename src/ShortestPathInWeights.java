import java.io.*;
import java.util.*;

public class ShortestPathInWeights {
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

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.wsf - o.wsf;
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

        int src = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> q = new PriorityQueue<>();

        q.add(new Pair(src, src + "", 0));

        while (q.size() > 0) {
            Pair rem = q.remove();

            if (visited[rem.v] == true)
                continue;
            visited[rem.v] = true;

            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }

        // for(int v=0;v<vtces;v++) {
        // if(visited[v] == false) {
        // shortestPath(graph, src, v, visited, src+"", 0);
        // System.out.println(v + " via " + spath + " @ " + spathwt);
        // spathwt = Integer.MAX_VALUE;
        // }

        // }
        // write your code here

    }

    // static String spath;
    // static Integer spathwt = Integer.MAX_VALUE;
    // public static void shortestPath(ArrayList<Edge>[] graph, int src, int dest,
    // boolean[] visited, String psf, int wsf) {

    // if(dest == src) {
    // if(wsf < spathwt) {
    // spathwt = wsf;
    // spath = psf;
    // }
    // return;
    // }
    // visited[src] = true;
    // for(Edge e: graph[src]) {
    // if(visited[e.nbr] == false) {
    // shortestPath(graph, e.nbr, dest, visited, psf+e.nbr, wsf+e.wt);
    // }
    // }
    // visited[src] = false;

    // }

}