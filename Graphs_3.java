import java.util.*;

//Cheapest Flight within k stops...............................................................

//public class Graphs_3 {
//
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
//    static void creatGraph(int flights[][], ArrayList<Edge> graph[]) {
//
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < flights.length; i++) {
//            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
//        }
//    }
//
//    static class Info {
//        int v;
//        int cost;
//        int stop;
//
//        Info(int v, int c, int s) {
//            this.v = v;
//            this.cost = c;
//            this.stop = s;
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public static int cheapestPath(int flights[][], int n, int src, int dest, int k) {
//
//        ArrayList<Edge> graph[] = new ArrayList[n];
//
//        creatGraph(flights, graph);
//        int dist[] = new int[graph.length];
//
//        for (int i = 0; i < dist.length; i++) {
//            if (i != src) {
//                dist[i] = Integer.MAX_VALUE;
//            }
//        }
//
//        Queue<Info> q = new LinkedList<>();
//
//        q.add(new Info(src, 0, 0));
//        while (!q.isEmpty()) {
//
//            Info curr = q.remove();
//            if (curr.stop > k) {
//                break;
//            }
//            for (int i = 0; i < graph[curr.v].size(); i++) {
//                Edge e = graph[curr.v].get(i);
//                int u = e.src;
//                int V = e.dest;
//                int W = e.wt;
//
//                if (curr.cost + W < dist[V] && curr.stop <= k) {
//                    dist[V] = curr.cost + W;
//                    q.add(new Info(V, dist[V], curr.stop + 1));
//                }
//            }
//        }
//        if (dist[dest] == Integer.MAX_VALUE) {
//            return -1;
//        } else {
//
//            return dist[dest];
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 4;
//        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
//        int src = 0;
//        int dest = 3;
//        int k = 1;
//        System.out.println(cheapestPath(flights, n, src, dest, k));
//    }
//}

//Connecting cities with minimum cost.....................................................

//TC same as prims algo
//public class Graphs_3 {
//
//    static class Edge implements Comparable<Edge>{
//        int dest;
//        int cost;
//        public Edge(int d, int c) { //constructor
//            this.dest = d;
//            this.cost = c;
//        }
//
//        @Override
//        public int compareTo(Edge e2) {
//            return this.cost - e2.cost; //ascending Order Sorting
//        }
//    }
//
//
//    public static int connectAllCities(int cities[][]) {
//        PriorityQueue<Edge> pq = new PriorityQueue<>(); //store edge info and sorting edges object
//        boolean vis[] = new boolean[cities.length];
//        int finalCost = 0;
//
//        pq.add(new Edge(0, 0)); //initially source to source
//        while(!pq.isEmpty()) {
//            Edge curr = pq.remove();
//            if(!vis[curr.dest]) {
//                vis[curr.dest] = true;
//                finalCost += curr.cost;
//
//                //loops for NeighBours
//                for(int i=0; i<cities[curr.dest].length; i++) {
//                    if(cities[curr.dest][i] != 0) {
//                        pq.add(new Edge(i, cities[curr.dest][i]));
//                    }
//                }
//            }
//        }
//        return finalCost;
//    }
//    public static void main(String args[]) {
//        int cities[][] = {{0, 1, 2, 3, 4},
//                {1, 0, 5, 0, 7},
//                {2, 5, 0, 6, 0},
//                {3, 0, 6, 0, 0},
//                {4, 7, 0, 0, 0}};
//        System.out.println(connectAllCities(cities));
//    }
//}

//Disjoint Sets...................................................................

//public class Graphs_3 {
//    static int n = 7;
//    static int par[] = new int[n];
//    static int rank[] = new int[n];
//
//    public static void initialization() { //parent initialization
//        for(int i=0; i<par.length; i++) {
//            par[i] = i;
//        }
//    }
//
//    public static int find(int x) { //final leader  find.........
//        if(x == par[x]) {
//            return x;
//        }
//
//        //Path Compression Optimization.........
//        return par[x] = find(par[x]); //update leader in array at runtime save time
//    }
//
//    public static void union(int a, int b) {  //union........
//        int parA = find(a);
//        int parB = find(b);
//
//        if(rank[parA] == rank[parB]) {   // A == B
//            par[parB] = parA;
//            rank[parA]++;
//        }
//        else if(rank[parA] < rank[parB]) {  // A -> B
//            par[parA] = parB;
//        }
//        else {
//            par[parB] = parA;  // B -> A
//        }
//    }
//    public static void main(String args[]) {
//        initialization();
//        System.out.println(find(3));
//        union(1, 3);
//        System.out.println(find(3));
//        union(2, 4);
//        union(3, 6);
//        union(1, 4);
//        System.out.println(find(3));
//        System.out.println(find(4));
//        union(1, 5);
//    }
//}


//Kruskals algorithm.............................................................

//public class Graphs_3 {
//
//    static class Edge implements Comparable<Edge>{
//        int src;
//        int dest;
//        int wt;
//
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.wt = w;
//        }
//
//        @Override
//        public int compareTo(Edge e2) {
//            return this.wt - e2.wt; //ascending order
//        }
//    }
//    //*****************Union & find Code********************************/
//    static int n = 4; //vertex
//    static int par[] = new  int[n];
//    static int rank[] = new int[n];
//
//    public static void initialization() {
//        for(int i=0; i<par.length; i++) {
//            par[i] = i;
//        }
//    }
//
//    public static int find(int x) { //find.........
//        if(x == par[x]) {
//            return x;
//        }
//        return par[x] = find(par[x]);
//    }
//
//    public static void union(int a, int b) { //union..........
//        int parA = find(a);
//        int parB = find(b);
//
//        //3 Conditions
//        if(rank[parA] == rank[parB]) {
//            //A == B
//            par[parB] = parA;
//            rank[parA]++;
//        }
//        else if(rank[parA] < rank[parB]) {
//            // A -> B
//            par[parA] = parB;
//        }
//        else {
//            //  B -> A
//            par[parB] = parA;
//        }
//    }
//
//    //CreateGraph => EdgeList Type of Graph Creation
//    public static void createGraph(ArrayList<Edge> edges) {
//        edges.add(new Edge(0, 1, 10));
//        edges.add(new Edge(0, 2, 15));
//        edges.add(new Edge(0, 3, 30));
//        edges.add(new Edge(1, 3, 40));
//        edges.add(new  Edge(2, 3, 50));
//    }
//
//
//    public static void kruskalAlgoMST(ArrayList<Edge> edges, int V) {
//        initialization();
//        Collections.sort(edges); //ascending order O(ElogE)
//        int mstCost = 0; //final cost
//        int count = 0;
//        for(int i=0; count<V-1; i++) { //O(V)
//            Edge e = edges.get(i);
//            //Cycle Detection
//            int parA = find(e.src); // a = src
//            int parB = find(e.dest); // b = dest
//
//            if(parA != parB) { //cycle check
//                union(e.src, e.dest);
//                mstCost += e.wt; //include edge weight
//                count++;
//            }
//        }
//        System.out.println(mstCost);
//    }
//    public static void main(String args[]) {
//        int V = 4;
//        ArrayList<Edge> edges = new ArrayList<>();
//        createGraph(edges);
//        kruskalAlgoMST(edges, V); //o/p 55
//    }
//}


//Flood fill algorithm.............................................................

//public class Graphs_3 {
//
//    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
//
//        boolean vis[][] = new boolean[image.length][image[0].length];
//
//        helper(image, sr, sc, color, vis, image[sr][sc]);
//        return image;
//    }
//
//    public static void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgCol) {
//        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
//            return;
//        }
//        image[sr][sc] = color;
//        helper(image, sr + 1, sc, color, vis, orgCol);
//        helper(image, sr - 1, sc, color, vis, orgCol);
//        helper(image, sr, sc + 1, color, vis, orgCol);
//        helper(image, sr, sc - 1, color, vis, orgCol);
//    }
//
//    static void printImage(int image[][]) {
//        for (int i = 0; i < image.length; i++) {
//            for (int j = 0; j < image[0].length; j++) {
//                System.out.print(image[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        int image[][] = {
//                { 1, 1, 1 },
//                { 1, 1, 0 },
//                { 1, 0, 1 }
//        };
//        int sr = 1;
//        int sc = 1;
//        int color = 2;
//        printImage(image);
//        floodFill(image, sr, sc, color);
//        System.out.println("Output");
//        printImage(image);
//
//    }
//}

//KosaRaju algorithm...............................................................

//public class Graphs_3 {
//    static class Edge {
//        int src;
//        int dst;
//
//        Edge(int s, int d) {
//            this.src = s;
//            this.dst = d;
//        }
//    }
//
//    static void creatGraph(ArrayList<Edge>[] graph) {
//
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        graph[0].add(new Edge(0, 2));
//        graph[0].add(new Edge(0, 3));
//
//        graph[1].add(new Edge(1, 0));
//
//        graph[2].add(new Edge(2, 1));
//
//        graph[3].add(new Edge(3, 4));
//
//    }
//
//    static void DFS(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
//        vis[curr] = true;
//        System.out.print(curr + " ");
//        for (int i = 0; i < graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            if (!vis[e.dst]) {
//                DFS(graph, e.dst, vis);
//            }
//        }
//    }
//
//    //step 1
//    static void topSortUtil(ArrayList<Edge>[] graph, boolean vis[], Stack<Integer> s, int curr) {
//        vis[curr] = true;
//        for (int i = 0; i < graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            if (!vis[e.dst]) {
//                topSortUtil(graph, vis, s, e.dst);
//            }
//        }
//        s.push(curr);
//    }
//
//    @SuppressWarnings("unchecked")
//    static void kosaRaju(ArrayList<Edge> graph[], int V) {
//        boolean vis[] = new boolean[graph.length];
//        Stack<Integer> s = new Stack<>();
//        for (int i = 0; i < graph.length; i++) {
//            if (!vis[i]) {
//                topSortUtil(graph, vis, s, i);
//            }
//        }
//
//        // step 2 transpose
//        ArrayList<Edge> tranpose[] = new ArrayList[V];
//        for (int i = 0; i < tranpose.length; i++) {
//            vis[i] = false;
//            tranpose[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < graph.length; i++) {
//            for (int j = 0; j < graph[i].size(); j++) {
//                Edge e = graph[i].get(j); // e.src(i) -> e.dest
//                tranpose[e.dst].add(new Edge(e.dst, e.src)); //reverse e.dest -> e.src(i)
//            }
//        }
//        // step 3
//        //perform dfs remove node
//        while (!s.isEmpty()) {
//            int curr = s.pop();
//            if (!vis[curr]) {
//
//                DFS(tranpose, curr, vis);
//                System.out.println();
//            }
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        int V = 5;
//        ArrayList<Edge> graph[] = new ArrayList[V];
//        creatGraph(graph);
//        kosaRaju(graph, V);
//    }
//}


//Tarjan Algorithm.........................................................

//public class Graphs_3 {
//
//    static class Edge{
//        int src;
//        int dest;
//        Edge(int s, int d){
//            this.src = s;
//            this.dest = d;
//        }
//    }
//
//    public static void creatGraph(ArrayList<Edge> graph[]){
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1));
//        graph[0].add(new Edge(0, 2));
//        graph[0].add(new Edge(0, 3));
//
//        graph[1].add(new Edge(1, 2));
//        graph[1].add(new Edge(1, 0));
//
//        graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 1));
//
//        graph[3].add(new Edge(3, 0));
//        graph[3].add(new Edge(3, 4));
//        graph[3].add(new Edge(3, 5));
//
//        graph[4].add(new Edge(4, 3));
//        graph[4].add(new Edge(4, 5));
//
//        graph[5].add(new Edge(5, 3));
//        graph[5].add(new Edge(5, 4));
//
//
//
//    }
//
//    //algorithm implemented in this
//    static void DFS(ArrayList<Edge> graph[],int curr, int par,int dt[], int low[], int time, boolean vis[]){
//        vis[curr] = true;
//        dt[curr] = low[curr] = ++time;
//
//        for (int i = 0; i < graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            int neigh = e.dest;
//            //unvisited neigbhour
//            if(neigh == par){
//                continue;
//            }else if(!vis[neigh]){
//                DFS(graph, neigh, curr, dt, low, time, vis);
//                low[curr] = Math.min(low[curr], low[neigh]);
//
//                if(dt[curr] < low[neigh]){
//                    System.out.println("bridge :" + curr + " ---- " + neigh);
//                }
//            }else{ //visited neigbhour
//                low[curr] = Math.min(low[curr], dt[neigh]);
//
//            }
//        }
//    }
//    static void tarjanBridge(ArrayList<Edge> graph[], int V){
//        int dt[] = new int[V]; //discovery time
//        int low[] = new int[V]; //lowest discovery time
//        int time = 0;
//        boolean vis[] = new boolean[V];
//        for (int i = 0; i < V ; i++) {
//            if(!vis[i]){
//                DFS(graph, i, -1, dt, low, time, vis);
//            }
//        }
//    }
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        int V = 6;
//        ArrayList<Edge> graph[] = new ArrayList[V];
//        creatGraph(graph);
//        tarjanBridge(graph, V);
//
//    }
//}


//Articulation Point O(V+E)........................................................

public class Graphs_3{

    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));

    }

    static void DFS(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], int time, boolean vis[],
                    boolean arp[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                DFS(graph, neigh, curr, dt, low, time, vis, arp);
                low[curr] = Math.min(low[curr], low[neigh]);

                if (par != -1 && dt[curr] <= low[neigh]) {
                    // System.out.println("point :" + curr);
                    arp[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);

            }
        }
        if (par == -1 && children > 0) {
            // System.out.println("point " + curr);
            arp[curr] = true;
        }
    }

    static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean arp[] = new boolean[V]; //articulation point
        int time = 0;
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                DFS(graph, i, -1, dt, low, time, vis, arp);
            }
        }
        for (int i = 0; i < arp.length; i++) { //printing AP
            if (arp[i]) {
                System.out.println(" Articulation point : " + i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        creatGraph(graph);
        tarjanBridge(graph, V);

    }
}