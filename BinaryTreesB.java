//Binary_tree_preorder using build tree O(n)
import java.util.*;


//public class BinaryTreesB{
//
//    static class Node{
//        int data;
//        Node left;
//        Node right;
//
//        //constructor of node
//        Node(int data){
//            this.data = data;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//    //another class to build a tree
//    static class BinaryTree{
//        /*we will treverse the whole tree index wise and at first only
//        we will increase the index so basical we will start with zero*/
//
//        static int idx = -1;
//        public static Node buildTree(int nodes[]){ //parameter that is passed is the full array of nodes
//            idx++; // now it is 0
//            //base case we will stop at null node
//            if(nodes[idx] == -1){
//                return null;
//            }
//
//            Node newNode = new Node(nodes[idx]);
//            newNode.left = buildTree(nodes);
//            newNode.right = buildTree(nodes);
//
//            return newNode;
//        }
//
//        //Preorder Traversal O(n)
//        public static void preorder(Node root){
//            if (root == null){
//                return;
//            }
//            System.out.print(root.data+" ");
//            preorder(root.left);
//            preorder(root.right);
//        }
//
//        //Inorder Traversal O(n)
//        public static void inorder(Node root){
//            if (root == null){
//                return;
//            }
//            inorder(root.left);
//            System.out.print(root.data+" ");
//            inorder(root.right);
//        }
//
//        //Postorder Traversal O(n)
//        public static void postorder(Node root){
//            if (root == null){
//                return;
//            }
//            postorder(root.left);
//            postorder(root.right);
//            System.out.print(root.data+" ");
//        }
//
//        //Level Order Traversal (using Queue)
//        public static void levelorder(Node root){
//            if (root == null){
//                return;
//            }
//            Queue<Node> q = new LinkedList<>();
//            q.add(root);
//            q.add(null);
//
//            while (!q.isEmpty()){
//                Node currNode = q.remove();
//                if (currNode == null){
//                    System.out.println();
//                    if (q.isEmpty()){
//                        break;
//                    }
//                    else {
//                        q.add(null);
//                    }
//                }
//                else {
//                    System.out.print(currNode.data+" ");
//                    if (currNode.left != null){
//                        q.add(currNode.left);
//                    }
//                    if (currNode.right != null){
//                        q.add(currNode.right);
//                    }
//                }
//            }
//        }
//    }
//
//
//    public static void main(String args[]){
//
//        int nodes []  = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//
//        BinaryTree tree = new BinaryTree();
//        Node root = tree.buildTree(nodes);
//        //verifying as we know the root will be one
//        System.out.println(root.data);
//
//        //preorder
//        System.out.println("Preorder sequence");
//        tree.preorder(root);
//
//        System.out.println();
//
//        //inorder
//        System.out.println("Inorder sequence");
//        tree.inorder(root);
//
//        System.out.println();
//
//        //postorder
//        System.out.println("Postorder sequence");
//        tree.postorder(root);
//
//        System.out.println();
//
//        //postorder
//        System.out.println("Levelorder sequence");
//        tree.levelorder(root);
//    }
//
//}

//Height of tree...........................

public class BinaryTreesB {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //Count the Nodes of a Binary Tree. O(n).............................
    public static int count(Node root) {
        if (root == null) { //Base Case.
            return 0;
        }

        int leftCount = count(root.left); //Counting Nodes of Left Subtree.
        int rightCount = count(root.right); //Counting Nodes of Right Subtree.

        return leftCount + rightCount + 1; //Adding Counts of both side & adding +1 in it and Return.
    }

    //Sum of Nodes. O(n)...........................................
    public static int sum(Node root) {
        if (root == null) { //Base Case.
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    //Diameter of Tree: Approach-1 O(n^2) i.e on n node we require O(n) time to calculate height

    public static int diameter2(Node root) {
        if (root == null) { //Base Case.
            return 0;
        }

        int leftDiameter = diameter2(root.left); //1st
        int leftHeight = height(root.left); //Calculating Left Height for Self Diameter.
        int rightDiameter = diameter2(root.right); //2nd
        int rightHeight = height(root.right); //Calculating Right Height for Self Diameter.

        int selfDiameter = leftHeight + rightHeight + 1; //3rd

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    //Diameter of Tree: Approach-2 O(n)...............

    static class Info {

        int diameter;
        int height;

        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) { //Base Case
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        //on single node our diameter and height will be calculated at a constant time O(n)
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(diameter, height);
    }

     

    public static void main(String args[]) {
        /*
                    1
                   / \
                  2   3
                 / \  / \
                4   5 6   7
        */
        // tree construction...
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Height of tree :");
        System.out.println(height(root));

        System.out.println("Count = "+ count(root));

        System.out.println("Sum = "+sum(root));

        System.out.println("Diameter Approach1 ="+diameter2(root));

        System.out.println("Diameter Approach2 ="+diameter(root).diameter);//returing diameter of info object
        // System.out.println("Height of tree Approach2 ="+diameter(root).height);





    }
}