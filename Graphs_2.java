import java.util.*;

//Bipartite Graph O(V+E)...................................................................

//public class Graphs_2 {
//    static class Edge {
//        int src;
//        int dest;
//        public Edge(int s, int d) {
//            this.src = s;
//            this.dest = d;
//        }
//    }
//
//    //Create graph
//    public static void createGraph(ArrayList<Edge>[] graph) {
//        //null ArrayList -> Empty ArrayList
//        for(int i=0; i<graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
//
//        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 3));
//
//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 4));
//
//        graph[3].add(new Edge(3, 1));
//        //graph[3].add(new Edge(3, 4));
//
//        graph[4].add(new Edge(4, 2));
//        //graph[4].add(new Edge(4, 3));
//    }
//
//    public static boolean isBipartite(ArrayList<Edge>[] graph) {
//        int color[] = new int[graph.length];
//        for(int i=0; i<color.length; i++) {
//            color[i] = -1; //No Color
//        }
//        Queue<Integer> q = new LinkedList<>();
//        for(int i=0; i<graph.length; i++) {
//            if(color[i] == -1) { //BFS if we have separated graph we check for every graph
//                q.add(i);
//                color[i] = 0; //yellow
//                while(!q.isEmpty()) { //BFS check for single graph
//                    int curr = q.remove();
//                    for(int j=0; j<graph[curr].size(); j++) {
//                        Edge e = graph[curr].get(j); //e.dest -> neighbor
//                        if(color[e.dest] == -1) { //apply color for next node check below condition
//                            int nextColor = color[curr] == 0 ? 1 : 0; //apply color
//                            color[e.dest] = nextColor;
//                            q.add(e.dest);
//                        } else if(color[e.dest] == color[curr]) { //both have same color
//                            return false; //Same Colors -> Not Bipartite
//                        }
//                    }
//                }
//            }
//        }
//        return true; //bipartite
//    }
//    public static void main(String args[]) {
//        int V = 5;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
//        System.out.println(isBipartite(graph));
//
//        //If Graph does'nt have cycle its by default Bipartite
//    }
//}


//Topological Sorting O(V+E) O(V) extra for storing element in stack............................................................

//public class Graphs_2 {
//
//    static class Edge {
//        int src;
//        int dest;
//        public Edge(int s,int d) {
//            this.src = s;
//            this.dest = d;
//        }
//    }
//
//    public static void createGraph(ArrayList<Edge>[] graph) {
//        for(int i=0; i<graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[2].add(new Edge(2, 3));
//        graph[3].add(new Edge(3, 1));
//        graph[4].add(new Edge(4, 0));
//        graph[4].add(new Edge(4, 1));
//        graph[5].add(new Edge(5, 0));
//        graph[5].add(new Edge(5, 2));
//    }
//
//
//    public static void topoLogicalSorting(ArrayList<Edge>[] g) {
//        boolean vis[] = new boolean[g.length];
//        Stack<Integer> s = new Stack<>(); //implicit stack
//        for(int i=0; i<g.length; i++) {
//            if(!vis[i]) {
//                topoLogicalSortingUtil(g, i, vis, s); //modified DFS
//            }
//        }
//        while(!s.isEmpty()) { //remove element till stack empty and then print
//            System.out.print(s.pop()+" ");
//        }
//    }
//
//    public static void topoLogicalSortingUtil(ArrayList<Edge>[] g, int curr, boolean vis[], Stack<Integer> s) {
//        vis[curr] = true;
//        for(int i=0; i<g[curr].size(); i++) {
//            Edge e = g[curr].get(i);
//            if(!vis[e.dest]) { //neighbour not visited
//                topoLogicalSortingUtil(g, e.dest, vis, s);
//            }
//        }
//        s.push(curr); //stored element in topological order
//    }
//    public static void main(String args[]) {
//        int V = 6;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] g = new ArrayList[V];
//        createGraph(g);
//        topoLogicalSorting(g); //o/p 5 4 2 3 1 0
//    }
//}


//Topological sort Using (BFS) Kahn's Algorithm.............................................

