import java.util.*;


//Basic of Graph Adjacency List...............................
//public class Graphs{
//
//    static class Edge {
//        int src;
//        int dest;
//        int weight;
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.weight = w;
//        }
//    }
//    public static void main(String args[]) {
//        int V = 5; //total node
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] graph  = new ArrayList[V]; // null ArrayList -> empty ArrayList
//
//        //Converting null ArrayList to empty ArrayList
//        for(int i=0; i<V; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        //Storing Values as Adjacency List
//
//        // 0 th vertix
//        graph[0].add(new Edge(0, 1, 5));
//
//        // 1 st vertix
//        graph[1].add(new Edge(1, 0, 5));
//        graph[1].add(new Edge(1, 2, 1));
//        graph[1].add(new Edge(1, 3, 3));
//
//        //2 nd vertix
//        graph[2].add(new Edge(2, 1, 1));
//        graph[2].add(new Edge(2, 3, 1));
//        graph[2].add(new Edge(2, 4, 2));
//
//        //3 rd vertix
//        graph[3].add(new Edge(3, 1, 3));
//        graph[3].add(new Edge(3, 2, 1));
//
//        //4 rt vertix
//        graph[4].add(new Edge(4, 2, 2));
//
//
//        //for storing neighbours info of particular node e.g 2's NeighBour
//        for(int i=0; i<graph[2].size(); i++) {
//            Edge e = graph[2].get(i); //src,dest,weight
//            System.out.print(e.dest + " "); // o/p 1 3 4
//        }
//
//    }
//}


//Graph Traversal BFS and DFS........................................................

//public class Graphs {
//    static class Edge {
//        int src;
//        int dest;
//        int weight;
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.weight = w;
//        }
//    }
//    static void createGraph(ArrayList<Edge> graph[]) {
//        for (int i = 0; i < graph.length; i++) {    // null ArrayList to Empty ArrayList
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1, 1));
//        graph[0].add(new Edge(0, 2, 1));
//
//        graph[1].add(new Edge(1, 0, 1));
//        graph[1].add(new Edge(1, 3, 1));
//
//        graph[2].add(new Edge(2, 0, 1));
//        graph[2].add(new Edge(2, 4, 1));
//
//        graph[3].add(new Edge(3, 1, 1));
//        graph[3].add(new Edge(3, 4, 1));
//        graph[3].add(new Edge(3, 5, 1));
//
//        graph[4].add(new Edge(4, 2, 1));
//        graph[4].add(new Edge(4, 3, 1));
//        graph[4].add(new Edge(4, 5, 1));
//
//        graph[5].add(new Edge(5, 3, 1));
//        graph[5].add(new Edge(5, 4, 1));
//        graph[5].add(new Edge(5, 6, 1));
//
//        graph[5].add(new Edge(6, 5, 1));
//    }
//
//    //BFS O(V+E) and for Matrix O(v^2)................................................
//
//    public static void bfs(ArrayList<Edge>[] graph) {
//        Queue<Integer> q = new LinkedList<>();
//        boolean vis[] = new boolean[graph.length];
//        q.add(0); //Source //do not need to add each edge at first
//
//        while(!q.isEmpty()) {
//            int curr = q.remove();
//            if(!vis[curr]) {    //Visit curr
//                System.out.print(curr+" ");
//                vis[curr] = true;
//                for(int i=0; i<graph[curr].size(); i++) {
//                    Edge e = graph[curr].get(i);
//                    q.add(e.dest); // adding source neighbors to queue Means next Vertices
//                }
//            }
//        }
//    }
//
//    //DFS.....................................................................
//    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
//        //visited
//        System.out.print(curr+" ");
//        vis[curr] = true;
//
//        for(int i=0; i<graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            if(!vis[e.dest]) {
//                dfs(graph, e.dest, vis);
//            }
//        }
//    }
//
//    //Problem 1 = hasPath() solve using dfs...................
//    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
//        //Corner Case
//        if(src == dest) {  // When my src and dest is equal so I don't have to go any where
//            return true;
//        }
//        vis[src] = true;
//        for(int i=0; i<graph[src].size(); i++) {
//            Edge e = graph[src].get(i);  // e.dest == neighBor
//            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//            int V = 7;
//            ArrayList<Edge>[] graph = new ArrayList[V];
//            createGraph(graph);
//            bfs(graph); //o/p 0 1 2 3 4 5 6
//            System.out.println();
//            dfs(graph,0,new boolean[V]); //o/p 0 1 3 4 2 5 6
//            System.out.println();
//            System.out.println(hasPath(graph,0,7,new boolean[V]));
//
//    }
//}

//Connected Component.............................................................

