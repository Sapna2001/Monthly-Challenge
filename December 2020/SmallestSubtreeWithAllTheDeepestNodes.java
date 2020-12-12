/*
Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

Note: This question is the same as 1123: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest nodes of the tree.
Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them, so we return it.

Input: root = [1]
Output: [1]
Explanation: The root is the deepest node in the tree.

Input: root = [0,1,3,null,2]
Output: [2]
Explanation: The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.

*/

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth>rightDepth)
            return subtreeWithAllDeepest(root.left);
        else if(rightDepth>leftDepth)
            return subtreeWithAllDeepest(root.right);
        else
            return root;
        
    }
    
    public int depth(TreeNode node){
        if (node == null)
            return 0;
        return 1+ Math.max(depth(node.left),depth(node.right));
    }
}
