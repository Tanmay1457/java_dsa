import java.util.*;

public class Binary_ST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    //Mirror image.....................
    
    public static Node mirrorBst(Node root) { //create mirror image O(n)
        if(root == null) {
            return root;
        }

        Node rootLeft = mirrorBst(root.left);
        Node rootRight = mirrorBst(root.right);

        root.left = rootRight;
        root.right = rootLeft;
        return root;
    }

    public static void preorder(Node root) { //for checking
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //sorted array to BST
    public static Node convertToBST(int arr[], int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node curr = new Node(arr[mid]);
        curr.left = convertToBST(arr, st, mid-1);
        curr.right = convertToBST(arr, mid+1, end);
        return curr;
    }

    //convert bst to balanced bst O(n).........

    //This Function Creates Balanced BST of Sorted ArrayList.
    //Time Complexity: O(n)*/
    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) { //Base Case.
            return null;
        }

        //Work: Find middle & Join to the Node.
        int middle = (start + end) / 2; //Calculating Middle of ArrayList.
        Node root = new Node(inorder.get(middle)); //Creating Node using 'middle' as an index of ArrayList.

        root.left = createBST(inorder, start, middle - 1); //Recursive call for Left Subtree.
        root.right = createBST(inorder, middle + 1, end); //Recursive call for Right Subtree.

        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balanceBST(Node root) {
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);
        //sorted inorder to balanced bst
        root = createBST(inorder,0,inorder.size()-1);
        return root;
    }
    public static int height(Node root) {
        if(root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //size of largest BST in BT
    static class Info {
        boolean isBST;
        int size;
        int max;
        int min;

        public Info(boolean isBST, int size, int max, int min) { //constructor
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxBST = 0;
    public static Info largestBST(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, max, min);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, max, min);
        }

        return new Info(false, size, max, min);
    }



    public static void main(String args[]) {
        /*
                    8
                   / \
                  5   10
                 / \    \
                3   6    11
         */
//        Node root = new Node(8);
//        root.left = new Node(5);
//        root.right = new Node(10);
//        root.left.left = new Node(3);
//        root.left.right = new Node(6);
//        root.right.right = new Node(11);

        /*
                    8
                   / \
                  10  5
                 /   / \
                11  6   3
                Mirror BST
         */

//        mirrorBst(root);
//        preorder(root);

          int arr[] = {3,5,6,8,10,11,12};
           /*
        Expected BST:
                    8
                  /   \
                 5     11
                / \   /  \
               3   6 10  12
         */
//         Node root = convertToBST(arr,0, arr.length-1);
//         preorder(root);

         //convert bst to balanced bst
          /*
                     8
                   /   \
                  6     10
                 /       \
                5         11
               /           \
              3             12
            given BST
         */
//        Node root = new Node(8);
//        root.left = new Node(6);
//        root.left.left = new Node(5);
//        root.left.left.left = new Node(3);
//
//        root.right = new Node(10);
//        root.right.right = new Node(11);
//        root.right.right.right = new Node(12);

        /*
                     8
                   /   \
                  5     11
                 / \    / \
                3   6  10 12
            expected BST
         */
//        root = balanceBST(root);
//        preorder(root);


        /*
                       50
                     /    \
                  30       60
                 /  \     /  \
                5   20   45    70
                              /  \
                            65    80

                    given BT
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /*
                     60
                    /  \
                  45    70
                       /  \
                     65    80
            expected BST size=5
        */
        Info info = largestBST(root);
        System.out.println("largest BST size = "+maxBST);

        //merge two BST
        /*
                  2
                 / \
                1   4
                BST1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
                  9
                 / \
                3   12
                BST2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);


    }
}