//public class Graphs_2 {
//
//    static class Edge {
//        int src;
//        int dest;
//        public Edge(int s, int d) {
//            this.src = s;
//            this.dest = d;
//        }
//    }
//
//    static void createGraph(ArrayList<Edge>[] g) {
//        for(int i=0; i<g.length; i++) {
//            g[i] = new ArrayList<>();
//        }
//        g[2].add(new Edge(2, 3));
//        g[3].add(new Edge(3, 1));
//        g[4].add(new Edge(4, 0));
//        g[4].add(new Edge(4, 1));
//        g[5].add(new Edge(5, 0));
//        g[5].add(new Edge(5, 2));
//    }
//
//
//    //Helper Function()
//    public static void calculateIndeg(ArrayList<Edge>[] g, int[] Indeg) { //indegree calculation
//        for(int i=0; i<g.length; i++) {
//            for(int j=0; j<g[i].size(); j++) {
//                Edge e = g[i].get(j);
//                Indeg[e.dest]++;
//            }
//        }
//    }
//    //Topological Sort using BFS -> Kahn's Algorithm
//    public static void topSortBFS(ArrayList<Edge>[] g) {
//        int inDeg[] = new int[g.length];
//        calculateIndeg(g, inDeg);
//        Queue<Integer> q = new LinkedList<>();
//        for(int i=0; i<inDeg.length; i++) {
//            if(inDeg[i] == 0) {
//                q.add(i);
//            }
//        }
//        //bfs.......
//        while(!q.isEmpty()) {
//            int curr = q.remove();
//            System.out.print(curr+" "); //printing Topological Sort Order
//            //Calling for neighBors
//            for(int i=0; i<g[curr].size(); i++) {
//                Edge e = g[curr].get(i);
//                inDeg[e.dest]--;
//                if(inDeg[e.dest] == 0) {
//                    q.add(e.dest);
//                }
//            }
//
//        }
//        System.out.println();
//    }
//    public static void main(String args[]) {
//        int V = 6;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
//        topSortBFS(graph);
//    }
//}

//All path from Source to Destination........................................................


//Time Complexity = 0(V^v) = Exponential TC -> Not Effeicient
//public class Graphs_2 {
//    static class Edge {
//        int src;
//        int dest;
//        public Edge(int s, int d) {
//            this.src = s;
//            this.dest = d;
//        }
//    }
//
//    static void createGraph(ArrayList<Edge>[] g) {
//        for(int i=0; i<g.length; i++) {
//            g[i] = new ArrayList<>();
//        }
//        g[0].add(new Edge(0, 3));
//        g[2].add(new Edge(2, 3));
//        g[3].add(new Edge(3, 1));
//        g[4].add(new Edge(4, 0));
//        g[4].add(new Edge(4, 1));
//        g[5].add(new Edge(5, 0));
//        g[5].add(new Edge(5, 2));
//    }
//
//
//    //All Paths from source to destination
//    public static void printAllPaths(ArrayList<Edge>[] g, int src, int dest, String path) {
//        //if I am source and I am Destination also
//        if(src == dest) {
//            System.out.println(path+dest);
//        }
//
//        //Call for NeighBours
//        for(int i=0; i<g[src].size(); i++) {
//            Edge e = g[src].get(i);
//            printAllPaths(g, e.dest, dest, path+src);
//        }
//    }
//    public static void main(String args[]) {
//        int V = 6;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] g =  new ArrayList[V];
//        createGraph(g);
//        int src = 5, dest = 1;
//        printAllPaths(g, src, dest, "");
//        //o/p
//        // 5031
//        //5231
//    }
//}


//Dijkshtras Algorithm...........................................................

