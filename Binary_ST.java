import java.util.*;

public class Binary_ST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) { //go to left subtree
            root.left = insert(root.left, val);
        } else { // go to right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    //Search in BST. O(H) (PS: H is a Height of a Tree from Root to Leaf)
    public static boolean search(Node root, int key) {
        if (root == null) { //Base Case.
            return false;
        }

        if (root.data == key) { //Checking for if Root == Key
            return true;
        } else if (root.data > key) { //If Root is > Key
            return search(root.left, key); //Go To Left Subtree.
        } else {
            return search(root.right, key); //Go To Right Subtree.
        }
    }

    public static Node delete(Node root, int val) {
        if(root == null) {
            return null;
        }

        else if(root.data > val) {
            root.left = delete(root.left, val);
        }

        else if(root.data < val) {
            root.right = delete(root.right, val);
        }

        else {
            //case 1
            if(root.left == null && root.right == null) {
                return null;
            }

            //case 2
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //case 3
            else {
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while(root.left!=null) {
            root = root.left;
        }

        return root;
    }

    //Print in Range.
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) { //Base Case.
            return;
        }

        if (root.data >= k1 && root.data <= k2) { //If Root lies between k1 & k2.
            printInRange(root.left, k1, k2); //Go To Left.
            System.out.print(root.data + " "); //Print Root Data.
            printInRange(root.right, k1, k2); //Go To Right.
        } else if (root.data < k1) { //If Root Data is < than k1
            printInRange(root.left, k1, k2); //Go To Left.
        } else {
            printInRange(root.right, k1, k2); //Go To Right.
        }
    }

    //Root to Leaf path. (Print)
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) { //Base Case.
            return;
        }

        path.add(root.data); //Adding Data of Root in ArrayList.
        if (root.left == null && root.right == null) { //If we reach on Leaf Node
            printPath(path); //Print the Path.
        }

        printRoot2Leaf(root.left, path); //Call for Left Subtree.
        printRoot2Leaf(root.right, path); //Call for Right Subtree.
        path.remove(path.size() - 1); //Removing Elements while Backtracking.
    }

    //Utility Function of printRoot2Leaf() method.
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    //Validate BST: BST must satisfy all the properties of BST.
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) { //Base Case.
            return true;
        }

        //Checking some Basic Validation Cases.
        if (min != null && root.data <= min.data) { //For Left Subtree: Min = -∞ & Max = Root/Parent
            return false;
        } else if (max != null && root.data >= max.data) { //For Right Subtree: Min = Root/Parent & Max = +∞
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String args[]) {
        Node root = null;
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 2)) {
            System.out.print("Key Found");
        } else {
            System.out.println("Key NOT Found");
        }

//        root = delete(root, 5);
//        inorder(root);

        System.out.println();
        printInRange(root,5,12);
        System.out.println();

        System.out.println("Possible path");
        printRoot2Leaf(root, new ArrayList<>());

        if (isValidBST(root,null,null)){
            System.out.println("valid");
        }else {
            System.out.println("not valid");
        }

    }
}