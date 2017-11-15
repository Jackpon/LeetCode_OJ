/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
题意：求树的最浅深度
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
/*
思路：
	与算树的深度思路一样，需要处理的是单节点和双节点
	单节点时： 取最深子树+1
	双节点时： 取最浅子树+1
*/
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root == NULL)
            return 0;
        int depl = minDepth(root->left);
        int depr = minDepth(root->right);
        if (root->left == NULL || root->right == NULL)
		return (depl>depr?depl:depr)+1;
        else {
            if (depl < depr)
                return depl + 1;
            else
                return depr + 1;
        }
    }
};