//To find shortest distance on the basis of weight of the edges
//public class Graphs_2 {
//    static class Edge {
//        int src;
//        int dest;
//        int wt;
//
//        Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//    }
//
//    static void creatGraph(ArrayList<Edge> graph[]) {
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1, 2));
//        graph[0].add(new Edge(0, 2, 4));
//
//        graph[1].add(new Edge(1, 3, 7));
//        graph[1].add(new Edge(1, 2, 1));
//
//        graph[2].add(new Edge(2, 4, 3));
//
//        graph[3].add(new Edge(3, 5, 1));
//
//        graph[4].add(new Edge(4, 3, 2));
//        graph[4].add(new Edge(4, 5, 5));
//    }
//
//    static class Pair implements Comparable<Pair> {
//        int n;
//        int path;
//
//        Pair(int n, int p) {
//            this.n = n;
//            this.path = p;
//        }
//
//        @Override
//        public int compareTo(Pair p2) {
//            return this.path - p2.path;
//        }
//    }
//
//    static void dijkstra(ArrayList<Edge> graph[], int src) {
//        int dist[] = new int[graph.length];
//        boolean vis[] = new boolean[graph.length];
//        for (int i = 0; i < dist.length; i++) {
//            if (i != src) {
//                dist[i] = Integer.MAX_VALUE;// +infinity
//            }
//        }
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        pq.add(new Pair(src, 0));
//
//        while (!pq.isEmpty()) {
//            Pair curr = pq.remove();
//            if (!vis[curr.n]) {
//                vis[curr.n] = true;
//                for (int i = 0; i < graph[curr.n].size(); i++) {
//                    Edge e = graph[curr.n].get(i);
//                    int u = e.src;
//                    int v = e.dest;
//                    int wt = e.wt;
//                    if (wt + dist[u] < dist[v]) {
//                        dist[v] = wt + dist[u];
//                        pq.add(new Pair(v, dist[v]));
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < dist.length; i++) {
//            System.out.print( dist[i]+ " ");
//        }
//        System.out.println();
//
//    }
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        int v = 6;
//        ArrayList<Edge> graph[] = new ArrayList[v];
//        creatGraph(graph);
//        int src = 0;
//        dijkstra(graph, src);
//
//    }
//}

//Bellman Ford Algorithm............................................................

//Time Complexity = 0(V*E)........
//public class Graphs_2 {
//    static class Edge {
//        int src;
//        int dest;
//        int wt;
//
//        Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//    }
//
//    static void creatGraph(ArrayList<Edge> graph[]) {
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1, 2));
//        graph[0].add(new Edge(0, 2, 4));
//
//        graph[1].add(new Edge(1, 2, -4));
//
//        graph[2].add(new Edge(2, 3, 2));
//
//        graph[3].add(new Edge(3, 4, 4));
//
//        graph[4].add(new Edge(4, 1, -1));
//    }
//
//    static void bellmanford(ArrayList<Edge> graph[], int src){
//        int dist[] = new int[graph.length];
//        for (int i = 0; i < dist.length; i++) {
//            if(i != src){
//                dist[i] = Integer.MAX_VALUE;
//            }
//        }
//
//        int v = graph.length;
//        //O(V)
//        for (int i = 0; i < v-1; i++) {
//            //O(E)
//            for (int j = 0; j < graph.length; j++) {
//                for (int j2 = 0; j2 < graph[j].size(); j2++) {
//                    Edge e = graph[j].get(j2);
//                    int V = e.dest;
//                    int U = e.src;
//                    int wt = e.wt;
//                    if(dist[U] != Integer.MAX_VALUE && dist[V] > dist[U] + wt){
//                        dist[V] = dist[U] + wt;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < dist.length; i++) {
//            System.out.print(dist[i]+ " " );
//        }
//    }
//
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        int v = 5;
//        ArrayList<Edge> graph[] = new ArrayList[v];
//        creatGraph(graph);
//        int src = 0;
//        bellmanford(graph, src);
//
//    }
//}

//modification that store only edge info it is also work in same time complexity...........

//public class Graphs_2 {
//    static class Edge {
//        int src;
//        int dest;
//        int wt;
//
//        Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//    }
//
//    static void creatGraph(ArrayList<Edge> graph) {
//
//        graph.add(new Edge(0, 1, 2));
//        graph.add(new Edge(0, 2, 4));
//
//        graph.add(new Edge(1, 2, -4));
//
//        graph.add(new Edge(2, 3, 2));
//
//        graph.add(new Edge(3, 4, 4));
//
//        graph.add(new Edge(4, 1, -1));
//    }
//
//    static void bellmanford(ArrayList<Edge> graph, int src, int v) {
//        int dist[] = new int[v];
//        for (int i = 0; i < dist.length; i++) {
//            if (i != src) {
//                dist[i] = Integer.MAX_VALUE;
//            }
//        }
//
//        for (int i = 0; i < v - 1; i++) {
//            for (int j = 0; j < graph.size(); j++) {
//                Edge e = graph.get(j);
//                int V = e.dest;
//                int U = e.src;
//                int wt = e.wt;
//                if (dist[U] != Integer.MAX_VALUE && dist[V] > dist[U] + wt) {
//                    dist[V] = dist[U] + wt;
//                }
//            }
//        }
//        for (int i = 0; i < dist.length; i++) {
//            System.out.print(dist[i]+ " ");
//        }
//    }
//
//    public static void main(String[] args) {
//        int v = 5;
//        ArrayList<Edge> graph = new ArrayList<>();
//        creatGraph(graph);
//        int src = 0;
//        bellmanford(graph, src, v);
//
//    }
//}

//Prims algorithm................................................................

public class Graphs_2 {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void creatGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; //ascending order
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0; //MST Total weight
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt)); //add neighbour
                }
            }

        }
        System.out.println("the final (min) cost is : " + finalCost);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creatGraph(graph);
        prims(graph);

    }
}