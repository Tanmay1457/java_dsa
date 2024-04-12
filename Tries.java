//public class Tries {
//    static class Node{
//        Node children[] = new Node[26];
//        boolean eow = false; //end of word
//
//        public Node(){ //constructor to track data through index
//             for (int i=0; i<26; i++){
//                 children[i] = null;
//             }
//        }
//    }
//
//    public static Node root = new Node(); //by default empty
//
//    //insert O(L).........................
//    public static void insert(String word){ // O(L)
//        Node curr = root;
//        for (int level=0; level<word.length(); level++){
//            int idx = word.charAt(level) - 'a'; // finding index
//            if (curr.children[idx] == null){
//                curr.children[idx] = new Node();
//            }
//            curr = curr.children[idx];
//        }
//        curr.eow = true;
//    }
//
//    //search O(L)..........................
//    public static boolean search(String key){
//        Node curr = root;
//        for (int level=0; level<key.length(); level++){
//            int idx = key.charAt(level) - 'a'; // finding index
//            if (curr.children[idx] == null){
//                return false;
//            }
//            curr = curr.children[idx];
//        }
//        return curr.eow == true;
//    }
//
//    //Word Break Problem O(n)..............................
//    public static boolean wordBreak(String key){
//        if (key.length() == 0){
//            return true;
//        }
//        for(int i=1; i<=key.length(); i++){
//            if (search(key.substring(0,i))&& wordBreak(key.substring(i))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
////         String words[] = {"the","a","there","their","any","thee"};
////         for (int i=0; i<words.length; i++){
////             insert(words[i]);
////         }
////
////        System.out.println(search("thee")); //o/p true
////        System.out.println(search("thor")); //o/p false
//
//
//        String arr[] = {"i","like","sam","samsung","mobile","ice"};
//        for (int i=0; i<arr.length; i++){
//            insert(arr[i]);
//        }
//
//        String key = "ilikesung";
//        System.out.println(wordBreak(key));
//    }
//
//}


//Prefix Problem..........................

//public class Tries {
//
//    static class Node {
//        Node children[] = new Node[26];
//        boolean eow = false;
//        int freq;
//
//        Node() {
//            for (int i = 0; i < 26; i++) {
//                children[i] = null;
//            }
//            freq = 1;
//        }
//    }
//
//    public static Node root = new Node();
//
//    public static void insert(String word) {
//        Node curr = root;
//        for (int i = 0; i < word.length(); i++) {
//            int idx = word.charAt(i) - 'a';
//            if (curr.children[idx] == null) {
//                curr.children[idx] = new Node();
//            } else {
//                curr.children[idx].freq++;
//            }
//            curr = curr.children[idx];
//        }
//        curr.eow = true;
//    }
//
//    public static void findPrefix(Node root, String ans) {
//        if (root == null) {
//            return;
//        }
//
//        if (root.freq == 1) {
//            System.out.println(ans);
//            return;
//        }
//
//        for (int i = 0; i < 26; i++) {
//            if (root.children[i] != null) {
//                findPrefix(root.children[i], ans + (char) (i + 'a'));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        String words[] = { "zebra", "dog", "duck", "dove", "any", "three", "thee" };
//        for (int i = 0; i < words.length; i++) {
//            insert(words[i]);
//        }
//        root.freq = -1;
//        findPrefix(root, "");
//
//    }
//}


//Prefix search.....................................................

// is give word in exist in list of string may be subfix of any words..

//public class Tries {
//
//    static class Node {
//        Node children[] = new Node[26];
//        boolean eow = false;
//
//        Node() {
//            for (int i = 0; i < 26; i++) {
//                children[i] = null;
//            }
//        }
//    }
//
//    public static Node root = new Node();
//
//    public static void insert(String word) {
//        Node curr = root;
//        for (int i = 0; i < word.length(); i++) {
//            int idx = word.charAt(i) - 'a';
//            if (curr.children[idx] == null) {
//                curr.children[idx] = new Node();
//            }
//            curr = curr.children[idx];
//        }
//        curr.eow = true;
//    }
//
//    public static boolean search(String key) {
//        Node curr = root;
//        for (int i = 0; i < key.length(); i++) {
//            int idx = key.charAt(i) - 'a';
//            if (curr.children[idx] == null) {
//                return false;
//            }
//            curr = curr.children[idx];
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        String words[] = { "the", "a", "there", "their", "any", "three", "thee" };
//        for (int i = 0; i < words.length; i++) {
//            insert(words[i]);
//        }
//        System.out.println(search("po"));
//    }
//}

//Count unique substring.........................................................

// find the all unique subString of given String.

//public class Tries{
//
//    static class Node {
//        Node children[] = new Node[26];
//        boolean eow = false;
//
//        Node() {
//            for (int i = 0; i < 26; i++) {
//                children[i] = null;
//            }
//        }
//    }
//
//    public static Node root = new Node();
//
//    public static void insert(String word) {
//        Node curr = root;
//        for (int i = 0; i < word.length(); i++) {
//            int idx = word.charAt(i) - 'a';
//            if (curr.children[idx] == null) {
//                curr.children[idx] = new Node();
//            }
//            curr = curr.children[idx];
//        }
//        curr.eow = true;
//    }
//
//    public static boolean search(String key) {
//        Node curr = root;
//        for (int i = 0; i < key.length(); i++) {
//            int idx = key.charAt(i) - 'a';
//            if (curr.children[idx] == null) {
//                return false;
//            }
//            curr = curr.children[idx];
//        }
//        return curr.eow == true;
//    }
//
//    public static int countNode(Node root) {
//        if (root == null) {
//            return 0;
//        }
//        int count = 0;
//        for (int i = 0; i < 26; i++) {
//            if (root.children[i] != null) {
//                count += countNode(root.children[i]);
//            }
//        }
//        return count + 1;
//    }
//
//    public static void main(String[] args) {
//        String str = "ababa";
//        for (int i = 0; i < str.length(); i++) {
//            String suffix = str.substring(i);
//            insert(suffix);
//        }
//
//        System.out.println(countNode(root));
//    }
//}


//Largest word with all prefix.....................................................

// in give list find the largest word with contain with there prefix.

public class Tries {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static String ans = "";

    public static void largestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a'); //typecasting
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                largestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        largestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}