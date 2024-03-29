import java.util.*;

public class BinaryTreesB_1 {
    // Subtree of another Tree. (Find SubTree is existed in your Tree or NOT.)............

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }

        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Top View of Binary tree (using Hashmap)................
    static class Info {
        Node node;
        int hd; // horizontal distance

        public Info(Node node, int hd) { // constructor
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null); // for next level

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // True if it contains key, False if not.
                if (!map.containsKey(curr.hd)) { // First Time my HD(horizontal distance) is occurring.
                    map.put(curr.hd, curr.node); // Adding pair in within a map.
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) { // min to max HD
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    // Kth Level of a Tree (Print). O(n)
    public static void KthLevel(Node root, int level, int k) {
        if (root == null) { // Base Case.
            return;
        }
        if (level == k) { // If level is equals to K, then print the node data and return.
            System.out.print(root.data + " ");
            return;
        }

        KthLevel(root.left, level + 1, k);
        KthLevel(root.right, level + 1, k);
    }

    // Approach-1: Lowest Common Ancestor (LCA). TC & SC: O(n)..........
    public static boolean rootToNodePath(Node root, int node, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }

        path.add(root);

        if(root.data == node) {
            return true;
        }

        if(root.left != null && rootToNodePath(root.left, node, path)) {
            return true;
        }
        if(root.right != null && rootToNodePath(root.right, node, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    //Approach 2 - Find first node which found n1 & n2 in it's subtrees
    public static Node lca2(Node root, int n1, int n2) {
        //Base Case is included in this sentence.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        //CASE: leftLCA = value & rightLCA = null
        if (rightLca == null) {
            return leftLca;
        }
        //CASE: leftLCA = null & rightLCA = value
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        rootToNodePath(root, n1, path1);
        rootToNodePath(root, n2, path2);

        int i=0;
        for(;i<path1.size() && i<path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }

        return path1.get(i-1);
    }

    //Minimum Distance between two nodes.....................................
    public static int lcaDistance(Node root, int n) {
        if (root == null) { //Base Case.
            return -1;
        }

        if (root.data == n) { //If Root.data itself is equals to n.
            return 0;
        }

        int leftDistance = lcaDistance(root.left, n); //Searching on Left Subtree.
        int rightDistance = lcaDistance(root.right, n); //Searching on Right Subtree.

        if (leftDistance == -1 && rightDistance == -1) { //If both subtrees returns -1 -> return -1.
            return -1;
        } else if (leftDistance == -1) { //Case: If N found on Left Subtree.
            return rightDistance + 1;
        } else { //Case: If N found on Right Subtree.
            return leftDistance + 1;
        }
    }

    public static int minimumDistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2); //Calculating Lowest Common Ancestor.

        int distance1 = lcaDistance(lca, n1);
        int distance2 = lcaDistance(lca, n2);

        return distance1 + distance2;
    }

    //Kth Ancestor of node..............
    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) { //Base Case.
            return -1;
        }

        if (root.data == n) { //Checking root itself == N or NOT.
            return 0;
        }

        //If N not found on root then find it on Left & Right Subtrees.
        int leftDistance = kthAncestor(root.left, n, k);
        int rightDistance = kthAncestor(root.right, n, k);

        if (leftDistance == -1 && rightDistance == -1) { //If Left and Right Subtrees return -1 -> return -1
            return -1;
        }

        int maximum = Math.max(leftDistance, rightDistance); //Find max distance between Left & Right Subtree.

        if (maximum + 1 == k) { //Checking max & myself count that is 1 == k or NOT.
            System.out.print(root.data);
        }

        return maximum + 1;
    }

    //Transform to Sum Tree. O(n).......................
    public static int transformSumTree(Node root) {
        if (root == null) { //Base Case.
            return 0;
        }
        int leftChild = transformSumTree(root.left); //Old Left Child Value.
        int rightChild = transformSumTree(root.right); //Old Right Child Value.

        int data = root.data; //Storing value of root in 'data' variable.

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = (newLeft + leftChild) + (newRight + rightChild);

        return data;
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {

        /* main tree
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /* subtree
          2
         /  \
         4   5

         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("Is subtree = " + isSubtree(root, subRoot));

        System.out.print("Top view of tree is = ");
        topView(root);

        int k = 2;
        System.out.print("Kth Level of tree ");
        KthLevel(root, 1, k);


        System.out.println();
        System.out.println("Lowest Common Ancestor Approach 1 = " + lca(root, 4, 5).data);

        //Approach 2
        System.out.println("Lowest Common Ancestor Approach 2 = " + lca2(root, 4, 6).data);

        System.out.println("Minimum Distance between two node = "+minimumDistance(root,4,5));

        System.out.print("Kth Ancestor is = ");
        int n=5,K=2;
        kthAncestor(root,n,K);
        System.out.println();

        System.out.println("Transform to sum tree is ");
        //Transform  to sum tree
        transformSumTree(root);
        preorder(root);
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7

                expected sum tree is :

                    27
                   /  \
                  9    13
                 / \   / \
                0   0 0   0
        */
    }
}
