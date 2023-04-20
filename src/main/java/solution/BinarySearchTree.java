package solution;

class BinarySearchTree {

    /** An inner class representing a node in a BST tree */
    private class BSTNode {
        int data; // value stored at the node
        BSTNode left; // left subtree
        BSTNode right; // right subtree

        BSTNode(int newdata) {
            data = newdata;
        }
    }

    private BSTNode root; // the root of the tree, an instance variable of class BinarySearchTree

    BinarySearchTree() {
        root = null; // initially, the tree is empty
    }


    /**
     * Check if the two trees, given by root1 and root2, are equal
     * Returns true if the trees have the same structure,
     * and the values at the corresponding nodes are the same.
     * @param root1 root of the first tree
     * @param root2 root of the second tree
     * @return
     */
    public static boolean checkIfIdentical(BSTNode root1, BSTNode root2) {
        // FILL IN CODE
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.data != root2.data)
            return false;
        return checkIfIdentical(root1.left, root2.left) && checkIfIdentical(root1.right, root2.right);
    }

    /**
     * Returns the number of the nodes in the binary tree with the given root
     * @param root root of the tree
     * @return number of nodes in the tree with the given root
     */
    public int numNodes(BSTNode root) {
        if (root == null)
            return 0;
        return numNodes(root.left) + numNodes(root.right) + 1;
        //return 0;
    }

    /**
     * Returns the largest value in the binary search tree with the given root
     * @param root root of the tree
     * @return largest value
     */
    public int findLargest(BSTNode root) {
        BSTNode current = root;
        if (current == null)
            throw new IllegalArgumentException();
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
    /**
     * Insert a given element into the BST tree
     * @param elem element to insert into the BST tree
     */
    public void insert(int elem) {
        root = insert(root, elem);
    }

    /**
     * Insert elem into the tree with the given root
     * @param tree root of a tree
     * @param elem element to insert
     * @return the root of a tree that contains the new node
     */
    private BSTNode insert(BSTNode tree, int elem) {
        if (tree == null) {
            return new BSTNode(elem);
        }
        if (elem < tree.data) {
            tree.left = insert(tree.left, elem);
            return tree;
        } else {
            tree.right = insert(tree.right, elem);
            return tree;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.insert(4);
        tree1.insert(12);
        tree1.insert(10);
        tree1.insert(25);
        tree1.insert(3);
        tree1.insert(1);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.insert(4);
        tree2.insert(12);
        tree2.insert(10);
        tree2.insert(25);
        tree2.insert(3);
        tree2.insert(1);

        BinarySearchTree tree3 = new BinarySearchTree();
        tree3.insert(4);
        tree3.insert(1);
        tree3.insert(3);
        tree3.insert(25);
        tree3.insert(10);
        tree3.insert(12);

        System.out.println(checkIfIdentical(tree1.root, tree2.root)); //true
        System.out.println(checkIfIdentical(tree1.root, tree3.root)); // false

        System.out.println(tree1.numNodes(tree1.root));
        System.out.println(tree1.findLargest(tree1.root));
    }
}