//public class Graphs {
//
//    static class Edge {
//        int src;
//        int dest;
//        int weight;
//        public Edge(int s, int d, int w) {
//            this.src = s;
//            this.dest = d;
//            this.weight = w;
//        }
//    }
//
//    public static void createGraph(ArrayList<Edge> graph[]) {
//        for(int i=0; i<graph.length; i++) {    // null ArrayList to Empty ArrayList
//            graph[i] = new ArrayList<>();
//        }
//
//        graph[0].add(new Edge(0, 1, 1));
//        graph[0].add(new Edge(0, 2, 1));
//
//        graph[1].add(new Edge(1, 0, 1));
//        graph[1].add(new Edge(1, 3, 1));
//
//        graph[2].add(new Edge(2, 0, 1));
//        graph[2].add(new Edge(2, 4, 1));
//
//        graph[3].add(new Edge(3, 1, 1));
//        graph[3].add(new Edge(3, 4, 1));
//        graph[3].add(new Edge(3, 5, 1));
//
//        graph[4].add(new Edge(4, 2, 1));
//        graph[4].add(new Edge(4, 3, 1));
//        graph[4].add(new Edge(4, 5, 1));
//
//        graph[5].add(new Edge(5, 3, 1));
//        graph[5].add(new Edge(5, 4, 1));
//        graph[5].add(new Edge(5, 6, 1));
//
//        graph[6].add(new Edge(6, 5, 1));
//    }
//
//    public static void bfs(ArrayList<Edge>[] graph) {
//        boolean vis[] = new boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            if(!vis[i]) {
//                bfsUtil(graph, vis);
//            }
//        }
//    }
//    //BFS
//    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(0); //Source //do not need to add each edge at first
//
//        while(!q.isEmpty()) {
//            int curr = q.remove();
//            if(!vis[curr]) {    //Visit curr
//                System.out.print(curr+" ");
//                vis[curr] = true;
//                for(int i=0; i<graph[curr].size(); i++) {
//                    Edge e = graph[curr].get(i);
//                    q.add(e.dest); // adding source neighbors to queue Means next Vertices
//                }
//            }
//        }
//    }
//
//
//    public static void dfs(ArrayList<Edge>[] graph) {
//        boolean vis[] = new boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            dfsUtil(graph, i, vis);
//        }
//    }
//
//    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
//        //visited
//        System.out.print(curr+" ");
//        vis[curr] = true;
//
//        for(int i=0; i<graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            if(!vis[e.dest]) {
//                dfsUtil(graph, e.dest, vis);
//            }
//        }
//    }
//
//
//
//    public static void main(String args[]) {
//        int V = 7;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
//        bfs(graph);
//        System.out.println();
//        dfs(graph);
//
//    }
//
//}

//Cycle detection...............................................................

//undirected...................................

//Time Complexity -> 0(V+E)
//public class Graphs {
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
//    public static void createGraph(ArrayList<Edge>[] graph) {
//        //null ArrayList -> Empty Arraylist
//        for(int i=0; i<graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph[0].add(new Edge(0, 1));
//        //graph[0].add(new Edge(0, 2));
//        graph[0].add(new Edge(0, 3));
//
//        graph[1].add(new Edge(1, 0));
//        graph[1].add(new Edge(1, 2));
//
//        //graph[2].add(new Edge(2, 0));
//        graph[2].add(new Edge(2, 1));
//
//        graph[3].add(new Edge(3, 0));
//        graph[3].add(new Edge(3, 4));
//
//        graph[4].add(new Edge(4, 3));
//
//    }
//
//    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
//        vis[curr] = true;
//        for(int i=0; i<graph[curr].size(); i++) {
//            Edge e = graph[curr].get(i);
//            //Case 3................
//            if(!vis[e.dest]) {
//                if(detectCycleUtil(graph, vis, e.dest, curr))
//                    return true; //Case 3 cycle exist
//            }
//            //Case 1...............
//            else if(vis[e.dest] && e.dest != par) {
//                return true;
//            }
//            //Case 2 here parent and neighbour is same node = do nothing -> Continue...............
//        }
//        return false; //not exist
//    }
//
//    //DetectCycle()
//    public static boolean detectCycle(ArrayList<Edge>[] graph) {
//        boolean vis[] = new boolean[graph.length];
//        for(int i=0; i<graph.length; i++) {
//            if(!vis[i]) {
//                if(detectCycleUtil(graph, vis, i, -1)) { //start node parent is -1
//                    return true; // Cycle exists in one of the parts
//                }
//            }
//        }
//        return false;
//    }
//
//
//    public static void main(String args[]) {
//        int V = 5;
//        @SuppressWarnings("unchecked")
//        ArrayList<Edge>[] graph = new ArrayList[V];
//        createGraph(graph);
//        System.out.println(detectCycle(graph));
//    }
//}

//Directed........................

//TC = (V+E)
public class Graphs {
    static class Edge {
        int src;
        int dest;
        public Edge(int s,int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) { //TRUE - no cycle
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //Graph 1 true
//        graph[0].add(new Edge(0, 2));
//        graph[1].add(new Edge(1, 0));
//        graph[2].add(new Edge(2, 3));
//        graph[3].add(new Edge(3, 0));

        //Graph 2 false
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));


    }


    public static boolean isCycleUtil(ArrayList<Edge>[] g, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<g[curr].size(); i++) {
            Edge e = g[curr].get(i);
            if(stack[e.dest]) { //if neighBor is already exists in the stack that means cycle exists

                return true;//Cycle Exists
            }
            if(!vis[e.dest] && isCycleUtil(g, e.dest, vis, stack)) { //neibhour unvisted if cycle exist there
                return true;
            }
        }
        stack[curr] = false; // remove curr from stack
        return false;
    }

    public static boolean isCycleDirectedG(ArrayList<Edge>[] g) {
        boolean vis[] = new boolean[g.length];
        boolean stack[] = new boolean[g.length]; //stack

        for(int i=0; i<g.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(g, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }




    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge>[] g = new ArrayList[V];
        createGraph(g);
        System.out.println(isCycleDirectedG(g));
    }
}